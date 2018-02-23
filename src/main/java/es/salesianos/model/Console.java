package es.salesianos.model;

public class Console implements IEntity<String>{

	private String name;
	private String company;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCompany() {
		return company;
	}
	
	public void setCompany(String company) {
		this.company = company;	}

	public String getId() {
		return getName();
	}

	public void setId(String id) {
		setName(id);
		
	}
	
}
