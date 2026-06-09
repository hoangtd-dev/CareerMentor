package models.base;

import java.math.BigDecimal;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import constants.BankEnum;

@Getter
@Setter
public abstract class BankCard {
	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	private final BigDecimal minBalance = new BigDecimal("20");

	private BankEnum bankName;
	private String cardNumber;
	private BigDecimal balance;
	private String userId;
	private String fullname;

	protected abstract BigDecimal getMinimumDeposit();

	protected abstract BigDecimal getWithdrawLimit();

	public abstract String getBalanceMessage();

	public abstract int numberOfTransactionDisplayed();

	public BankCard(BankEnum bankName, String cardNumber, BigDecimal balance, String userId, String fullname) {
		this.bankName = bankName;
		this.cardNumber = cardNumber;
		this.balance = balance;
		this.userId = userId;
		this.fullname = fullname;
	}

	public boolean deposit(BigDecimal amount) {
		if (amount.compareTo(getMinimumDeposit()) == -1)
			return false;

		balance = balance.add(amount);
		return true;
	}

	public boolean withdraw(BigDecimal amount) {
		if (amount.compareTo(getWithdrawLimit()) == 1 || balance.subtract(amount).compareTo(minBalance) == -1)
			return false;

		balance = balance.subtract(amount);
		return true;
	}

	public String getMaskCardNumber() {
		return "******" + cardNumber.substring(5);
	}

	public String mappingToRawData() {
		return String.format("%s,%s,%s,%s,%s", bankName, cardNumber, balance.toPlainString(), userId, fullname);
	}
}
