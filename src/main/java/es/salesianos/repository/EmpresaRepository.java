package es.salesianos.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import es.salesianos.connection.AbstractConnection;
import es.salesianos.model.Empresas;

public class EmpresaRepository {
	
	AbstractConnection connection;
	private static final String jdbcUrl="jdbc:h2:file:./src/main/resources/test;INIT=RUNSCRIPT FROM 'classpath:scripts/create.sql'";
	
	public List<Empresas> listAllCompanies(){
		ResultSet resultSet=null;
		Statement statement=null;
		Connection conn=connection.open(jdbcUrl);
		Empresas companies=new Empresas();
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
			connection.close(conn);
			connection.close(statement);
		}
		return listAllCompanies();
	}

}
