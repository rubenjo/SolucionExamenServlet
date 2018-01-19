package es.salesianos.servlet;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Consolas;
import es.salesianos.model.Videojuegos;
import es.salesianos.repository.VideojuegoRepository;

public class ListadoVideojuegosMarca extends HttpServlet{
	
	VideojuegoRepository juegosRepository=new VideojuegoRepository();
	
	Console consola=new Console();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Optional<Videogame> searchAllMarcs=juegosRepository.search(consola);
		req.getSession().setAttribute("consoles", searchAllMarcs);
		redirect(req,resp);
	}
	
	protected void redirect(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
		RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/ListadoVideojuegosMarcas.jsp");
		dispatcher.forward(req, resp);
		req.getParameter("edadRecomendada");
	}
}
