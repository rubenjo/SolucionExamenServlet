package es.salesianos.model;

import java.util.Date;

public class Company implements IEntity<String>{

	String company;
	Date dateCreation;
	
	public String getCompany() {
		return company;
	}
	
	public void setCompany(String company) {
		this.company = company;
	}
	
	public Date getDateCreation() {
		return dateCreation;
	}
	
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getId() {
		return getCompany();
	}

	public void setId(String id) {
		setCompany(id);
	}
	
}
