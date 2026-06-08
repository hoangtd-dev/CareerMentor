package models;

import java.math.BigDecimal;

import constants.BankEnum;
import lombok.Getter;
import lombok.Setter;

import models.base.BankAccount;

@Getter
@Setter
public class ANZBankAccount extends BankAccount {
	private BigDecimal minimumDeposit = new BigDecimal("10");
	private BigDecimal withdrawLimit = new BigDecimal("1000");

	public ANZBankAccount(String cardNumber, BigDecimal balance, String userId) {
		super(BankEnum.ANZ, cardNumber, balance, userId);
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
		System.out.println(String.format("Your ANZ account %d balance is %d", getCardNumber(), getBalance().toPlainString()));
	}
}
