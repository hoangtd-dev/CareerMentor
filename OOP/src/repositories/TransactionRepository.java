package repositories;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import constants.Constants;
import enums.TransactionTypeEnum;
import models.Transaction;
import repositories.base.BaseRepository;

public class TransactionRepository extends BaseRepository<Transaction> {

	public TransactionRepository(String path) {
		super(path);
	}

	@Override
	protected Transaction mappingStringToObject(String data) {
		String[] splitData = data.split(",");
		return new Transaction(
				TransactionTypeEnum.valueOf(splitData[0]),
				new BigDecimal(splitData[1]),
				splitData[2],
				LocalDateTime.parse(splitData[3], Constants.DATETIME_FORMATTER));
	}
}
