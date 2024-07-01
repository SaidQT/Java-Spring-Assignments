package com.codingdojo.dojoandninjas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.dojoandninjas.models.Dojo;
import com.codingdojo.dojoandninjas.models.Ninja;
import com.codingdojo.dojoandninjas.services.DojoService;
import com.codingdojo.dojoandninjas.services.NinjaService;

@Controller
public class NinjaController {
	@Autowired
	NinjaService ninjaService;
	@Autowired
	DojoService dojoService;
	@GetMapping("ninjas/new")
	public String index(@ModelAttribute("ninja") Ninja ninja, Model model ) {
		List<Dojo> dojos= dojoService.allDojos();
		model.addAttribute("dojos", dojos);
		return "index.jsp";
	}

	@PostMapping("ninjas/create")
	public String addNinja(@ModelAttribute("ninja") Ninja ninja) {
		
			ninjaService.createNinja(ninja);
			return "redirect:/ninjas/new";
	}
}
