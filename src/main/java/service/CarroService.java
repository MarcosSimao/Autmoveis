package service;

import java.io.Serializable;
import java.util.List;

import dao.CarroDao;
import model.Carro;
import model.exceptios.DbException;
import repository.CarroRepository;

public class CarroService implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private final CarroRepository repository;

	public CarroService() {
		repository = new CarroDao();

	}
    //buscar carro por id
	public Carro getCarro(Long id) {
		try {
			Carro c = repository.findById(id);
			if (c == null) {
				throw new DbException("objeto não encontrado");
			}
			return c;
		} catch (Exception ex) {
			throw new DbException(ex.getMessage());
		}
	}
    //buscar carro por nome
	public List<Carro> findByName(String name) {

		try {
			List<Carro> c = repository.findByName(name);

			if (c.isEmpty()) {
				throw new DbException("objeto não encontrado");
			}
			return c;

		} catch (Exception ex) {
			throw new DbException(ex.getMessage());
		}
	}
    //buscar carro por tipo
	public List<Carro> findByTipo(String tipo) {
		
		try {
			List<Carro> c = repository.findByTipo(tipo);

			if (c.isEmpty()) {
				throw new DbException("objeto não encontrado");
			}
			return c;

		} catch (Exception ex) {
			throw new DbException(ex.getMessage());
		}
	}

	//buscar todos os carros cadastrados
	public List<Carro> getCarros() {
		
		try {
			List<Carro> c = repository.findAll();

			if (c.isEmpty()) {
				throw new DbException("não existe conteudo na base de dados");
			}
			return c;

		} catch (Exception ex) {
			throw new DbException(ex.getMessage());
		}
	}

	//salvado carro
	public boolean save(Carro c) {
	try{
		boolean ok = repository.save(c);
		return ok;
	}catch (Exception ex) {
		throw new DbException(ex.getMessage());
	}
	}

	//alterando carro
	public boolean update(Carro c) {
		try{
			boolean ok = repository.update(c);
			return ok;
		}catch (Exception ex) {
			throw new DbException(ex.getMessage());
		}
	}

	//deletando carro por id
	public boolean delete(Long id) {
		try{
			boolean ok = repository.delete(id);
			return ok;
		}catch (Exception ex) {
			throw new DbException(ex.getMessage());
		}
	}

}
