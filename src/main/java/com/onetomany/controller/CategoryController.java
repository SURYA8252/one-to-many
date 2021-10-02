package com.onetomany.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.onetomany.entity.Category;
import com.onetomany.repository.CategoryRepository;

@Controller
public class CategoryController {
   @Autowired
   private CategoryRepository categoryRepository;
   @GetMapping("/categories")
   public String listCategories(Model model)
   {
	   List<Category> listCategories=categoryRepository.findAll();
	   model.addAttribute("listCategories",listCategories);
	   return "categories";
   }
   @GetMapping("/categories/new")
   public String showCategories(Model model)
   {
	   model.addAttribute("category",new Category());
	   return "category";
   }
   @PostMapping("/categories/save")
   public String saveCategory(Category category)
   {
	   categoryRepository.save(category);
	   return "redirect:/categories";
   }
}
