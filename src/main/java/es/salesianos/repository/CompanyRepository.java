package es.salesianos.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

import es.salesianos.connection.AbstractConnection;
import es.salesianos.model.Company;

public class CompanyRepository {

	AbstractConnection connection;
	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test;INIT=RUNSCRIPT FROM 'classpath:scripts/create.sql'";

	public void insert(Company companyForm) {
		Connection conn = connection.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO COMPANY (company,dateCreation) VALUES(?,?)");
			preparedStatement.setString(1, companyForm.getName());
			preparedStatement.setDate(2, new Date(companyForm.getDateCreation().getTime()));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			connection.close(preparedStatement);
			connection.close(conn);
		}
	}

	public void update(Company companyForm) {
		Connection conn = connection.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("UPDATE COMPANY SET dateCreation=? WHERE company=?");
			preparedStatement.setDate(1, new Date(companyForm.getDateCreation().getTime()));
			preparedStatement.setString(2, companyForm.getName());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			connection.close(preparedStatement);
			connection.close(conn);
		}
	}

	public Optional<Company> search(Company comp) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Connection conn = connection.open(jdbcUrl);
		Company company = new Company();
		try {
			preparedStatement = conn.prepareStatement("SELECT * FROM COMPANY WHERE company=?");
			preparedStatement.setString(1, comp.getName());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				company.setName(resultSet.getString("company"));
				company.setDateCreation(resultSet.getDate("dateCreation"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			connection.close(preparedStatement);
			connection.close(conn);
		}
		return Optional.ofNullable(company);
	}

	public List<Company> listAllCompanies() {
		ResultSet resultSet = null;
		Statement statement = null;
		Connection conn = connection.open(jdbcUrl);
		Company company = new Company();
		try {
			statement = conn.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM GAME");
			while (resultSet.next()) {
				company.setName(resultSet.getString("empresa"));
				company.setDateCreation(resultSet.getDate("fechaCreacion"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			connection.close(statement);
			connection.close(conn);
		}
		return listAllCompanies();
	}

}
