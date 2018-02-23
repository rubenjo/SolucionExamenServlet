package es.salesianos.model;

import java.util.Date;

public class Company implements IEntity<String>{

	private String name;
	private Date dateCreation;
	
	public String getName() {
		return name;
	}
	
	public void setName(String company) {
		this.name = company;
	}
	
	public Date getDateCreation() {
		return dateCreation;
	}
	
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getId() {
		return getName();
	}

	public void setId(String id) {
		setName(id);
	}
	
}
