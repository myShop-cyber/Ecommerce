package com.Ecommerce.myShop.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.Ecommerce.myShop.Dao.productJpaDao;
import com.Ecommerce.myShop.Entity.Product;
import com.Ecommerce.myShop.Services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	public productJpaDao jpaDao;
	
	@Autowired
    private JavaMailSender javaMailSender;

	@Override
	public List<Product> addProduct(Product addCourse) {
		
		jpaDao.save(addCourse);
		
		return jpaDao.findAll();
	}

	@Override
	public List<Product> findProduct() {
		// TODO Auto-generated method stub
		return jpaDao.findAll();
	}

	@Override
	public List<String> findCategories() {
		// TODO Auto-generated method stub
		List<Product> product = jpaDao.findAll();
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
		List<Product> products = jpaDao.findAll();
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
	   List<Product> products = jpaDao.findAll();
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
		List<Product> products = jpaDao.findAll();
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

	@Override
	public void sendEmail(String name, String message) {
		 SimpleMailMessage msg = new SimpleMailMessage();
	        msg.setTo("prasadvikas0557@gmail.com");

	        msg.setSubject("my shop customer query");
	        msg.setText("name:- "+name +"\nquery:- "+message);

	        javaMailSender.send(msg);
		
	}

	
}
