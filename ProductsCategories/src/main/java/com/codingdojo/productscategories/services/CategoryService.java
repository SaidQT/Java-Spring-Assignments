package com.codingdojo.productscategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.productscategories.models.Category;
import com.codingdojo.productscategories.models.Product;
import com.codingdojo.productscategories.repositories.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	CategoryRepository categoryRepo;
	public List<Category> findAll(){
		return categoryRepo.findAll();
	}
	public Category findById(Long id) {
		Optional<Category> potential= categoryRepo.findById(id);
		if (potential.isPresent()) {
			return potential.get();
		}
			
		return null;
	}
	public Category createCategory(Category b) {
		return categoryRepo.save(b);
	}
	public List <Category>findByProductsNotContains(Product product){
		return categoryRepo.findByProductsNotContains(product);
	}
}
