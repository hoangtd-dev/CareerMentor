package repositories.base;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import interfaces.IRepository;

public abstract class BaseRepository<T> implements IRepository<T> {
	private final String path;

	public BaseRepository(String path) {
		this.path = path;
	}

	protected abstract String mappingObjectToString(ArrayList<T> data);
	protected abstract T mappingStringToObject(String data);

	@Override
	public void save(ArrayList<T> data) {
		try (FileWriter writer = new FileWriter(path)) {
			writer.write(mappingObjectToString(data));
		} catch (IOException e) {
			System.out.println("Could not save data !!!");
		}
	}

	@Override
	public ArrayList<T> load() {
		File db = new File(path);
		if (!db.exists()) {
			try {
				db.createNewFile();
			} catch (IOException e) {
				System.out.println("Could not create file: " + path);
				return null;
			}
		}

		ArrayList<T> data = new ArrayList<>();

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
}
