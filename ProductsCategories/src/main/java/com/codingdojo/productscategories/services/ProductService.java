package com.codingdojo.productscategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.productscategories.models.Category;
import com.codingdojo.productscategories.models.Product;
import com.codingdojo.productscategories.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepo;
	public List<Product> findAll(){
		return productRepo.findAll();
	}
	public Product findById(Long id) {
		Optional<Product> potential= productRepo.findById(id);
		if (potential.isPresent()) {
			return potential.get();
		}
			
		return null;
	}
	public Product createProduct(Product b) {
		return productRepo.save(b);
	}
	public List <Product>findByCategoriesNotContains(Category category){
		return productRepo.findByCategoriesNotContains(category);
	}
}
