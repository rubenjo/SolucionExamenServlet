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

public class EdadRecomendadaServlet extends HttpServlet {

	VideogameRepository gamesRepositorio = new VideogameRepository();

	Videogame games = new Videogame();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<Videogame> listAllAges = gamesRepositorio.listAllGames();
		req.setAttribute("games", listAllAges);
		redirect(req, resp);

	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListadoEdadServlet.jsp");
		dispatcher.forward(req, resp);
	}

}
