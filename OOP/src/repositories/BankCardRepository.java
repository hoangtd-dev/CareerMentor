package repositories;

import java.math.BigDecimal;

import enums.BankEnum;
import factory.CardFactory;
import models.base.BankCard;
import repositories.base.BaseRepository;

public class BankCardRepository extends BaseRepository<BankCard> {

	public BankCardRepository(String path) {
		super(path);
	}

	@Override
	protected BankCard mappingStringToObject(String data) {
		String[] splitData = data.split(",");
		return CardFactory.createCard(BankEnum.valueOf(splitData[0]), splitData[1], new BigDecimal(splitData[2]),
				splitData[3], splitData[4]);
	}
}
