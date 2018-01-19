package es.salesianos.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Consolas;
import es.salesianos.repository.ConsolaRepository;

public class AltaConsolaServlet extends HttpServlet{
	
	ConsolaRepository repository=new ConsolaRepository();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Console> listAllConsoles=repository.listAllConsoles();
		req.getSession().setAttribute("consoles", listAllConsoles);
		redirect(req,resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
		RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/AltaConsola.jsp");
		dispatcher.forward(req, resp);
	}
	
	

}
