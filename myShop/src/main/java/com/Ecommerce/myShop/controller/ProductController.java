package com.Ecommerce.myShop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Ecommerce.myShop.Entity.Product;
import com.Ecommerce.myShop.Services.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@CrossOrigin
	@GetMapping("/product")
	public List<Product> findProduct() {
		
		return productService.findProduct();
	}
	
	@CrossOrigin
	@GetMapping("/product/filter/catergoties/{categories}")
	public List<Product> filterpoductByCategory(@PathVariable String categories) {
		
		return productService.filterpoductByCategory(categories);
	}
	
	@CrossOrigin
	@GetMapping("/product/categories")
	public List<String> findCategories() {
		
		return productService.findCategories();
	}
	
	
	@PostMapping("/product/add")
	public List<Product> addProduct(@RequestBody Product product) {
		
		return productService.addProduct(product);
	}

	
}
