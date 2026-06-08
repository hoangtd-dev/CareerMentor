package models;

import java.math.BigDecimal;

import constants.BankEnum;
import lombok.Getter;
import lombok.Setter;

import models.base.BankAccount;

@Getter
@Setter
public class NABBankAccount extends BankAccount {
	private BigDecimal minimumDeposit = new BigDecimal("10");
	private BigDecimal withdrawLimit = new BigDecimal("2000");

	private String fullname;

	public NABBankAccount(String cardNumber, BigDecimal balance, String userId) {
		super(BankEnum.NAB, cardNumber, balance, userId);
	}

	@Override
	protected BigDecimal getMinimumDeposit() {
		return minimumDeposit;
	}

	@Override
	protected BigDecimal getWithdrawLimit() {
		return withdrawLimit;
	}

	@Override
	protected void viewBalance() {
		System.out.println((String.format("Hi %d, your card balance on NAB bank is %d", fullname, getBalance().toPlainString())));
	}
}
