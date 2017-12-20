package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;

import es.salesianos.connection.AbstractConnection;
import es.salesianos.model.Videojuegos;

public class VideojuegoRepository {

	AbstractConnection connection;
	
	private static final String jdbcUrl="jdbc:h2:file:./src/main/resources/test;INIT=RUNSCRIPT FROM 'classpath:scripts/create.sql'";
	
	public void insertar(Videojuegos videogamesFormulario){
		Connection conn=null;
		PreparedStatement preparedStatement=null;
		try{
			preparedStatement=conn.prepareStatement("INSERT INTO VIDEOJUEGOS(titulo,edadRecomendada,nom_Consola,fechaLanzamiento)"+"VALUES(?,?,?,?)");
			preparedStatement.setString(1,videogamesFormulario.getTitulo());
			preparedStatement.setString(2, videogamesFormulario.getEdadRecomendada());
			preparedStatement.setString(3,videogamesFormulario.getNom_Consola());
			preparedStatement.setDate(4, new Date(videogamesFormulario.getFechaLanzamiento().getTime()));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			connection.close(conn);
		}
	}
	
}
