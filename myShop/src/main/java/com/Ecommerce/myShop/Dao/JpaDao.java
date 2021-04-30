package com.Ecommerce.myShop.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ecommerce.myShop.Entity.Product;


public interface JpaDao extends JpaRepository<Product, Integer>{

}
