package es.salesianos.servlet;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Console;
import es.salesianos.model.Videogame;
import es.salesianos.repository.VideogameRepository;

public class ListadoVideojuegosMarca extends HttpServlet{
	
	VideogameRepository gameRepositoy=new VideogameRepository();
	
	Console console=new Console();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Optional<Videogame> searchAllMarcs=gameRepositoy.search(console);
		req.setAttribute("consoles", searchAllMarcs);
		redirect(req,resp);
	}
	
	protected void redirect(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
		RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/ListadoVideojuegosMarcas.jsp");
		dispatcher.forward(req, resp);
	}
}
