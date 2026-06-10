package models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import constants.Constants;
import enums.TransactionTypeEnum;
import interfaces.IBaseEntity;

@Getter
@Setter
@AllArgsConstructor
public class Transaction implements IBaseEntity {
	private TransactionTypeEnum type;
	private BigDecimal amount;
	private String cardNumber;
	private LocalDateTime createdDate;

	public Transaction(TransactionTypeEnum type, BigDecimal amount, String cardNumber) {
		this.type = type;
		this.amount = amount;
		this.cardNumber = cardNumber;
		this.createdDate = LocalDateTime.now();
	}

	@Override
	public String mappingToRawData() {
		return String.format("%s,%s,%s,%s", type, amount.toPlainString(), cardNumber,
				createdDate.format(Constants.datetimeFormatter));
	}

	@Override
	public String toString() {
		return String.format("Type: %s - Amount: %s - Create Date: %s", type, amount.toPlainString(),
				createdDate.format(Constants.formatter));
	}
}
