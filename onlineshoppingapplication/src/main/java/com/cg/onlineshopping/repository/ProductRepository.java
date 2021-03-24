package com.cg.onlineshopping.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.onlineshopping.entities.Address;
import com.cg.onlineshopping.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	/*public List<Product> viewAllProducts();
	 public Product addProduct(Product product);
	 public Product updateProduct(Product product);
	 public Product viewProduct(int id);
	 public List<Product> viewProductsByCategory(String cat); 
	 public Product removeProduct(String prodid);*/
	
	@Query("select p from Product p where p.cart.cartId=:catId")
	public List<Product> viewAllProductsByCart(@Param("catId")int catId);
	
	@Query("select p from Product p where p.category.catId=:catId")
	public List<Product> viewAllProductsByCategory(@Param("catId")int catId);
	
}
