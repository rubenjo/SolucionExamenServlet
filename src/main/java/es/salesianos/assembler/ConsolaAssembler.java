package es.salesianos.assembler;

import javax.servlet.http.HttpServletRequest;
import es.salesianos.model.Console;

public class ConsolaAssembler {
	public Console createConsolaFromRequest(HttpServletRequest request) {
		Console console = new Console();
		console.setName(request.getParameter("consola"));
		console.setCompany(request.getParameter("nom_Empresa"));
		return console;
	}
}