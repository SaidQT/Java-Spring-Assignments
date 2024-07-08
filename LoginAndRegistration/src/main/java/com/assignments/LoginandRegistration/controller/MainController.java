package com.assignments.LoginandRegistration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.assignments.LoginandRegistration.Models.LogIn;
import com.assignments.LoginandRegistration.Models.User;
import com.assignments.LoginandRegistration.service.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class MainController {

	@Autowired
	UserService userservice;

	@GetMapping("/")
	public String index(Model model) {

		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LogIn());
		return "index.jsp";
	}

	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model,
			HttpSession session) {

		User user = userservice.register(newUser, result);
		if (result.hasErrors()) {
			model.addAttribute("newLogin", new LogIn());
			return "index.jsp";
		}
		session.setAttribute("userid", user.getId());

		return "redirect:/classes";

	}

	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LogIn newLogin, BindingResult result, Model model,
			HttpSession session) {
		User user = userservice.login(newLogin, result);
		if (result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "index.jsp";
		}
		session.setAttribute("userid", user.getId());
		return "redirect:/classes";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
