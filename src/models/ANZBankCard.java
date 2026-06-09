package models;

import java.math.BigDecimal;

import constants.BankEnum;
import lombok.Getter;
import lombok.Setter;

import models.base.BankCard;

@Getter
@Setter
public class ANZBankCard extends BankCard {
	private BigDecimal minimumDeposit = new BigDecimal("10");
	private BigDecimal withdrawLimit = new BigDecimal("1000");

	public ANZBankCard(String cardNumber, BigDecimal balance, String userId, String fullname) {
		super(BankEnum.ANZ, cardNumber, balance, userId, fullname);
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
	public String getBalanceMessage() {
		return String.format("Your ANZ account %s balance is %s", getMaskCardNumber(), getBalance().toPlainString());
	}

	@Override
	public int numberOfTransactionDisplayed() {
		throw new UnsupportedOperationException("ANZ Bank does not support this future !!!");
	}
}
