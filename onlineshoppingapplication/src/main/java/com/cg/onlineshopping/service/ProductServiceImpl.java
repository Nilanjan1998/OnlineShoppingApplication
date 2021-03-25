package com.cg.onlineshopping.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineshopping.entities.Category;
import com.cg.onlineshopping.entities.Product;
import com.cg.onlineshopping.exception.ProductNotFoundException;
import com.cg.onlineshopping.repository.CategoryRepository;
import com.cg.onlineshopping.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepo;
	@Autowired
	CategoryRepository categoryRepo;
	
	Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
	@Override
	public List<Product> viewAllProducts() {
		//System.out.println(productRepo.findAll().size());
		logger.info("Product viewAllProduct()");
		List<Product> products = productRepo.findAll();
		if(products.isEmpty())
			throw new ProductNotFoundException("ProductNotFound");
		else
			return products;
	}
	

	@Override
	public Product addProduct(Product product) {
		logger.info("Product addProduct()");
		if(product == null)
			throw new ProductNotFoundException("ProductNotFound");
		else {
			productRepo.save(product);
			return  product;
		}
	}

	@Override
	public Product updateProduct(Product product) {
		logger.info("Product updateProduct()");
		if(product == null)
			throw new ProductNotFoundException("ProductNotFound");
		else {
			productRepo.save(product);
			return  product;
		}
	}

	@Override
	public Product viewProduct(int id) {
		logger.info("Product viewProductById()");
		Optional<Product> pro = productRepo.findById(id);
		if(!pro.isPresent())
			throw new ProductNotFoundException("ProductNotFound");
		else
			return pro.get();
			
	}

	@Override
	public List<Product> viewProductsByCategory(int catId) {
		logger.info("Product viewProductByCategory()");
        List<Product> list= productRepo.viewAllProductsByCategory(catId);	
        if(list.isEmpty())
        	throw new ProductNotFoundException("ProductNotFound");
		else
			return list;
		
	}

	@Override
	public Product removeProduct(int productId) {
		logger.info("Product removeProduct()");
		Optional<Product> product = productRepo.findById(productId);
		if(!product.isPresent())
			throw new ProductNotFoundException("ProductNotFound");
		else {
			productRepo.deleteById(productId);
			return product.get();
		}
	}

}
