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
public class ProductController {
	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;

	@GetMapping("/")
	public String index(Model model) {
		List<Product> products = productService.findAll();
		List<Category> categories = categoryService.findAll();
		model.addAttribute("products", products);
		model.addAttribute("categories", categories);
		return "index.jsp";
	}

	@GetMapping("products/new")
	public String product(@ModelAttribute("product") Product product, Model model) {

		return "product.jsp";
	}

	@PostMapping("/createproduct")
	public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if (result.hasErrors()) {
			return "product.jsp";
		} else {
			productService.createProduct(product);
			return "redirect:/";
		}
	}

	@GetMapping("/products/{id}")
	public String showInfo(@PathVariable("id") Long id, @ModelAttribute("product") Product product, Model model) {
		Product shownProduct = productService.findById(id);
		model.addAttribute("product", shownProduct);
		List <Category> remainingCategories= categoryService.findByProductsNotContains(shownProduct);
		model.addAttribute("remaining", remainingCategories);
		List<Category> categories=shownProduct.getCategories();
		model.addAttribute("categories", categories);
		return "products.jsp";
	}

	@PostMapping("/create/{productId}")
	public String createCategoryForProduct(@PathVariable("productId") Long productId,@RequestParam("categoryId") Long categoryId) {
		Product shownProduct = productService.findById(productId);
		Category category= categoryService.findById(categoryId);
		shownProduct.getCategories().add(category);
		productService.createProduct(shownProduct);
		return "redirect:/";
	}
}
