package com.codingdojo.exam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.exam.models.LoginUser;
import com.codingdojo.exam.models.User;
import com.codingdojo.exam.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {
	@Autowired
	private UserService userServ;

	@GetMapping("/")
	public String index(@ModelAttribute("user") User newUser, @ModelAttribute("newLogin") User User) {
		return "index.jsp";
	}

	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User newUser, BindingResult result, Model model,
			HttpSession session) {
		User user = userServ.register(newUser, result);
		if (result.hasErrors()) {
			model.addAttribute("newLogin", new User());
			return "index.jsp";
		}
		if (session.getAttribute("userid") == null) {
			session.setAttribute("userid", user.getId());
			session.setAttribute("name", user.getUserName());
		}
		return "redirect:/";
	}

	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model,
			HttpSession session) {
		User user = userServ.login(newLogin, result);
		if (result.hasErrors()) {
			model.addAttribute("user", new User());
			return "index.jsp";
		}
		if (session.getAttribute("userid") == null) {
			session.setAttribute("userid", user.getId());
			session.setAttribute("name", user.getUserName());
		}
		return "redirect:/";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}