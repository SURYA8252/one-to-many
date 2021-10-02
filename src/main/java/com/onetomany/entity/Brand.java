package com.onetomany.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
@Entity
public class Brand {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   @Column(nullable = false,unique = true)
   private String name;
   @OneToMany
   @JoinColumn(name = "brand_id")
   private List<Category> categories=new ArrayList<>();
   public Brand()
   {
	   super();
   }
public Brand(int id, String name, List<Category> categories) {
	super();
	this.id = id;
	this.name = name;
	this.categories = categories;
}
public Brand(int id, String name) {
	super();
	this.id = id;
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
public List<Category> getCategories() {
	return categories;
}
public void setCategories(List<Category> categories) {
	this.categories = categories;
}
@Override
public String toString() {
	return "Brand [id=" + id + ", name=" + name + ", categories=" + categories + "]";
}
   
}
