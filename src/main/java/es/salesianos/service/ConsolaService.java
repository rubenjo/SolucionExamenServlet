package es.salesianos.service;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.assembler.ConsolaAssembler;
import es.salesianos.model.Consolas;
import es.salesianos.repository.ConsolaRepository;

public class ConsolaService implements Service{

	ConsolaAssembler assembler=new ConsolaAssembler();
	private ConsolaRepository repository=new ConsolaRepository();
	public void createNewConsoleFromRequest(HttpServletRequest request){
		Consolas console=assembler.createConsolaFromRequest(request);
		
		if(!repository.search(console).isPresent()){
			repository.insert(console);
		}else{
			repository.update(console);
		}
	}
}
