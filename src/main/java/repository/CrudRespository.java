package repository;

import java.util.List;

import model.Carro;

public interface CrudRespository<T,K> {
	
	T findById(K id);
	
	List<T> findAll();
	
	boolean save(T t);

	boolean update(T t);

	boolean delete(K id);

}
