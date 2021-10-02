package com.onetomany.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.onetomany.entity.Category;
import com.onetomany.entity.Product;
import com.onetomany.repository.CategoryRepository;
import com.onetomany.repository.ProductRepository;

@Controller
public class ProductController {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;
   @GetMapping("/products/new")
   public String showProduct(Model model)
   {
	   List<Category> listCategories=categoryRepository.findAll();
	   model.addAttribute("product",new Product());
	   model.addAttribute("listCategories",listCategories);
	   return "product";
   }
   @PostMapping("/product/save")
   public String saveProduct(Product product)
   {
	   productRepository.save(product);
	   return "redirect:/products";
   }
   @GetMapping("/products")
   public String listProduct(Model model)
   {
	   List<Product> listProducts=productRepository.findAll();
	   model.addAttribute("listProducts",listProducts);
	   return "products";
   }
   @GetMapping("/products/edit/{id}")
   public String showEditProductForm(@PathVariable("id") int id,Model model)
   {
	   Product product=productRepository.findById(id).get();
	   model.addAttribute("product",product);
	   List<Category> listCategories=categoryRepository.findAll();
	   model.addAttribute("listCategories",listCategories);
	   return "product";
   }
   @GetMapping("/products/delete/{id}")
   public String deleteProduct(@PathVariable("id") int id,Model model)
   {
	   productRepository.deleteById(id);
	   return "redirect:/products";
   }
}
