package com.codingdojo.productscategories.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.productscategories.models.Category;
import com.codingdojo.productscategories.models.Product;
import com.codingdojo.productscategories.services.CategoryService;
import com.codingdojo.productscategories.services.ProductService;

import jakarta.validation.Valid;

@Controller
public class CategoryController {
	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;
	@GetMapping("/category/add")
	public String addCategory(@ModelAttribute("category") Category category) {

		return "category.jsp";
	}

	@PostMapping("/createcategory")
	public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if (result.hasErrors()) {
			return "category.jsp";
		} else {
			categoryService.createCategory(category);
			return "redirect:/";
		}
	}

	@GetMapping("/category/{id}")
	public String showCategory(@PathVariable("id") Long id, @ModelAttribute("category") Category category,
			Model model) {
		Category shownCategory = categoryService.findById(id);
		model.addAttribute("category", shownCategory);
		List<Product> remainingProducts= productService.findByCategoriesNotContains(shownCategory);
		model.addAttribute("remaining", remainingProducts);
		List<Product> products= shownCategory.getProducts();
		model.addAttribute("products", products);
		return "categories.jsp";
	}
	@PostMapping("/create/category/{id}")
	public String createProductforCategory(@PathVariable("id") Long id,@RequestParam("productId") Long productId) {
		Category shownCategory = categoryService.findById(id);
		Product product= productService.findById(id);
		shownCategory.getProducts().add(product);
		categoryService.createCategory(shownCategory);
		return "redirect:/";
	}
}
