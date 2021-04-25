package com.javaapi.RestApi.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaapi.RestApi.example.entity.Product;
import com.javaapi.RestApi.example.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product product) {
		return service.saveProduct(product);
	}
	@PostMapping("/addProducts")
	public List<Product> addProduct(@RequestBody List<Product> products) {
		return service.saveProducts(products);
	}
	
	@GetMapping("/products")
	public List<Product> finAllProducts(){
		return service.getProducts();
	}
	@GetMapping("/product/{id}")
	public Product  findById(int id) {
		return service.getProductById(id);
		
	}
	@DeleteMapping("/delete/{id}")
	public String deleteProduct(int id) {
		return service.deleteProduct(id);
		
	}
//	public Product  findById(int id) {
//		return service.getProductById(id);
//		
//	}
}
