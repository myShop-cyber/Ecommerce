package com.Ecommerce.myShop.Services;

import java.util.List;

import com.Ecommerce.myShop.Entity.Product;

public interface ProductService {

	public List<Product> findProduct();
	
	public List<String> findCategories();
	
	public List<Product> addProduct(Product addCourse);
	
}
