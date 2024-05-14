package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.product.entity.Product;
import com.product.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags="Product controller methods")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/products/{id}")
	@ApiOperation("Get product by id ")
	public Product getSampleProduct(@PathVariable int id)
	{
		return productService.getProductById(id);
	}
	
	@GetMapping("/products")
	public List<Product> getAllProducts()
	{
		return productService.getAllProducts();
	}
	@PostMapping ("/products")
	public Product saveProducts(@RequestBody Product product)
	{
		return productService.saveProduct(product);
	}
	@DeleteMapping("/products/{id}")
	public void deleteProduct(@PathVariable int id)
	{
		productService.deleteProduct(id);
	}
	
	@GetMapping("/products/cat")
	public List<Product> getAllProductsByCategoryAndPrice(@RequestParam String category, @RequestParam double price)
	{
		return productService.getAllProductsByCategoryAndPrice(category,price);
	}
	
	@GetMapping("/products/startingwith/{startingwith}")
	public List<Product> getAllProductsStartingwith(@PathVariable String startingwith)
	{
		return productService.getAllProductsStartingwith(startingwith);
	}
	@GetMapping("/products/category/count/{category}")
	public Integer getAllProductsByCategory(@PathVariable String category)
	{
		return productService.getAllProductsByCategory(category);
	}
	
	@GetMapping("/products/category/exist/{category}")
	public Boolean getAllProductsexistsByCategory(@PathVariable String category)
	{
		return productService.getAllProductsexistsByCategory(category);
	}

	@GetMapping("/products/withinprice")
	public List<Product> getAllProductwithinPriceRange(@RequestParam double minprice, @RequestParam double maxprice)
	{
		return productService.getAllProductwithinPriceRange(minprice,maxprice);
	}
	
	@GetMapping("/products/page")
	public Page<Product> getProductsPagination(@RequestParam (defaultValue ="o") int page, @RequestParam(defaultValue="3")int size)
	{
		PageRequest Pageable = PageRequest.of(page, size);
		 return productService.getAllProductsPagination(Pageable);
	}

}
