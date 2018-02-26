package es.salesianos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.salesianos.model.Company;
import es.salesianos.repository.CompanyRepository;

@Service
public class CompanyService {

	@Autowired
	private CompanyRepository repository = new CompanyRepository();

	public void insert(Company company) {
 		repository.insert(company);
 	}

	public void delete(String name) {
 		repository.delete(name);
 	}

	public List<Company> listAll() {
		return repository.listAllCompanies();
	}

	public CompanyRepository getRepository() {
		return repository;
	}

	public void setRepository(CompanyRepository repository) {
		this.repository = repository;
	}
}
