package repositories;

import java.math.BigDecimal;
import java.util.ArrayList;

import constants.BankEnum;
import models.ANZBankCard;
import models.CMWBankCard;
import models.NABBankCard;
import models.base.BankCard;
import repositories.base.BaseRepository;

public class BankCardRepository extends BaseRepository<BankCard> {

	public BankCardRepository(String path) {
		super(path);
	}

	@Override
	protected BankCard mappingStringToObject(String data) {
		String[] splitData = data.split(",");

		return (switch (BankEnum.valueOf(splitData[0])) {
			case BankEnum.ANZ -> new ANZBankCard(splitData[1], new BigDecimal(splitData[2]), splitData[3], splitData[4]);
			case BankEnum.NAB -> new NABBankCard(splitData[1], new BigDecimal(splitData[2]), splitData[3], splitData[4]);
			case BankEnum.CMW -> new CMWBankCard(splitData[1], new BigDecimal(splitData[2]), splitData[3], splitData[4]);
			default -> throw new IllegalArgumentException("Bank does not exist");
		});
	}

	@Override
	protected String mappingObjectToString(ArrayList<BankCard> cards) {
		return cards
				.stream()
				.map(card -> card.mappingToRawData())
				.reduce("", (pre, cur) -> pre + cur + "\n");
	}
}
