package com.onetomany.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Category {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   @Column(nullable = false,unique = true)
   private String name;
   @ManyToOne
   @JoinColumn(name = "brand_id")
   private Brand brand;
   public Category()
   {
	   super();
   }
public Category(int id, String name,Brand brand) {
	super();
	this.id = id;
	this.name = name;
	this.brand=brand;
}

public Category(String name) {
	super();
	this.name = name;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Brand getBrand() {
	return brand;
}
public void setBrand(Brand brand) {
	this.brand = brand;
}
@Override
public String toString() {
	return name;
}

   
}
