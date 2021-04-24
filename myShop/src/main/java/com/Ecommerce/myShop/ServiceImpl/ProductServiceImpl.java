package com.Ecommerce.myShop.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

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

	
}
