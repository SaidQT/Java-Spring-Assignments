package com.codingdojo.loginandregistration.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.loginandregistration.models.LoginUser;
import com.codingdojo.loginandregistration.models.User;
import com.codingdojo.loginandregistration.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class HomeController {
	@Autowired
	private UserService userServ;

	@GetMapping("/")
	public String index(@ModelAttribute("user") User newUser, @ModelAttribute("newLogin") User User) {
		return "register.jsp";
	}

	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User newUser, BindingResult result, Model model,
			HttpSession session) {
		User user = userServ.register(newUser, result);

		if (result.hasErrors()) {
			model.addAttribute("newLogin", new User());
			return "register.jsp";
		}
		if (session.getAttribute("userid") == null) {
			session.setAttribute("userid", user.getId());
			session.setAttribute("user", user.getUserName());
		}
		return "redirect:/books";
	}

	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model,
			HttpSession session) {
		User user = userServ.login(newLogin, result);
		if (result.hasErrors()) {
			model.addAttribute("user", new User());
			return "register.jsp";
		}
		if (session.getAttribute("userid") == null) {
			session.setAttribute("userid", user.getId());
			session.setAttribute("user", user.getUserName());
		}

		return "redirect:/books";

	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
