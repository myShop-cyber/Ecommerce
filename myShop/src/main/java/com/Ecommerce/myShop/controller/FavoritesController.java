package com.Ecommerce.myShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Ecommerce.myShop.Entity.Favorites;
import com.Ecommerce.myShop.Services.FavoritesService;

@RestController
public class FavoritesController {

	@Autowired
	private FavoritesService favoritesService;
	
	@CrossOrigin
	@PostMapping("/addFavorites")
	public boolean addToFavorites(@RequestBody Favorites favorite) {
		
		return favoritesService.addToFavorites(favorite);
	}
	
	@CrossOrigin
	@GetMapping("/removeFavorites/{email}/{productNumber}")
	public boolean removeFavorites(@PathVariable String email,@PathVariable String productNumber) {
		
		return favoritesService.removeFavorites(email, productNumber);
	}
}
