package repository;

import java.util.List;

import model.Carro;

public interface CarroRepository extends CrudRespository<Carro,Long>{

	

	List<Carro> findByName(String name);

	List<Carro> findByTipo(String tipo);




}
