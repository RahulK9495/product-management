package com.product.dao;

import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.product.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	
	public List<Product> findByCategoryOrPrice(String category, double price);
	
	public List<Product> findByNameStartingWith(String startingwith);
	
	public Integer countByCategory(String category);

	public Boolean existsByCategory(String category);
	
	public List<Product> findByPriceBetween(double minprice, double maxprice);

	Page<Product> findAll(Pageable pageable);
}
