package es.salesianos.model;

public class Console implements IEntity<String>{

	public String console;
	public String nomCompany;
	
	public String getConsola() {
		return console;
	}
	
	public void setConsola(String console) {
		this.console = console;
	}
	
	public String getNom_Empresa() {
		return nomCompany;
	}
	
	public void setNom_Empresa(String nomCompany) {
		this.nomCompany = nomCompany;
	}

	public String getId() {
		return getConsola();
	}

	public void setId(String id) {
		setConsola(id);
		
	}
	
}
