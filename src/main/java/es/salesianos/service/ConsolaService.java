package es.salesianos.service;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.assembler.ConsolaAssembler;
import es.salesianos.model.Console;
import es.salesianos.repository.ConsoleRepository;

public class ConsolaService implements Service {

	ConsolaAssembler assembler = new ConsolaAssembler();
	private ConsoleRepository repository = new ConsoleRepository();

	public void createNewConsoleFromRequest(HttpServletRequest request) {
		Console console = assembler.createConsolaFromRequest(request);

		if (!repository.search(console).isPresent()) {
			repository.insert(console);
		} else {
			repository.update(console);
		}
	}
}
