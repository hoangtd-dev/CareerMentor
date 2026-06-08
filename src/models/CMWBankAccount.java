package models;

import java.math.BigDecimal;

import constants.BankEnum;
import lombok.Getter;
import lombok.Setter;

import models.base.BankAccount;

@Getter
@Setter
public class CMWBankAccount extends BankAccount  {
	private BigDecimal minimumDeposit = new BigDecimal("5");
	private BigDecimal withdrawLimit = new BigDecimal("3000");

	public CMWBankAccount(String cardNumber, BigDecimal balance, String userId) {
		super(BankEnum.CMW, cardNumber, balance, userId);
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
		System.out.println((String.format("CMW bank account with number %d has balance is %d", getCardNumber(), getBalance().toPlainString())));
	}
}
