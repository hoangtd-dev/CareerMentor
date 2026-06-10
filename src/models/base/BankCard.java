package models.base;

import java.math.BigDecimal;

import enums.BankEnum;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import interfaces.IBaseEntity;

@Getter
@Setter
@AllArgsConstructor
public abstract class BankCard implements IBaseEntity {
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

	@Override
	public String mappingToRawData() {
		return String.format("%s,%s,%s,%s,%s", bankName, cardNumber, balance.toPlainString(), userId, fullname);
	}
}
