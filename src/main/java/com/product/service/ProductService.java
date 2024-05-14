package com.product.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.product.entity.Product;

public interface ProductService {
	
	public Product getProductById(long id);

	public List<Product> getAllProducts();

	public Product saveProduct(Product product);

	public Product updateProduct(Product product);

	public void deleteProduct(long id);

	public List<Product> searchProducts();

	public List<Product> getAllProductsSortBy();

	public List<Product> getAllProductsByCategoryAndPrice(String category, double price);

	public List<Product> getAllProductsStartingwith(String startingwith);

	public Integer getAllProductsByCategory(String category);

	public Boolean getAllProductsexistsByCategory(String category);

	public List<Product> getAllProductwithinPriceRange(double minprice, double maxprice);

	public Page<Product> getAllProductsPagination(Pageable pageable);
}
