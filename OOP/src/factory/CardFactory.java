package factory;

import java.math.BigDecimal;

import enums.BankEnum;
import models.ANZBankCard;
import models.CMWBankCard;
import models.NABBankCard;
import models.base.BankCard;

public class CardFactory {
	public static BankCard createCard(BankEnum bankName, String cardNumber, BigDecimal balance, String userId,
			String fullname) {
		return switch (bankName) {
			case BankEnum.ANZ -> new ANZBankCard(cardNumber, balance, userId, fullname);
			case BankEnum.NAB -> new NABBankCard(cardNumber, balance, userId, fullname);
			case BankEnum.CMW -> new CMWBankCard(cardNumber, balance, userId, fullname);
			default -> throw new IllegalArgumentException("Bank name is not existed !!!");
		};
	}
}
