package repositories;

import java.time.LocalDate;
import java.util.ArrayList;

import constants.Constants;
import models.User;
import repositories.base.BaseRepository;

public class UserRepository extends BaseRepository<User> {

	public UserRepository(String path) {
		super(path);
	}

	@Override
	protected User mappingStringToObject(String data) {
		String[] splitData = data.split(",");
		return new User(
				splitData[0],
				splitData[1],
				splitData[2],
				LocalDate.parse(splitData[3], Constants.formatter),
				splitData[4],
				splitData[5],
				Integer.parseInt(splitData[6]));
	}

	@Override
	protected String mappingObjectToString(ArrayList<User> users) {
		return users
				.stream()
				.map(user -> user.mappingToRawData())
				.reduce("", (pre, cur) -> pre + cur + "\n");
	}
}
