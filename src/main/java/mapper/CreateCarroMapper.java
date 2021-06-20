package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Carro;
import model.exceptios.DbException;

public class CreateCarroMapper {

	public static Carro createCarro(ResultSet rs) {
		Carro c = new Carro();
		try {
			c.setId(rs.getLong("id"));
			c.setNome(rs.getString("nome"));
			c.setDesc(rs.getString("descricao"));
			c.setUrlFoto(rs.getString("url_foto"));
			c.setUrlVideo(rs.getString("url_video"));
			c.setLatitude(rs.getString("latitude"));
			c.setLongitude(rs.getString("longitude"));
			c.setTipo(rs.getString("tipo"));
			return c;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}

	}

}
