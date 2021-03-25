package com.cg.onlineshopping.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineshopping.entities.Category;
import com.cg.onlineshopping.repository.CategoryRepository;

@RestController
@RequestMapping("/onlineshopping/api")
public class CategoryRestController {

	@Autowired
	CategoryRepository catRepo;
	
	@PostMapping("/category")
	public Category addCategory(@Valid@RequestBody Category cat)
	{
		catRepo.save(cat);
		return cat;
	}
	
	@GetMapping("/category")
	public List<Category> findAllCategory()
	{
		return catRepo.findAll();
	}
	
	@PutMapping("/category")
	public Category updateCategory(@Valid@RequestBody Category cat)
	{
		catRepo.save(cat);
		return cat;
	}
	
	@DeleteMapping("/category/{catId}")
	public Category deleteCategory(@PathVariable("catId") int catId)
	{
		Category cat = catRepo.findById(catId).get();
		catRepo.deleteById(catId);
		return cat;
	}
	
}
