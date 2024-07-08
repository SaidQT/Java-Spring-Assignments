package com.assignments.LoginandRegistration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.assignments.LoginandRegistration.Models.Course;
import com.assignments.LoginandRegistration.Models.User;
import com.assignments.LoginandRegistration.service.CourseService;
import com.assignments.LoginandRegistration.service.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class CourseController {
	@Autowired
	CourseService courseServ;
	@Autowired
	UserService userServ;

	@GetMapping("/classes")
	public String showClasses(Model model, HttpSession session) {
		if (session.getAttribute("userid") == null) {
			return "redirect:/";
		}
		Long userid = (Long) session.getAttribute("userid");
		User user = userServ.findUser(userid);
		model.addAttribute("user", user);
		List<Course> courses = courseServ.allCourses();
		model.addAttribute("courses", courses);
		return "welcome.jsp";
	}

	@GetMapping("/classes/new")
	public String createCourse(@ModelAttribute("course") Course course, HttpSession session) {
		if (session.getAttribute("userid") == null) {
			return "redirect:/";
		}
		return "course.jsp";
	}

	@PostMapping("/classes/new")
	public String createCourse(@Valid @ModelAttribute("course") Course course, BindingResult result,
			HttpSession session) {
		if (result.hasErrors()) {
			return "course.jsp";
		}
		Long userid = (Long) session.getAttribute("userid");
		User user = userServ.findUser(userid);
		courseServ.createCourse(course, user);

		return "redirect:/classes";
	}

	@GetMapping("/classes/{id}/edit")
	public String editCourse(@PathVariable("id") Long id, @ModelAttribute("course") Course course, HttpSession session,
			Model model) {
		if (session.getAttribute("userid") == null) {
			return "redirect:/";
		}
		Course editCourse = courseServ.findCourse(id);
		model.addAttribute("course", editCourse);
		return "edit.jsp";
	}

	@PutMapping("/edit/{id}")
	public String editForm(@PathVariable("id") Long id, @Valid @ModelAttribute("course") Course course,
			BindingResult result, HttpSession session) {
		if (result.hasErrors()) {
			return "edit.jsp";
		}
		Long userid = (Long) session.getAttribute("userid");
		User user = userServ.findUser(userid);
		courseServ.updateCourse(course, user);

		return "redirect:/classes";
	}
	@GetMapping("/cancel")
	public String cancelAction() {
		return "redirect:/classes";
	}
	@DeleteMapping("/classes/{id}")
    public String destroy(@PathVariable("id") Long id) {
        courseServ.deleteById(id);
        return "redirect:/classes";
    }
	@GetMapping("/classes/{id}")
	public String showCourse(@PathVariable("id") Long id, Model model) {
		Course shownCourse=courseServ.findCourse(id);
		model.addAttribute("course", shownCourse);
		return "show.jsp";
	}
}
