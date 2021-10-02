package com.onetomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onetomany.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
