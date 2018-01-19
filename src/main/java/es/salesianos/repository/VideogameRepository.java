package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;
import java.sql.Date;

import es.salesianos.connection.AbstractConnection;
import es.salesianos.model.Console;
import es.salesianos.model.Videogame;

public class VideogameRepository {

	AbstractConnection connection;

	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test;INIT=RUNSCRIPT FROM 'classpath:scripts/create.sql'";

	public void insertar(Videogame videogamesFormulario) {
		Connection conn = connection.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("INSERT INTO VIDEOJUEGOS(titulo,edadRecomendada,nom_Consola,fechaLanzamiento)"
							+ "VALUES(?,?,?,?)");
			preparedStatement.setString(1, videogamesFormulario.getTittle());
			preparedStatement.setString(2, videogamesFormulario.getAge());
			preparedStatement
					.setString(3, videogamesFormulario.getNomConsole());
			preparedStatement.setDate(4, new Date(videogamesFormulario
					.getDate().getTime()));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			connection.close(conn);
			connection.close(preparedStatement);
		}
	}

	public void update(Videogame videogamesFormulario) {
		Connection conn = connection.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("UPDATE VIDEOJUEGOS"
							+ " SET edadRecomendada=?, nom_Consola=?, fechaLanzamiento=? WHERE titulo=?");
			preparedStatement.setString(1, videogamesFormulario.getAge());
			preparedStatement
					.setString(2, videogamesFormulario.getNomConsole());
			preparedStatement.setDate(3, new Date(videogamesFormulario
					.getDate().getTime()));
			preparedStatement.setString(4, videogamesFormulario.getTittle());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			connection.close(conn);
			connection.close(preparedStatement);
		}
	}

	public Optional<Videogame> search(Console consola) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Connection conn = connection.open(jdbcUrl);
		Videogame juegos = new Videogame();
		try {
			preparedStatement = conn
					.prepareStatement("SELECT * FROM VIDEOJUEGOS INNER JOIN CONSOLAS ON VIDEOJUEGOS.nom_Consola=CONSOLA.consola WHERE CONSOLA.nom_Empresa=?");
			preparedStatement.setString(1, consola.getNom_Empresa());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				juegos.setTittle(resultSet.getString("titulo"));
				juegos.setAge(resultSet.getString("edadRecomendada"));
				juegos.setDate(resultSet.getDate("fechaLanzamiento"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			connection.close(conn);
			connection.close(preparedStatement);
		}
		return Optional.ofNullable(juegos);
	}

	public List<Videogame> listAllGames() {
		ResultSet resultSet = null;
		Statement statement = null;
		Connection conn = connection.open(jdbcUrl);
		Videogame juegos = new Videogame();
		try {
			statement = conn.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM VIDEOJUEGOS");
			while (resultSet.next()) {
				juegos.setTittle(resultSet.getString("titulo"));
				juegos.setAge(resultSet.getString("edadRecomendada"));
				juegos.setDate(resultSet.getDate("fechaLanzamiento"));
				juegos.setNomConsole(resultSet.getString("nom_Consola"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			connection.close(conn);
			connection.close(statement);
		}
		return listAllGames();
	}
}
