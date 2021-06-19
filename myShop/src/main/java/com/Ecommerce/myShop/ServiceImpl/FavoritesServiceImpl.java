package com.Ecommerce.myShop.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecommerce.myShop.Dao.favoritesJpaDao;
import com.Ecommerce.myShop.Dao.productJpaDao;
import com.Ecommerce.myShop.Entity.Favorites;
import com.Ecommerce.myShop.Entity.Product;
import com.Ecommerce.myShop.Services.FavoritesService;


@Service
public class FavoritesServiceImpl implements FavoritesService{

	@Autowired
	public favoritesJpaDao jpaDao;
	
	@Autowired
	public productJpaDao productJpaDao;
	
	
	@Override
	public boolean addToFavorites(Favorites favorite) {
		boolean res = false;
		try {
				jpaDao.save(favorite);
				res = true;
		}catch(Exception e) {
			res = false;
		}
		
		
		return res;
	}


	@Override
	public boolean removeFavorites(String email, String productNumber) {
		boolean res = false;
	
		List<Favorites> li = jpaDao.findAll();
		
		for(Favorites fav : li) {
			if(fav.getEmail().equalsIgnoreCase(email)  && fav.getProductId().equalsIgnoreCase(productNumber)) {
				jpaDao.delete(fav);
				res = true;
			}
		}
		
		return res;
	}


	@Override
	public boolean isFavorites(String email, String productNumber) {
		boolean res = false;
		
		List<Favorites> li = jpaDao.findAll();
		
		for(Favorites fav : li) {
			if(fav.getEmail().equalsIgnoreCase(email)  && fav.getProductId().equalsIgnoreCase(productNumber)) {
				res = true;
			}
		}
		
		return res;
	}


	@Override
	public List<Product> favouriteList(String email) {
		
		List<Favorites> li = jpaDao.findAll();
		List<Product> pli = productJpaDao.findAll();
		
		List<Favorites> favList = new ArrayList<Favorites>();
		List<Product> productList = new ArrayList<Product>();
		
		for(Product product : pli) {
			for (Favorites fav : li) {
				if(fav.getEmail().equalsIgnoreCase(email)) {
					if (fav.getProductId().equalsIgnoreCase(product.getProductNumber())) {
						productList.add(product);
					}
				}
			}
		
		}
		
		return productList;
	}

}
