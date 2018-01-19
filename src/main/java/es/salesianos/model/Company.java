package src.main.java.es.salesianos.model;

import java.util.Date;

public class Company implements IEntity<String>{

	String empresa;
	Date fechaCreacion;
	
	public String getEmpresa() {
		return empresa;
	}
	
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getId() {
		// TODO Auto-generated method stub
		return getEmpresa();
	}

	public void setId(String id) {
		// TODO Auto-generated method stub
		setEmpresa(id);
	}
	
}
