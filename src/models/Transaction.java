package models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

import constants.TransactionTypeEnum;

@Getter
@Setter
public class Transaction {
	private TransactionTypeEnum type;
	private BigDecimal amount;
	private String accountNumber;
	private LocalDateTime createdDate;

	public Transaction(TransactionTypeEnum type, BigDecimal amount, String accountNumber, LocalDateTime createdDate) {
	}

	public String mappingToRawData() {
		return String.format("%d,%d,%d,%d", type, amount.toPlainString(), accountNumber, createdDate);
	}

	@Override
	public String toString() {
		return String.format("Type: %d - Amount: %d - Create Date: %d", type, amount.toPlainString(), createdDate.toString());
	}
}
