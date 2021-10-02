package com.onetomany.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.onetomany.entity.Brand;
import com.onetomany.entity.Category;
import com.onetomany.repository.BrandRepository;
import com.onetomany.repository.CategoryRepository;

@Controller
public class BrandController {
   @Autowired
   private BrandRepository brandRepository;
   @Autowired
   private CategoryRepository categoryRepository;
   @GetMapping("/brand/new")
   public String showCreateBrand(Model model)
   {
	   List<Category> listCategories=categoryRepository.findAll();
	   model.addAttribute("brand",new Brand());
	   model.addAttribute("listCategories",listCategories);
	   return "brand";
   }
   @PostMapping("/brand/save")
   public String saveBrand(Brand brand)
   {
	   brandRepository.save(brand);
	   return "redirect:/brands";
   }
   @GetMapping("/brands")
   public String listBrand(Model model)
   {
	   List<Brand> listBrands=brandRepository.findAll();
	   model.addAttribute("listBrands",listBrands);
	   return "brands";
   }
   @GetMapping("/brand/edit/{id}")
   public String showEditBrand(@PathVariable("id") int id,Model model)
   {
	   List<Category> listCategories=categoryRepository.findAll();
	   model.addAttribute("listCategories",listCategories);
	   Brand brand=brandRepository.findById(id).get();
	   model.addAttribute("brand",brand);
	   return "brand";
   }
}
