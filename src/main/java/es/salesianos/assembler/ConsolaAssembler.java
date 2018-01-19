package es.salesianos.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Console;

public class ConsolaAssembler {
	public Console createConsolaFromRequest(HttpServletRequest request) {
		Console consola = new Console();
		consola.setConsola(request.getParameter("consola"));
		consola.setNom_Empresa(request.getParameter("nom_Empresa"));
		return consola;
	}
}