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
			preparedStatement.setString(1, consoleFormulario.getConsola());
			preparedStatement.setString(2, consoleFormulario.getNom_Empresa());
			preparedStatement.setString(3, consoleFormulario.getId());
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			connection.close(preparedStatement);
		}
		connection.close(conn);
	}
	
	public Optional<Consolas> search(Consolas console){
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		Connection conn=null;
		Consolas maquineta=new Consolas();
		try{		
			conn=connection.open(jdbcUrl);
			preparedStatement=conn.prepareStatement("SELECT * FROM CONSOLAS WHERE consola=?");
			preparedStatement.setString(1, console.getConsola());
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){	
				maquineta.setConsola(resultSet.getString("consola"));
				maquineta.setConsola(resultSet.getString("nom_Empresa"));
			}
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			connection.close(preparedStatement);
			connection.close(conn);
		}
		return Optional.ofNullable(maquineta);
	}
	
	public List<Consolas> listAllConsoles(){
		List<Consolas> listaConsolas=new ArrayList<Consolas>();
		ResultSet resultSet=null;
		Connection conn=null;
		Statement statement=null;
		Consolas maquineta=new Consolas();
		try{
			conn=connection.open(jdbcUrl);
			statement=conn.createStatement();
			resultSet=statement.executeQuery("SELECT * FROM CONSOLAS");
			
			while(resultSet.next()){
				maquineta.setConsola(resultSet.getString("consola"));
				maquineta.setNom_Empresa(resultSet.getString("nom_Empresa"));
				listaConsolas.add(maquineta);
			}
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			connection.close(statement);
			connection.close(conn);
		}
		return listaConsolas;
	}
}
