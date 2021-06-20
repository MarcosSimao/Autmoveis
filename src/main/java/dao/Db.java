package dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import model.exceptios.DbException;

public class Db {

	private static Connection conn = null;

	// aqui recebe as informações do properties e conecta ao driver do banco
	public static Connection conexao() {
		if (conn == null) {
			try {
				Properties props = arquivoConexao();
				String url = props.getProperty("url");

				conn = DriverManager.getConnection(url, props);
				System.out.println(props);
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
		return conn;
	}

	// fechar a conexão
	public static void closeConection(Connection c) {

		try {
			c.close();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}

	}

// pegando o arquivo properties da conexao
	private static Properties arquivoConexao() {
		try {
			FileInputStream s = new FileInputStream("db.properties");
			Properties props = new Properties();
			props.load(s);
			return props;
		} catch (IOException e) {
			throw new DbException(e.getMessage());
		}

	}

	// fecha o PreparedStatement
	public static void closePreparedStatement(PreparedStatement stmt) {
		try {
			stmt.close();
		} catch (SQLException e) {

			throw new DbException(e.getMessage());
		}
	}


	
}
