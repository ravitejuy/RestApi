package com.javaapi.RestApi.example.controller;

import java.util.List;

import javax.sound.sampled.Line;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaapi.RestApi.example.entity.Product;
import com.javaapi.RestApi.example.service.Links;
import com.javaapi.RestApi.example.service.Meta;
import com.javaapi.RestApi.example.service.MultipartFile;
import com.javaapi.RestApi.example.service.ProductService;
import com.javaapi.RestApi.example.service.RequestParam;
import com.javaapi.RestApi.example.service.ResponseJsonBean;

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

	@PostMapping(value = "/FetchNext")
	public FetchNext<Object> save(@RequestBody int Id,
			@RequestBody int val, @RequestBody int nxtval) {

		Response<Object> responseBean = null;
		Line link = new Links();
		Meta meta = new Meta();
		try {
			responseBean = new ResponseJsonBean<Object>();
			meta.setTotalPages("1");
			link.setSelf("/uploadContractDoc");
			ProductService.FetchNext(Id, val, nxtval);
			responseBean.setCode("200");
			responseBean.setData("success");
			responseBean.setMessage("success");
			responseBean.setMeta(meta);
			responseBean.setLinks(link);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return responseBean;

	}
//	public Product  findById(int id) {
//		return service.getProductById(id);
//		
//	}
}
