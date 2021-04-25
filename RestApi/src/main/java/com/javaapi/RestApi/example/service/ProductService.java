package com.javaapi.RestApi.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.javaapi.RestApi.example.entity.Product;

import com.javaapi.RestApi.example.repository.ProductRepository;



@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public Product  saveProduct(Product product) {
		return repository.save(product);
	}
	public  List<Product>  saveProducts(List<Product> products) {
		return repository.saveAll(products);
	}
	public  List<Product>  getProducts() {
		return repository.findAll();
	}
	public  Product  getProductById(int id) {
		return repository.findById(id).orElse(null);
	}
//	public  Product  getProductByval(int val) {
//		return repository.findByValue(val).orElse(null);
//	}
	


}
