package es.salesianos.connection;

public class H2Connection extends AbstractConnection{

	@Override
	public String getDriver() {
		// TODO Auto-generated method stub
		return "org.h2.Driver";
	}

	@Override
	public String getDatabaseUser() {
		// TODO Auto-generated method stub
		return "sa";
	}

	@Override
	public String getDatabasePassword() {
		// TODO Auto-generated method stub
		return "";
	}

}
