package com.Ecommerce.myShop.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ecommerce.myShop.Entity.Favorites;

public interface favoritesJpaDao extends JpaRepository<Favorites, Integer>{

}
