package es.bligor.mc.service.implem;

import java.util.List;

public interface ICrudService<T> {

	public T add(T t);

	public void update(T t);

	public void delete(String id);

	public List<T> getAll();

	public T getById(String id);
}
