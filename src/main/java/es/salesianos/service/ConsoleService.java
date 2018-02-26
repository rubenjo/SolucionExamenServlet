package es.salesianos.service;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import es.salesianos.model.Console;
import es.salesianos.repository.ConsoleRepository;

public class ConsoleService implements Service {
	
	private static Logger log = LogManager.getLogger(CompanyService.class);
	@Autowired
	private ConsoleRepository repository = new ConsoleRepository();
	
	public void insert(Console console) {
		log.info("Insert new console: " + console);
		repository.insert(console);
	}

	public void delete(String name) {
		log.info("Delete console: "+ name);
		repository.delete(name);
	}
	public void createNewConsoleFromRequest(HttpServletRequest request) {
		Console console = assembler.createConsoleFromRequest(request);

		if (!repository.search(console).isPresent()) {
			repository.insert(console);
		} else {
			repository.update(console);
		}
	}
}
