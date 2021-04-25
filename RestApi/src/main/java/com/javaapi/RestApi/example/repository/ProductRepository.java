package com.javaapi.RestApi.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaapi.RestApi.example.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {

}
