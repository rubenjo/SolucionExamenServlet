package es.salesianos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import es.salesianos.model.Company;
import es.salesianos.model.Console;
import es.salesianos.service.CompanyService;

@Controller
public class CompanyController {

	@Autowired
	private CompanyService service;

	@GetMapping("/addCompany")
	public ModelAndView company() {
		return new ModelAndView("addCompany", "command", new Company());
	}
	
	@GetMapping("/deleteCompany")
	public ModelAndView deleteCompany(@ModelAttribute String name) {
		ModelAndView model = new ModelAndView("confirmationCompany", "command", new Company());
		model.addObject("name", name);
		return model;
	}
	
	@PostMapping("/deleteCompany")
	public ModelAndView deleteCompanyConfirm(@ModelAttribute String name) {
		service.delete(name);
		ModelAndView modelAndView = new ModelAndView("listCompany", "command", new Company());
		modelAndView.addObject("listAllCompanies", service.listAll());
		return modelAndView;
	}

	@GetMapping("/listConsolesByCompany")
	public ModelAndView listConsolesByCompany() {
		ModelAndView modelAndView = new ModelAndView("listConsolesCompany", "command", new Console());
		modelAndView.addObject("listAllCompanies", service.listAll());
		return modelAndView;
	}

	@GetMapping("/listCompany")
	public ModelAndView listCompany() {
		ModelAndView modelAndView = new ModelAndView("listCompany", "command", new Company());
		modelAndView.addObject("listAllCompanies", service.listAll());
		return modelAndView;
	}

}
