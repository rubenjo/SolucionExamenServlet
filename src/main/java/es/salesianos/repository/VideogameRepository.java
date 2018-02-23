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

	public void insertar(Videogame videogameForm) {
		Connection conn = connection.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO VIDEOGAME(tittle,age,nomConsole,date) VALUES(?,?,?,?)");
			preparedStatement.setString(1, videogameForm.getTittle());
			preparedStatement.setString(2, videogameForm.getAge());
			preparedStatement.setString(3, videogameForm.getNomConsole());
			preparedStatement.setDate(4, new Date(videogameForm.getDate().getTime()));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			connection.close(conn);
			connection.close(preparedStatement);
		}
	}

	public void update(Videogame videogameForm) {
		Connection conn = connection.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("UPDATE VIDEOGAME SET age=?, nomConsole=?, date=? WHERE tittle=?");
			preparedStatement.setString(1, videogameForm.getAge());
			preparedStatement.setString(2, videogameForm.getNomConsole());
			preparedStatement.setDate(3, new Date(videogameForm.getDate().getTime()));
			preparedStatement.setString(4, videogameForm.getTittle());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			connection.close(conn);
			connection.close(preparedStatement);
		}
	}

	public Optional<Videogame> search(Console console) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Connection conn = connection.open(jdbcUrl);
		Videogame game = new Videogame();
		try {
			preparedStatement = conn.prepareStatement("SELECT * FROM VIDEOGAME INNER JOIN CONSOLES ON VIDEOGAMES.nomConsole=CONSOLES.console WHERE CONSOLES.nomCompany=?");
			preparedStatement.setString(1, console.getCompanyName());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				game.setTittle(resultSet.getString("tittle"));
				game.setAge(resultSet.getString("age"));
				game.setDate(resultSet.getDate("date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			connection.close(conn);
			connection.close(preparedStatement);
		}
		return Optional.ofNullable(game);
	}

	public List<Videogame> listAllGames() {
		ResultSet resultSet = null;
		Statement statement = null;
		Connection conn = connection.open(jdbcUrl);
		Videogame game = new Videogame();
		try {
			statement = conn.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM VIDEOGAME");
			while (resultSet.next()) {
				game.setTittle(resultSet.getString("titulo"));
				game.setAge(resultSet.getString("edadRecomendada"));
				game.setDate(resultSet.getDate("fechaLanzamiento"));
				game.setNomConsole(resultSet.getString("nom_Consola"));
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
