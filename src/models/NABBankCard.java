package models;

import java.math.BigDecimal;

import enums.BankEnum;
import lombok.Getter;
import lombok.Setter;

import models.base.BankCard;

@Getter
@Setter
public class NABBankCard extends BankCard {
	private BigDecimal minimumDeposit = new BigDecimal("10");
	private BigDecimal withdrawLimit = new BigDecimal("2000");

	public NABBankCard(String cardNumber, BigDecimal balance, String userId, String fullname) {
		super(BankEnum.NAB, cardNumber, balance, userId, fullname);
	}

	@Override
	public String getBalanceMessage() {
		return String.format("Hi %s, your card balance on NAB bank is %s", getFullname(), getBalance().toPlainString());
	}

	@Override
	public int numberOfTransactionDisplayed() {
		return 10;
	}
}
