package com.Ecommerce.myShop.Services;

import java.util.List;

import com.Ecommerce.myShop.Entity.Favorites;
import com.Ecommerce.myShop.Entity.Product;

public interface FavoritesService {

	public boolean addToFavorites(Favorites favorite);
	
	public boolean removeFavorites(String email, String productNumber);
	  
	public boolean isFavorites(String email, String productNumber);
	
	public List<Product> favouriteList(String email);
	
}
