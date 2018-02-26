package es.salesianos.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import es.salesianos.model.Console;
import es.salesianos.service.ConsoleService;

@Controller
public class ConsoleController {
	
	private static Logger log=new LogManager.getLogger(CompanyController.class);
	
	@Autowired
	@Qualifier(value="consoleService")
	private ConsoleService service;
	
	@PostMapping("/AltaConsola")
	public ModelAndView saveConsole(@ModelAttribute Console console) {
		service.insert(console);
		return new ModelAndView("altaC")
	}

}
