package com.codingdojo.javaproj.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.javaproj.models.Pet;
import com.codingdojo.javaproj.models.User;
import com.codingdojo.javaproj.services.PetService;
import com.codingdojo.javaproj.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class PetController {
	@Autowired
	PetService petService;
	@Autowired
	UserService userService;

	@GetMapping("/shop/add")
	public String addShop(@ModelAttribute("pet") Pet pet) {
		return "addpet.jsp";
	}

	@PostMapping("/pets/new")
	public String createShop(@Valid @ModelAttribute("pet") Pet pet, BindingResult result) {
		if (result.hasErrors()) {
			return "addpet.jsp";
		} else {
			pet.setStatus("Unadopted");
			petService.createPet(pet);
			return "redirect:/pet/home";
		}
	}

	@GetMapping("/shop/home")
	public String showShops(Model model) {
		List<Pet> pets = petService.allPets();
		model.addAttribute("pets", pets);
		return "pet.jsp";
	}

	@GetMapping("/shop/{id}/edit")
	public String showInfo(@PathVariable("id") Long id, Model model) {
		Pet pet = petService.findPet(id);
		model.addAttribute("pet", pet);
		return "editpet.jsp";
	}

	@PutMapping("/pet/{id}")
	public String editInfo(@Valid @ModelAttribute("pet") Pet pet, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("pet", pet);
			return "editpet.jsp";
		} else {
			petService.updatePet(pet);
			return "redirect:/pet/home";
		}
	}

	@GetMapping("/shop/{id}/delete")
	public String destroy(@PathVariable("id") Long id) {
		petService.deletePet(id);
		return "redirect:/pet/home";
	}

	@GetMapping("/")
	public String UserPage() {
		return "UserPage.jsp";
	}

	@GetMapping("/favoritepage")
	public String FavoritePage() {
		return "FavortiePage.jsp";
	}

	@GetMapping("/categoriesname")
	public String CategoriesName() {
		return "categoryName.jsp";
	}

	@GetMapping("/categoriesname/{id}")
	public String displayOne(@PathVariable("id") Long id, Model model) {
		Pet pet = petService.findPet(id);
		model.addAttribute("pet", pet);
		return "petCategory.jsp";
	}

	@GetMapping("/cart")
	public String cart(Model model, HttpSession session) {
		List<Pet> pets = petService.allPets();
		model.addAttribute("pets", pets);
		if (session.getAttribute("userid") != null) {
			User user = userService.findUser((Long) session.getAttribute("userid"));
			model.addAttribute("user", user);
		}

		return "cart.jsp";
	}

	@PostMapping("/addPet")
	public String addPetToCart(@RequestParam("petId") Long petId, HttpSession session) {
		if (session.getAttribute("userid") != null) {
			Long userId = (Long) session.getAttribute("userid");
			User user = userService.findUser(userId);
			Pet pet = petService.findPet(petId);
			if (user != null && pet != null) {
				pet.getUsers().add(user); // Add pet to user's collection
				petService.createPet(pet); // Save the updated user
				return "redirect:/cart"; // Redirect to cart page after adding
			}
		}
		return "redirect:/login"; // Redirect to login if user is not logged in
	}
}
