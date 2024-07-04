package com.codingdojo.dojoandninjas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.dojoandninjas.models.Dojo;
import com.codingdojo.dojoandninjas.services.DojoService;

import jakarta.validation.Valid;

@Controller
public class DojoController {
	@Autowired
	DojoService dojoService;

	@RequestMapping("/dojos/new")
	public String index(@ModelAttribute("dojo") Dojo dojo) {
		return "index2.jsp";
	}

	@PostMapping("/dojos/create")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {
			return "index2.jsp";
		}
		dojoService.createDojo(dojo);
		return "redirect:/dojos/new";
	}
	
	@GetMapping("dojos/{dojoId}")
	public String ninjaTable(@PathVariable("dojoId") Long id, Model model) {
		Dojo dojo= dojoService.findDojo(id);
		model.addAttribute("ninjas", dojo.getNinjas());
		model.addAttribute("name", dojo.getName());
		return "table.jsp";
	}
}
