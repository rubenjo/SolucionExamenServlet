package es.salesianos.model;

import java.util.Date;

public class Videojuegos implements IEntity<String>{

	String titulo;
	String edadRecomendada;
	Date fechaLanzamiento;
	String nom_Consola;
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getEdadRecomendada() {
		return edadRecomendada;
	}
	
	public void setEdadRecomendada(String edadRecomendada) {
		this.edadRecomendada = edadRecomendada;
	}
	
	public Date getFechaLanzamiento() {
		return fechaLanzamiento;
	}
	
	public void setFechaLanzamiento(Date fechaLanzamiento) {
		this.fechaLanzamiento = fechaLanzamiento;
	}
	
	public String getNom_Consola() {
		return nom_Consola;
	}
	
	public void setNom_Consola(String nom_Consola) {
		this.nom_Consola = nom_Consola;
	}

	public String getId() {
		// TODO Auto-generated method stub
		return getTitulo();
	}

	public void setId(String id) {
		// TODO Auto-generated method stub
		setTitulo(id);
	}
	
}
