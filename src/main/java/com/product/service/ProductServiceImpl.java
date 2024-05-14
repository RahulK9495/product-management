package com.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.product.dao.ProductRepository;
import com.product.entity.Product;
import com.product.exception.InvalidProductException;
import com.product.exception.ProductNotFoundException;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Product getProductById(long id) {

		Optional<Product> opt = productRepository.findById(id);
		if(opt.isPresent())
			return opt.get();
		else
			throw new ProductNotFoundException("Product with id is not available in database");
		
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public Product saveProduct(Product product) {
		// TODO Auto-generated method stub
		Product fetchcedProduct = null;
		if(validProduct(product))
			fetchcedProduct= productRepository.save(product);
		return fetchcedProduct;

	}

	private boolean validProduct(Product product) {
		
		if(product.getName().length()<5)
			throw new InvalidProductException("Product name is not valid");
		else if(product.getPrice()<100)
		throw new InvalidProductException("Product price must be greater than 100");
		else
			return true;
	}

	@Override
	public Product updateProduct(Product product) {
		// TODO Auto-generated method stub
		return productRepository.save(product);
	}

	@Override
	public void deleteProduct(long id) {
		// TODO Auto-generated method stub
		productRepository.deleteById(id);
	}

	@Override
	public List<Product> searchProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getAllProductsSortBy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getAllProductsByCategoryAndPrice(String category, double price) {
		
		return productRepository.findByCategoryOrPrice(category, price);
		
	}

	@Override
	public List<Product> getAllProductsStartingwith(String startingwith) {
		// TODO Auto-generated method stub
		return productRepository.findByNameStartingWith(startingwith);
	}

	@Override
	public Integer getAllProductsByCategory(String category) {
		// TODO Auto-generated method stub
		return productRepository.countByCategory(category);
	}

	@Override
	public Boolean getAllProductsexistsByCategory(String category) {
		// TODO Auto-generated method stub
		return productRepository.existsByCategory(category);
	}

	@Override
	public List<Product> getAllProductwithinPriceRange(double minprice, double maxprice) {
		
		return productRepository.findByPriceBetween(minprice, maxprice);
	}

	@Override
	public Page<Product> getAllProductsPagination(Pageable pageable) {
		
		return productRepository.findAll(pageable);
	}
	
	
	

}
