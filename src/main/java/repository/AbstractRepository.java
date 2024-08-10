package repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import model.Entity;

public abstract class AbstractRepository<E extends Entity> {

	Map<Integer, E> repository;
	int size;

	AbstractRepository() {
		repository = new HashMap<>();
		size = 0;
	}

	public E add(E e) {
		e.setId(++size);
		repository.put(e.getId(), e);
		return e;
	}

	public E findById(int id) {
		return repository.get(id);
	}

	public Collection<E> findAll() {
		return repository.values();
	}

	public boolean existById(int id) {
		return repository.containsKey(id);
	}

}
