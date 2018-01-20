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

	public void insert(Console consoleFormulario) {
		Connection conn = connection.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO CONSOLES(console,nomCompany) VALUES(?,?)");
			preparedStatement.setString(1, consoleFormulario.getConsole());
			preparedStatement.setString(2, consoleFormulario.getNomCompany());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			connection.close(preparedStatement);
		}
		connection.close(conn);
	}

	public void update(Console consoleFormulario) {
		Connection conn = connection.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("UPDATE CONSOLES SET console=?, nomCompany=? WHERE id=?");
			preparedStatement.setString(1, consoleFormulario.getConsole());
			preparedStatement.setString(2, consoleFormulario.getNomCompany());
			preparedStatement.setString(3, consoleFormulario.getId());
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
			preparedStatement = conn.prepareStatement("SELECT * FROM CONSOLES WHERE console=?");
			preparedStatement.setString(1, console.getConsole());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				consol.setConsole(resultSet.getString("console"));
				consol.setConsole(resultSet.getString("nomCompany"));
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
		List<Console> listaConsolas = new ArrayList<Console>();
		ResultSet resultSet = null;
		Connection conn = null;
		Statement statement = null;
		Console maquineta = new Console();
		try {
			conn = connection.open(jdbcUrl);
			statement = conn.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM CONSOLES");

			while (resultSet.next()) {
				maquineta.setConsole(resultSet.getString("console"));
				maquineta.setNomCompany(resultSet.getString("nomCompany"));
				listaConsolas.add(maquineta);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			connection.close(statement);
			connection.close(conn);
		}
		return listaConsolas;
	}
}
