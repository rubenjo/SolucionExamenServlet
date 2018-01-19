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
import es.salesianos.model.Empresas;

public class EmpresaRepository {
	
	AbstractConnection connection;
	private static final String jdbcUrl="jdbc:h2:file:./src/main/resources/test;INIT=RUNSCRIPT FROM 'classpath:scripts/create.sql'";
	
	public void insert(Company empresaFormulario){
		Connection conn=connection.open(jdbcUrl);
		PreparedStatement preparedStatement=null;
		try{
			preparedStatement=conn.prepareStatement("INSERT INTO EMPRESAS (empresa,fechaCreacion)"+" VALUES(?,?)");
			preparedStatement.setString(1, empresaFormulario.getEmpresa());
			preparedStatement.setDate(2, new Date(empresaFormulario.getFechaCreacion().getTime()));
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			connection.close(preparedStatement);
		}
		connection.close(conn);
	}
	
	public void update(Company empresaFormulario){
		Connection conn=connection.open(jdbcUrl);
		PreparedStatement preparedStatement=null;
		try{
			preparedStatement=conn.prepareStatement("UPDATE EMPRESAS SET fechaCreacion=? "+"WHERE empresa=?");
			preparedStatement.setDate(1, new Date(empresaFormulario.getFechaCreacion().getTime()));
			preparedStatement.setString(2, empresaFormulario.getEmpresa());
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			connection.close(preparedStatement);
		}
		connection.close(conn);
	}
	
	public Optional<Company> search(Company empresa){
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		Connection conn=connection.open(jdbcUrl);
		Company company=new Company();
		try{
			preparedStatement=conn.prepareStatement("SELECT * FROM EMPRESAS WHERE empresa=?");
			preparedStatement.setString(1, empresa.getEmpresa());
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				company.setEmpresa(resultSet.getString("empresa"));
				company.setFechaCreacion(resultSet.getDate("fechaCreacion"));
			}
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			connection.close(preparedStatement);
			connection.close(conn);
		}
		return Optional.ofNullable(company);
	}
	
	public List<Company> listAllCompanies(){
		ResultSet resultSet=null;
		Statement statement=null;
		Connection conn=connection.open(jdbcUrl);
		Company companies=new Company();
		try{
			statement=conn.createStatement();
			resultSet=statement.executeQuery("SELECT * FROM VIDEOJUEGOS");
			while(resultSet.next()){
				companies.setEmpresa(resultSet.getString("empresa"));
				companies.setFechaCreacion(resultSet.getDate("fechaCreacion"));
			}
			
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			connection.close(statement);
			connection.close(conn);
		}
		return listAllCompanies();
	}

}
