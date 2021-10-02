package com.onetomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onetomany.entity.Brand;

public interface BrandRepository extends JpaRepository<Brand, Integer>{

}
