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
import es.salesianos.model.Consolas;
import es.salesianos.model.Videojuegos;

public class VideojuegoRepository {

	AbstractConnection connection;
	
	private static final String jdbcUrl="jdbc:h2:file:./src/main/resources/test;INIT=RUNSCRIPT FROM 'classpath:scripts/create.sql'";
	
	public void insertar(Videojuegos videogamesFormulario){
		Connection conn=connection.open(jdbcUrl);
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
			connection.close(preparedStatement);
		}
	}
	
	public void update(Videojuegos videogamesFormulario){
		Connection conn=connection.open(jdbcUrl);
		PreparedStatement preparedStatement=null;
		try{
			preparedStatement=conn.prepareStatement("UPDATE VIDEOJUEGOS"+" SET edadRecomendada=?, nom_Consola=?, fechaLanzamiento=? WHERE titulo=?");
			preparedStatement.setString(1, videogamesFormulario.getEdadRecomendada());
			preparedStatement.setString(2, videogamesFormulario.getNom_Consola());
			preparedStatement.setDate(3, new Date(videogamesFormulario.getFechaLanzamiento().getTime()));
			preparedStatement.setString(4, videogamesFormulario.getTitulo());
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			connection.close(conn);
			connection.close(preparedStatement);
		}
	}
	
	public Optional<Videojuegos> search(Consolas consola){
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		Connection conn=connection.open(jdbcUrl);
		Videojuegos juegos=new Videojuegos();
		try{
			preparedStatement=conn.prepareStatement("SELECT * FROM VIDEOJUEGOS INNER JOIN CONSOLAS ON VIDEOJUEGOS.nom_Consola=CONSOLA.consola WHERE CONSOLA.nom_Empresa=?");
			preparedStatement.setString(1, consola.getNom_Empresa());
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				juegos.setTitulo(resultSet.getString("titulo"));
				juegos.setEdadRecomendada(resultSet.getString("edadRecomendada"));
				juegos.setFechaLanzamiento(resultSet.getDate("fechaLanzamiento"));	
			}
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			connection.close(conn);
			connection.close(preparedStatement);
		}
		return Optional.ofNullable(juegos);
	}
	
	public List<Videojuegos> listAllGames(){
		ResultSet resultSet=null;
		Statement statement=null;
		Connection conn=connection.open(jdbcUrl);
		Videojuegos juegos=new Videojuegos();
		try{
			statement=conn.createStatement();
			resultSet=statement.executeQuery("SELECT * FROM VIDEOJUEGOS");
			while(resultSet.next()){
				juegos.setTitulo(resultSet.getString("titulo"));
				juegos.setEdadRecomendada(resultSet.getString("edadRecomendada"));
				juegos.setFechaLanzamiento(resultSet.getDate("fechaLanzamiento"));
				juegos.setNom_Consola(resultSet.getString("nom_Consola"));
			}
			
		}catch(SQLException e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			connection.close(conn);
			connection.close(statement);
		}
		return listAllGames();
	}
}
