package services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import constants.BankEnum;
import constants.TransactionTypeEnum;
import interfaces.IRepository;
import models.ANZBankCard;
import models.CMWBankCard;
import models.NABBankCard;
import models.User;
import models.base.BankCard;

public class BankCardService {
	private final IRepository<BankCard> cardRepository;
	private final AuthService authService;
	private final TransactionService transactionService;

	public BankCardService(IRepository<BankCard> cardRepository, TransactionService transactionService,
			AuthService authService) {
		this.cardRepository = cardRepository;
		this.authService = authService;
		this.transactionService = transactionService;
	}

	public BankCard getCurrentCard() {
		ArrayList<BankCard> cards = this.cardRepository.load();
		return getCurrentCard(cards);
	}

	public boolean registerNewCard(BankEnum bankName, String cardNumber, BigDecimal balance) {
		if (!cardNumber.matches("\\d{10}")) 
			throw new IllegalArgumentException("Card number must have 10 digit");

		ArrayList<BankCard> cards = cardRepository.load();

		boolean isExisted = isCardNumberExisted(cards, cardNumber);

		if (isExisted) {
			return false;
		}

		User user = authService.getUser();
		String fullname = String.format("%s %s", user.getFirstname(), user.getLastname());

		cards.add(switch (bankName) {
			case BankEnum.ANZ -> new ANZBankCard(cardNumber, balance, user.getId(), fullname);
			case BankEnum.NAB -> new NABBankCard(cardNumber, balance, user.getId(), fullname);
			case BankEnum.CMW -> new CMWBankCard(cardNumber, balance, user.getId(), fullname);
			default -> throw new IllegalArgumentException("Bank does not exist");
		});

		cardRepository.save(cards);

		return true;
	}

	public void deposit(BigDecimal amount) {
		ArrayList<BankCard> cards = cardRepository.load();
		BankCard currentCard = getCurrentCard(cards);

		boolean result = currentCard.deposit(amount);

		if (result) {
			cardRepository.save(cards);
			transactionService.createTransaction(TransactionTypeEnum.Deposit, amount, currentCard.getCardNumber());
			return;
		}

		switch (currentCard.getBankName()) {
			case BankEnum.ANZ -> throw new IllegalArgumentException("Minimum deposit amount of ANZ bank: $10");
			case BankEnum.NAB -> throw new IllegalArgumentException("Minimum deposit amount of NAB bank: $10");
			case BankEnum.CMW -> throw new IllegalArgumentException("Minimum deposit amount of CMW bank: $5");
			default -> throw new IllegalArgumentException("Bank does not exist");
		}
	}

	public void withdraw(BigDecimal amount) {
		ArrayList<BankCard> cards = cardRepository.load();
		BankCard currentCard = getCurrentCard(cards);

		boolean result = currentCard.withdraw(amount);

		if (result) {
			cardRepository.save(cards);
			transactionService.createTransaction(TransactionTypeEnum.Withdraw, amount, currentCard.getCardNumber());
			return;
		}

		switch (currentCard.getBankName()) {
			case BankEnum.ANZ -> throw new IllegalArgumentException(
					"Maximum withdraw amount of ANZ bank: $1000 per transaction and account should remain at least $20");
			case BankEnum.NAB -> throw new IllegalArgumentException(
					"Maximum withdraw amount of NAB bank: $2000 per transaction and account should remain at least $20");
			case BankEnum.CMW -> throw new IllegalArgumentException(
					"Maximum withdraw amount of CMW bank: $3000 per transaction and account should remain at least $20");
			default -> throw new IllegalArgumentException("Bank does not exist");
		}
	}

	public String getBalanceMessage() {
		ArrayList<BankCard> cards = cardRepository.load();
		BankCard currentCard = getCurrentCard(cards);

		return currentCard.getBalanceMessage();
	}

	public boolean hasCard() {
		ArrayList<BankCard> cards = cardRepository.load();
		BankCard currentCard = getCurrentCard(cards);

		return currentCard != null;
	}

	private BankCard getCurrentCard(ArrayList<BankCard> cards) {
		String userId = authService.getUser().getId();

		try {
			return cards.stream()
					.filter(card -> card.getUserId().equals(userId))
					.toList()
					.getLast();
		} catch (Exception e) {
			return null;
		}
	}

	private boolean isCardNumberExisted(List<BankCard> cards, String cardNumber) {
		return cards.stream().anyMatch(card -> card.getCardNumber().equals(cardNumber));
	}
}
