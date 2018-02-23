package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import es.salesianos.connection.AbstractConnection;
import es.salesianos.model.Console;

public class ConsoleRepository {

	AbstractConnection connection;

	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test;INIT=RUNSCRIPT FROM 'classpath:scripts/create.sql'";

	public void insert(Console consoleForm) {
		Connection conn = connection.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO CONSOLE(console,nomCompany) VALUES(?,?)");
			preparedStatement.setString(1, consoleForm.getName());
			preparedStatement.setString(2, consoleForm.getCompany());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			connection.close(preparedStatement);
		}
		connection.close(conn);
	}

	public void update(Console consoleForm) {
		Connection conn = connection.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("UPDATE CONSOLE SET console=?, nomCompany=? WHERE id=?");
			preparedStatement.setString(1, consoleForm.getName());
			preparedStatement.setString(2, consoleForm.getCompany());
			preparedStatement.setString(3, consoleForm.getId());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			connection.close(preparedStatement);
		}
		connection.close(conn);
	}

	public Optional<Console> search(Console console) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Connection conn = null;
		Console consol = new Console();
		try {
			conn = connection.open(jdbcUrl);
			preparedStatement = conn.prepareStatement("SELECT * FROM CONSOLE WHERE console=?");
			preparedStatement.setString(1, console.getName());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				consol.setName(resultSet.getString("console"));
				consol.setName(resultSet.getString("nomCompany"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			connection.close(preparedStatement);
			connection.close(conn);
		}
		return Optional.ofNullable(consol);
	}

	public List<Console> listAllConsoles() {
		List<Console> listConsole = new ArrayList<Console>();
		ResultSet resultSet = null;
		Connection conn = null;
		Statement statement = null;
		Console console = new Console();
		try {
			conn = connection.open(jdbcUrl);
			statement = conn.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM CONSOLE");

			while (resultSet.next()) {
				console.setName(resultSet.getString("console"));
				console.setCompany(resultSet.getString("nomCompany"));
				listConsole.add(console);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			connection.close(statement);
			connection.close(conn);
		}
		return listConsole;
	}
}
