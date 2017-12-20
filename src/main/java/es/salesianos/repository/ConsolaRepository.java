package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import es.salesianos.connection.AbstractConnection;
import es.salesianos.model.Consolas;

public class ConsolaRepository {

	AbstractConnection connection;
	
	private static final String jdbcUrl="jdbc:h2:file:./src/main/resources/test;INIT=RUNSCRIPT FROM 'classpath:scripts/create.sql'";
	
	public void insert(Consolas consoleFormulario){
		Connection conn=connection.open(jdbcUrl);
		PreparedStatement preparedStatement=null;
		try {
			preparedStatement=conn.prepareStatement("INSERT INTO CONSOLAS(consola,nom_empresa)"+"VALUES(?,?,?)");
			preparedStatement.setString(1,consoleFormulario.getConsola());
			preparedStatement.setString(2,consoleFormulario.getNom_Empresa());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			connection.close(preparedStatement);
		}
		connection.close(conn);
	}
	
	public void update(Consolas consoleFormulario){
		Connection conn=connection.open(jdbcUrl);
		PreparedStatement preparedStatement=null;
		try{
			preparedStatement=conn.prepareStatement("UPDATE CONSOLAS SET "+"consola=?, nom_Empresa=? WHERE id=?");
					
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			connection.close(preparedStatement);
		}
		connection.close(conn);
	}
}
