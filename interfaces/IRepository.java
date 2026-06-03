package interfaces;

import java.util.ArrayList;

public interface IRepository<T> {
	void save(ArrayList<T> data);

	ArrayList<T> load();
}