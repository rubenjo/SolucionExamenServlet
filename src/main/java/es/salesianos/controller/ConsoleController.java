package es.salesianos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import es.salesianos.model.Console;
import es.salesianos.model.Videogame;
import es.salesianos.service.ConsoleService;

@Controller
public class ConsoleController {
	
	@Autowired
	@Qualifier(value = "consoleService")	
	private ConsoleService service;
	
	@PostMapping("/addConsole")
	public ModelAndView saveConsole(@ModelAttribute Console console) {
		service.insert(console);
		return new ModelAndView("addConsole", "command", new Console());
	}
	
	@GetMapping("/addVideogame")
	public ModelAndView videogame() {
		ModelAndView modelAndView=new ModelAndView("addVideogame","command",new Videogame());
		modelAndView.addObject("listAllConsoles",service.listAll());
		return modelAndView;
	}
	
	@GetMapping("/listConsole")
	public ModelAndView listConsole() {
		ModelAndView modelAndView = new ModelAndView("listConsole", "command", new Console());
		modelAndView.addObject("listAllConsoles", service.listAll());
		return modelAndView;
	}

}
