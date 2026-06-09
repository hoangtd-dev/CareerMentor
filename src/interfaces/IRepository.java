package interfaces;

import java.util.List;

public interface IRepository<T> {
	void save(List<T> data);

	List<T> load();
}