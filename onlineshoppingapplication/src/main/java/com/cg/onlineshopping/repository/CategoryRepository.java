package com.cg.onlineshopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.onlineshopping.entities.Category;
import com.cg.onlineshopping.entities.User;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
