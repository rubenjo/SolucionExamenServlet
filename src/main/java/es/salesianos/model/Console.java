package es.salesianos.model;

public class Console implements IEntity<String>{

	private String console;
	private String companyName;
	
	public String getConsole() {
		return console;
	}
	
	public void setConsole(String console) {
		this.console = console;
	}
	
	public String getCompanyName() {
		return companyName;
	}
	
	public void setCompanyName(String companyName) {
		this.companyName = companyName;	}

	public String getId() {
		return getConsole();
	}

	public void setId(String id) {
		setConsole(id);
		
	}
	
}
