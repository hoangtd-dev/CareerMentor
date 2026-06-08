package repositories;

import java.math.BigDecimal;
import java.util.ArrayList;

import constants.BankEnum;
import models.ANZBankAccount;
import models.CMWBankAccount;
import models.NABBankAccount;
import models.base.BankAccount;
import repositories.base.BaseRepository;

public class BankAccountRepository extends BaseRepository<BankAccount> {

	public BankAccountRepository(String path) {
		super(path);
	}

	@Override
	protected BankAccount mappingStringToObject(String data) {
		String[] splitData = data.split(",");

		return (switch (BankEnum.valueOf(splitData[0])) {
			case BankEnum.ANZ -> new ANZBankAccount(splitData[0], new BigDecimal(splitData[1]), splitData[2]);
			case BankEnum.NAB -> new NABBankAccount(splitData[0], new BigDecimal(splitData[1]), splitData[2]);
			case BankEnum.CMW -> new CMWBankAccount(splitData[0], new BigDecimal(splitData[1]), splitData[2]);
			default -> throw new IllegalArgumentException("Bank does not exist");
		});
	}

	@Override
	protected String mappingObjectToString(ArrayList<BankAccount> accounts) {
		String result = "";

		for (BankAccount account : accounts) {
			result += account.mappingToRawData() + "\n";
		}

		return result;
	}
}
