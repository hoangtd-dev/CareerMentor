package services;

import java.math.BigDecimal;
import java.util.List;

import enums.TransactionTypeEnum;
import interfaces.IRepository;
import models.Transaction;

public class TransactionService {
	private final IRepository<Transaction> transactionRepository;

	public TransactionService(IRepository<Transaction> transactionRepository) {
		this.transactionRepository = transactionRepository;
	}

	public List<Transaction> getTransactionsByCardNumber(List<Transaction> transactions, String cardNumber) {
		return transactions.stream()
				.filter(transaction -> transaction.getCardNumber().equals(cardNumber))
				.toList();
	}

	public void createTransaction(TransactionTypeEnum type, BigDecimal amount, String cardNumber) {
		List<Transaction> transactions = transactionRepository.load();

		transactions.add(new Transaction(type, amount, cardNumber));

		transactionRepository.save(transactions);
	}

	public List<Transaction> getTransactionHistory(String cardNumber, int take) {
		List<Transaction> transactions = transactionRepository.load();

		List<Transaction> result = getTransactionsByCardNumber(transactions, cardNumber);

		return result.subList(Math.max(0, result.size() - take), result.size());
	}
}
