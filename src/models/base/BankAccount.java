package models.base;

import java.math.BigDecimal;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import constants.BankEnum;

@Getter
@Setter
public abstract class BankAccount {
	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	private final BigDecimal minBalance = new BigDecimal("20");

	private BankEnum bankName;
	private String cardNumber;
	private BigDecimal balance;
	private String userId;

	protected abstract BigDecimal getMinimumDeposit();

	protected abstract BigDecimal getWithdrawLimit();

	protected abstract void viewBalance();

	public BankAccount(BankEnum bankName, String cardNumber, BigDecimal balance, String userId) {
		this.bankName = bankName;
		this.cardNumber = cardNumber;
		this.balance = balance;
		this.userId = userId;
	}

	protected boolean deposit(BigDecimal amount) {
		if (getMinimumDeposit().compareTo(amount) < 0)
			return false;

		balance = balance.add(amount);
		return true;
	}

	protected boolean withdraw(BigDecimal amount) {
		if (getWithdrawLimit().compareTo(amount) > 0 || balance.subtract(amount).compareTo(minBalance) < 0)
			return false;

		balance = balance.subtract(amount);
		return true;
	}

	public String getCardNumber() {
		return "******" + cardNumber.substring(5);
	}

	public String mappingToRawData() {
		return String.format("%d,%d,%d,%d", bankName, cardNumber, balance.toPlainString(), userId);
	}
}
