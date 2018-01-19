package es.salesianos.model;

import java.util.Date;

public class Videogame implements IEntity<String>{

	String tittle;
	String age;
	Date date;
	String nomConsole;
	
	public String getTittle() {
		return tittle;
	}
	
	public void setTittle(String titulo) {
		this.tittle = titulo;
	}
	
	public String getAge() {
		return age;
	}
	
	public void setAge(String age) {
		this.age = age;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getNomConsole() {
		return nomConsole;
	}
	
	public void setNomConsole(String nomConsole) {
		this.nomConsole = nomConsole;
	}

	public String getId() {
		return getTittle();
	}

	public void setId(String id) {
		setTittle(id);
	}
	
}
