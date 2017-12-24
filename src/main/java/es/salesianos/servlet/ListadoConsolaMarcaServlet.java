package es.salesianos.servlet;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Consolas;
import es.salesianos.repository.ConsolaRepository;

public class ListadoConsolaMarcaServlet extends HttpServlet{
	
	ConsolaRepository consoleRepository=new ConsolaRepository();
	
	Consolas empresa = new Consolas();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Optional<Consolas> listAllMarcs=consoleRepository.search(empresa);
		req.getSession().setAttribute("consoles", listAllMarcs);
		redirect(req,resp);
	}
	
	protected void redirect(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
		RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/ListadoConsolasMarcas.jsp");
		dispatcher.forward(req, resp);
	}

}
