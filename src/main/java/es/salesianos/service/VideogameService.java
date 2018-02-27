package es.salesianos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.salesianos.model.Videogame;
import es.salesianos.repository.VideogameRepository;

@Service
public class VideogameService {

	@Autowired
 	private VideogameRepository repository;

 	public void insert(Videogame videogame) {
 		repository.insert(videogame);
 	}
 
 	public void delete(String name) {
 		repository.delete(name);
 	}
 
 	public List<Videogame> listAll() {
 		return repository.listAllVideogames();
 	}
 
 	public VideogameRepository getRepository() {
 		return repository;
 	}
 
 	public void setRepository(VideogameRepository repository) {
 		this.repository = repository;
 	}
}
