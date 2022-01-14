package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mapper.CreateCarroMapper;
import model.Carro;
import model.exceptios.DbException;
import repository.CarroRepository;

public class CarroDao implements CarroRepository {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	public CarroDao() {
		this.conn = Db.conexao();
	}
	
	
	

//pesquisa carro por id
	@Override
	public Carro findById(Long id)  {
		try {
			this.stmt = this.conn.prepareStatement(FileReaderSql.read("getCarroById"));
			this.stmt.setLong(1, id);
			this.rs = this.stmt.executeQuery();
			if (this.rs.next()) {
				Carro c = CreateCarroMapper.createCarro(rs);
				rs.close();
				return c;
			}

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			this.close(this.conn,this.stmt);
		}
		return null;
	}

//pesquisa carrros por nome
	public List<Carro> findByName(String name) {
		List<Carro> carro = new ArrayList<>();
		try {
			this.stmt = this.conn.prepareStatement(FileReaderSql.read("findByName"));
			this.stmt.setString(1, "%" + name.toLowerCase() + "%");
			this.rs = this.stmt.executeQuery();
			while (this.rs.next()) {
				Carro c = CreateCarroMapper.createCarro(rs);
				carro.add(c);
			}
			this.rs.close();
			return carro;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DbException(e.getMessage());
		} finally {
			this.close(this.conn,this.stmt);
		}

	}

	// pesquisa carro por tipo
	public List<Carro> findByTipo(String tipo) {
		List<Carro> carro = new ArrayList<>();
		try {
			this.stmt = this.conn.prepareStatement(FileReaderSql.read("findByTipo"));
			this.stmt.setString(1, tipo);
			this.rs = this.stmt.executeQuery();
			while (this.rs.next()) {
				Carro c = CreateCarroMapper.createCarro(rs);
				carro.add(c);
			}
			this.rs.close();
			return carro;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DbException(e.getMessage());
		} finally {
			this.close(this.conn,this.stmt);
		}
	}

	@Override
	public List<Carro> findAll(){
		List<Carro> carros = new ArrayList<>();
		try {
			this.stmt = this.conn.prepareStatement(FileReaderSql.read("getCarros"));
			this.rs = this.stmt.executeQuery();
			while (this.rs.next()) {
				Carro c = CreateCarroMapper.createCarro(rs);
				carros.add(c);
			}
			this.rs.close();
			return carros;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DbException(e.getMessage());
		} finally {
			this.close(this.conn,this.stmt);
		}
	}

	// adicionando carro
	public boolean save(Carro c) {
		try {
			this.stmt = this.conn.prepareStatement(FileReaderSql.read("insertCarros"));
			this.stmt.setString(1, c.getNome());
			this.stmt.setString(2, c.getDesc());
			this.stmt.setString(3, c.getUrlFoto());
			this.stmt.setString(4, c.getUrlVideo());
			this.stmt.setString(5, c.getLatitude());
			this.stmt.setString(6, c.getLongitude());
			this.stmt.setString(7, c.getTipo());
			int value = this.stmt.executeUpdate();
			if (value == 0) {
				throw new SQLException("erro ao salvar carros");
			}
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DbException(e.getMessage());
		} finally {
			this.close(this.conn,this.stmt);
		}
	}

	// alterando carro
	public boolean update(Carro c) {
		try {
			this.stmt = this.conn.prepareStatement(FileReaderSql.read("updateCarros"));
			this.stmt.setString(1, c.getNome());
			this.stmt.setString(2, c.getDesc());
			this.stmt.setString(3, c.getUrlFoto());
			this.stmt.setString(4, c.getUrlVideo());
			this.stmt.setString(5, c.getLatitude());
			this.stmt.setString(6, c.getLongitude());
			this.stmt.setString(7, c.getTipo());
			this.stmt.setLong(8, c.getId());
			int value = this.stmt.executeUpdate();
			if (value == 0) {
				throw new SQLException("erro ao salvar carros");
			}
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DbException(e.getMessage());
		} finally {
			this.close(this.conn,this.stmt);
		}
	}

	// delete carro
	public boolean delete(Long id) {
		try {
			this.stmt = this.conn.prepareStatement(FileReaderSql.read("deleteCarros"));
			this.stmt.setLong(1, id);
			boolean ok = this.stmt.executeUpdate() > 0;
			return ok;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DbException(e.getMessage());
		} finally {
			this.close(this.conn,this.stmt);
		}

	}

	// metodo para organizar codigo de fechamento
	private void close(Connection c,PreparedStatement s) {

		if (s != null) {
			Db.closePreparedStatement(s);
		}
		if (c != null) {
			Db.closeConection(c);
		}
	}




	




	
}
