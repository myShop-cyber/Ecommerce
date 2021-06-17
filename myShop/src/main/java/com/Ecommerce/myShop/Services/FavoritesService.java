package com.Ecommerce.myShop.Services;

import com.Ecommerce.myShop.Entity.Favorites;

public interface FavoritesService {

	public boolean addToFavorites(Favorites favorite);
	
	public boolean removeFavorites(String email, String productNumber);
	
}
