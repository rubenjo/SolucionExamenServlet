package es.salesianos.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Videogame;
import es.salesianos.repository.VideogameRepository;

public class AltaVideojuegosServlet extends HttpServlet {

	VideogameRepository repository = new VideogameRepository();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<Videogame> listAllGames = repository.listAllGames();
		req.setAttribute("games", listAllGames);
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/AltaVideojuego.jsp");
		dispatcher.forward(req, resp);
	}

}
