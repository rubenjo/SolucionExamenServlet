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

	public void insert(Company companyFormulary) {
		Connection conn = connection.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO COMPANIES (company,dateCreation) VALUES(?,?)");
			preparedStatement.setString(1, companyFormulary.getCompany());
			preparedStatement.setDate(2, new Date(companyFormulary.getDateCreation().getTime()));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			connection.close(preparedStatement);
		}
		connection.close(conn);
	}

	public void update(Company companyFormulary) {
		Connection conn = connection.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("UPDATE COMPANIES SET dateCreation=? WHERE company=?");
			preparedStatement.setDate(1, new Date(companyFormulary.getDateCreation().getTime()));
			preparedStatement.setString(2, companyFormulary.getCompany());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			connection.close(preparedStatement);
		}
		connection.close(conn);
	}

	public Optional<Company> search(Company comp) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Connection conn = connection.open(jdbcUrl);
		Company company = new Company();
		try {
			preparedStatement = conn.prepareStatement("SELECT * FROM COMPANIES WHERE company=?");
			preparedStatement.setString(1, comp.getCompany());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				company.setCompany(resultSet.getString("company"));
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
			resultSet = statement.executeQuery("SELECT * FROM VIDEOJUEGOS");
			while (resultSet.next()) {
				company.setCompany(resultSet.getString("empresa"));
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
