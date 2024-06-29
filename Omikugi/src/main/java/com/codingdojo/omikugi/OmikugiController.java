package com.codingdojo.omikugi;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class OmikugiController {
	@RequestMapping("/omikugi")
	public String index() {
		return "index.jsp";
	}
	@RequestMapping("/omikugi/show")
	public String show() {
		return "show.jsp";
	}
	@RequestMapping("/play")
	public String play(@RequestParam(value="random") Integer random,
	    	@RequestParam(value="city") String city,
	    	@RequestParam(value="person") String person,
	    	@RequestParam(value="hobby") String hobby,
	    	@RequestParam(value="living") String living,
	    	@RequestParam(value="message") String message, HttpSession session) {
		session.setAttribute("random", random);
		session.setAttribute("city", city);
		session.setAttribute("person", person);
		session.setAttribute("hobby", hobby);
		session.setAttribute("living", living);
		session.setAttribute("message", message);
		return "redirect:/omikugi/show";
	}
}
