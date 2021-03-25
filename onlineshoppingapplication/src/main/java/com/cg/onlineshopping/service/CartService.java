package com.cg.onlineshopping.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.onlineshopping.entities.Cart;
import com.cg.onlineshopping.entities.Product;

@Service
public interface CartService {

	/*public Cart addProductToCart(Cart cart, Product p,int quantity);*/
	public Cart addCart(Cart cart);
	//public Cart removeProductFromCart(Cart cart,Product p);
	//public Cart updateProductQuantity(Cart cart, Product p,int quantity);
	//public Cart removeAllProducts(Cart cart);
	public Cart removeCart(int cartId);
	//public List<Product> viewAllProducts(Cart cart);
	public Cart viewCustomer(int customerId);

}
