package es.salesianos.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Consolas;

public class ConsolaAssembler {

		public Consolas createConsolaFromRequest(HttpServletRequest request){
			
			Consolas consola=new Consolas();
			consola.setConsola(request.getParameter("consola"));
			consola.setNom_Empresa(request.getParameter("nom_Empresa"));
			
			return consola;
		}

}