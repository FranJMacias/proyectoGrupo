package es.bligor.mc.controller.implem;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface ICrudController<T> {

	public ResponseEntity<T> add(T t);
	public ResponseEntity<String> update(T t);
	public ResponseEntity<String> delete(String id);
	public ResponseEntity<List<T>> getAll();
	public ResponseEntity<T> getById(String id);
}
