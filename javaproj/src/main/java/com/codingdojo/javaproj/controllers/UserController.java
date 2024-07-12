package com.codingdojo.javaproj.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.javaproj.models.Contact;
import com.codingdojo.javaproj.models.LoginUser;
import com.codingdojo.javaproj.models.User;
import com.codingdojo.javaproj.services.ContactService;
import com.codingdojo.javaproj.services.EmailService;
import com.codingdojo.javaproj.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private ContactService contactService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private UserService userService;
    
    
    @GetMapping("/contactwithtemp")
    public String show() {
        return "contact.jsp";
    }

    @GetMapping("/contact")
    public String showContactForm(Model model) {
        model.addAttribute("contact", new Contact());
        return "contact.jsp";
    }

    @PostMapping("/contact")
    public String submitContactForm(@Valid @ModelAttribute("contact") Contact contact, BindingResult result,
            Model model) {
        if (result.hasErrors()) {
            return "contact.jsp";
        }
        contactService.saveContact(contact);
        emailService.sendContactMessage(contact);
        model.addAttribute("successMessage", "Your message has been sent successfully!");
        return "contact.jsp";
    }

    @GetMapping("/login")
    public String index(Model model) {
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "login.jsp";
    }

    @GetMapping("/shop/add/pet")
    public String contactUs(Model model) {
        return "newPet.jsp";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model,
            HttpSession session) {
        User registeredUser = userService.register(newUser, result);

        if (result.hasErrors()) {
            model.addAttribute("newLogin", new LoginUser());
            return "login.jsp";
        }

        // Store user ID in session (log them in)
        session.setAttribute("userId", registeredUser.getId());

        return "redirect:/home";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model,
            HttpSession session) {
        User user = userService.login(newLogin, result);

        if (result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "login.jsp";
        }

        session.setAttribute("userId", user.getId());

        return "redirect:/home";
    }

    @GetMapping("/home")
    public String home(HttpSession session, Model model) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/";
        }

        Optional<User> user = userService.findUserById(userId);
        if (user.isPresent()) {
            model.addAttribute("user", user.get());
            return "home.jsp";
        } else {
            session.invalidate();
            return "redirect:/";
        }
    }

    @GetMapping("/cats")
    public String cats(Model model) {
        return "cats.jsp";
    }

    @GetMapping("/dogs")
    public String dogs(Model model) {
        return "dogs.jsp";
    }

    @GetMapping("/birds")
    public String birds(Model model) {
        return "birds.jsp";
    }

}
