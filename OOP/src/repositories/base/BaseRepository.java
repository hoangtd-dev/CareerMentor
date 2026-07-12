package repositories.base;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import interfaces.IBaseEntity;
import interfaces.IRepository;

public abstract class BaseRepository<T extends IBaseEntity> implements IRepository<T> {
	private final String path;

	public BaseRepository(String path) {
		this.path = path;
	}

	protected abstract T mappingStringToObject(String data);

	private String mappingObjectToString(List<T> items) {
		return items
				.stream()
				.map(item -> item.mappingToRawData())
				.reduce("", (pre, cur) -> pre + cur + "\n");
	}

	@Override
	public void save(List<T> data) {
		try (FileWriter writer = new FileWriter(path)) {
			writer.write(mappingObjectToString(data));
		} catch (IOException e) {
			System.out.println("Could not save data !!!");
		}
	}

	@Override
	public List<T> load() {
		File db = new File(path);
		if (!db.exists()) {
			try {
				db.createNewFile();
			} catch (IOException e) {
				System.out.println("Could not create file: " + path);
				return null;
			}
		}

		List<T> data = new ArrayList<>();

		try (Scanner reader = new Scanner(db)) {
			while (reader.hasNextLine()) {
				String item = reader.nextLine();
				data.add(mappingStringToObject(item));
			}
			return data;
		} catch (Exception e) {
			System.out.println("Cannot load file !!!");
			return null;
		}
	}
}
