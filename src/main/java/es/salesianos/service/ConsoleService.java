package es.salesianos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.salesianos.model.Console;
import es.salesianos.repository.ConsoleRepository;

@Service
public class ConsoleService {
	
	@Autowired
	private ConsoleRepository repository;
	
	public void insert(Console console) {
		repository.insert(console);
	}

	public void delete(String name) {
		repository.delete(name);	
	}
	
	public List<Console> listAll() {
		return repository.listAllConsoles();
	}

	public ConsoleRepository getRepository() {
		return repository;
	}

	public void setRepository(ConsoleRepository repository) {
		this.repository = repository;
	}
}
