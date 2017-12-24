package es.salesianos.model;

public class Consolas implements IEntity<String>{

	public String consola;
	public String nom_Empresa;
	
	public String getConsola() {
		return consola;
	}
	
	public void setConsola(String consola) {
		this.consola = consola;
	}
	
	public String getNom_Empresa() {
		return nom_Empresa;
	}
	
	public void setNom_Empresa(String nom_Empresa) {
		this.nom_Empresa = nom_Empresa;
	}

	public String getId() {
		// TODO Auto-generated method stub
		return getConsola();
	}

	public void setId(String id) {
		setConsola(id);
		
	}
	
}
