package models;

import java.math.BigDecimal;

import enums.BankEnum;
import lombok.Getter;
import lombok.Setter;

import models.base.BankCard;

@Getter
@Setter
public class CMWBankCard extends BankCard {
	private BigDecimal minimumDeposit = new BigDecimal("5");
	private BigDecimal withdrawLimit = new BigDecimal("3000");

	public CMWBankCard(String cardNumber, BigDecimal balance, String userId, String fullname) {
		super(BankEnum.CMW, cardNumber, balance, userId, fullname);
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
		return String.format("CMW bank account with number %s has balance is %s", getMaskCardNumber(),
				getBalance().toPlainString());
	}

	@Override
	public int numberOfTransactionDisplayed() {
		throw new UnsupportedOperationException("CMW Bank does not support this future !!!");
	}
}
