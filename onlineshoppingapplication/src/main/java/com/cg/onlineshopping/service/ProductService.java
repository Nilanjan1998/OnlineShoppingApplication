package com.cg.onlineshopping.service;

import java.util.List;
import java.util.Optional;

import com.cg.onlineshopping.entities.Product;

public interface ProductService {
	public List<Product> viewAllProducts();

	public Product addProduct(Product product);

	public Product updateProduct(Product product);

	public Product viewProduct(int id);

	public List<Product> viewProductsByCategory(int catId);

	public Product removeProduct(int productId);
}
