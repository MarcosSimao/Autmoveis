package repository;

import java.util.List;

import model.Carro;

public interface CarroRepository {

	Carro carroById(Long id);

	List<Carro> findByName(String name);

	List<Carro> findByTipo(String tipo);

	List<Carro> getCarros();

	boolean save(Carro c);

	boolean update(Carro c);

	boolean delete(Long id);
}
