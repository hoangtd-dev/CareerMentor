package repositories;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import constants.Constants;
import interfaces.IRepository;
import models.User;

public class UserRepository implements IRepository<User> {
	private final String path;

	public UserRepository(String path) {
		this.path = path;
	}

	@Override
	public void save(ArrayList<User> data) {
		try (FileWriter writer = new FileWriter(path)) {
			writer.write(mappingObjectToString(data));
		} catch (IOException e) {
			System.out.println("Could not save data !!!");
		}
	}

	@Override
	public ArrayList<User> load() {
		File db = new File(path);
		if (!db.exists()) {
			try {
				db.createNewFile();
			} catch (IOException e) {
				System.out.println("Could not create file: " + path);
				return null;
			}
		}

		ArrayList<User> data = new ArrayList<>();

		try (Scanner reader = new Scanner(db)) {
			while (reader.hasNextLine()) {
				String item = reader.nextLine();
				data.add(mappingStringToObject(item));
			}
			return data;
		} catch (FileNotFoundException e) {
			System.out.println("File not found !!!");
			return null;
		}
	}

	private User mappingStringToObject(String data) {
		String[] splitData = data.split(",");
		return new User(
				splitData[0],
				splitData[1],
				LocalDate.parse(splitData[2], Constants.formatter),
				splitData[3],
				splitData[4],
				Integer.parseInt(splitData[5]));
	}

	private String mappingObjectToString(ArrayList<User> users) {
		String result = "";

		for (User user : users) {
			result += user.mappingToRawData() + "\n";
		}

		return result;
	}
}
