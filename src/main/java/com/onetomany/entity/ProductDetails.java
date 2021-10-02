package com.onetomany.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ProductDetails {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   @Column(nullable = false)
   private String name;
   @Column(nullable = false)
   private String value;
   @ManyToOne
   @JoinColumn(name = "product_id")
   private Product product;
   public ProductDetails()
   {
	   super();
   }
public ProductDetails(int id, String name, String value, Product product) {
	super();
	this.id = id;
	this.name = name;
	this.value = value;
	this.product = product;
}
public ProductDetails(int id, String name, String value) {
	super();
	this.id = id;
	this.name = name;
	this.value = value;
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
public String getValue() {
	return value;
}
public void setValue(String value) {
	this.value = value;
}
public Product getProduct() {
	return product;
}
public void setProduct(Product product) {
	this.product = product;
}
   
}
