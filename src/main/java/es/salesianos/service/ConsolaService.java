package es.salesianos.service;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.assembler.ConsoleAssembler;
import es.salesianos.model.Console;
import es.salesianos.repository.ConsoleRepository;

public class ConsolaService implements Service {

	ConsoleAssembler assembler = new ConsoleAssembler();
	private ConsoleRepository repository = new ConsoleRepository();

	public void createNewConsoleFromRequest(HttpServletRequest request) {
		Console console = assembler.createConsoleFromRequest(request);

		if (!repository.search(console).isPresent()) {
			repository.insert(console);
		} else {
			repository.update(console);
		}
	}
}
