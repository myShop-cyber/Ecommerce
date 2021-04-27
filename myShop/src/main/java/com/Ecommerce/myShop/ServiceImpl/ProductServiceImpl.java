package com.Ecommerce.myShop.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.Ecommerce.myShop.Dao.ProductDao;
import com.Ecommerce.myShop.Entity.Product;
import com.Ecommerce.myShop.Services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	public ProductDao productDao;

	@Override
	public List<Product> addProduct(Product addCourse) {
		
		productDao.save(addCourse);
		
		return productDao.findAll();
	}

	@Override
	public List<Product> findProduct() {
		// TODO Auto-generated method stub
		return productDao.findAll();
	}

	@Override
	public List<String> findCategories() {
		// TODO Auto-generated method stub
		List<Product> product = productDao.findAll();
		List <String> li = new ArrayList<String>();
		for(Product p : product) {
			li.add(p.getCategories());
		}
		
		ArrayList<String> filteredList = new ArrayList<String>();
		
		for(String category: li) {
			if(!filteredList.contains(category)) {
				filteredList.add(category);
			}
		}
		
		return filteredList;
	}

	@Override
	public List<Product> filterpoductByCategory(String categories) {
		List<Product> products = productDao.findAll();
		ArrayList<Product> filteredProducts = new ArrayList<Product>();
		
		for(Product product : products ) {
			String category = product.getCategories().toString();
			if(categories.equalsIgnoreCase(category)) {
				filteredProducts.add(product);
			}
		}
		
		return filteredProducts;
	}

	@Override
	public Product findByProductNumber(String productNumber) {
	   List<Product> products = productDao.findAll();
	   Product p = null; 
	   for(Product product : products ) {
		   String pNumber = product.getProductNumber();
			if(productNumber.equalsIgnoreCase(pNumber)) {
				p = product;
			}
		   
		}
		return p;
	}

	@Override
	public List<Product> findProductBykey(String key) {
		List<Product> products = productDao.findAll();
		ArrayList<Product> filteredProducts = new ArrayList<Product>();
		String SearchKey = key.toLowerCase();
		 for(Product product : products ) {
			 if(product.getKeyPair() != null) {

				   if(product.getKeyPair().contains(SearchKey)) {
					   filteredProducts.add(product);
				   }
				   
			 }
			}
		
		return filteredProducts;
	}

	
}
