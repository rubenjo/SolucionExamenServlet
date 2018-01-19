package es.salesianos.servlet;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Console;
import es.salesianos.repository.ConsoleRepository;

public class ListadoConsolaMarcaServlet extends HttpServlet {

	ConsoleRepository consoleRepository = new ConsoleRepository();

	Console empresa = new Console();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Optional<Console> listAllMarcs = consoleRepository.search(empresa);
		req.getSession().setAttribute("consoles", listAllMarcs);
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/ListadoConsolasMarcas.jsp");
		dispatcher.forward(req, resp);
	}

}
