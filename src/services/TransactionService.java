package services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import constants.TransactionTypeEnum;
import models.Transaction;
import repositories.TransactionRepository;

public class TransactionService {
	private final TransactionRepository transactionRepository;

	public TransactionService(TransactionRepository transactionRepository) {
		this.transactionRepository = transactionRepository;
	}

	public List<Transaction> getTransactionsByCardNumber(ArrayList<Transaction> transactions, String cardNumber) {
		try {
			return transactions.stream()
					.filter(transaction -> transaction.getCardNumber().equals(cardNumber))
					.toList();
		} catch (Exception e) {
			return null;
		}
	}

	public void createTransaction(TransactionTypeEnum type, BigDecimal amount, String cardNumber) {
		ArrayList<Transaction> transactions = transactionRepository.load();

		transactions.add(new Transaction(type, amount, cardNumber));

		transactionRepository.save(transactions);
	}

	public List<Transaction> getTransactionHistory(String cardNumber, int take) {
		ArrayList<Transaction> transactions = transactionRepository.load();

		List<Transaction> result = getTransactionsByCardNumber(transactions, cardNumber);

		return result.subList(Math.max(0, result.size() - take), result.size());
	}
}
