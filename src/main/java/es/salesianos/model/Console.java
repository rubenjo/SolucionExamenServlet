package es.salesianos.model;

public class Console implements IEntity<String>{

	public String console;
	public String nomCompany;
	
	public String getConsole() {
		return console;
	}
	
	public void setConsole(String console) {
		this.console = console;
	}
	
	public String getNomCompany() {
		return nomCompany;
	}
	
	public void setNomCompany(String nomCompany) {
		this.nomCompany = nomCompany;
	}

	public String getId() {
		return getConsole();
	}

	public void setId(String id) {
		setConsole(id);
		
	}
	
}
