package com.cg.onlineshopping.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineshopping.entities.Cart;
import com.cg.onlineshopping.entities.Product;
import com.cg.onlineshopping.exception.CartNotFoundException;
import com.cg.onlineshopping.repository.CartRepository;
import com.cg.onlineshopping.repository.ProductRepository;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	CartRepository cartRepo;
	@Autowired 
	ProductRepository productRepo;
	@Override
	/*public Cart addProductToCart(Cart cart, Product p, int quantity) {
		p.setQuantity(quantity);
		productRepo.save(p);
		cartRepo.save(cart);
		return cart;
	}*/
	public Cart addCart(Cart cart)
	{
		
		if(cart == null)
			throw new CartNotFoundException("Cart Not Found");
		else {
			cartRepo.save(cart);
			return cart;
		}
	}
	@Override
	public Cart removeCart(int cartId)
	{
		Cart cart = cartRepo.findById(cartId).get();
		if(cart == null)
			throw new CartNotFoundException("Cart Not Found");
		else {
			cartRepo.delete(cart);
			return cart;
		}
	}
	
	@Override
	public Cart viewCustomer(int customerId)
	{
		Cart cart =cartRepo.viewCartByCustomerId(customerId);
		if(cart==null)
			throw new CartNotFoundException("Cart Not Found");
		else
			return cart;
	}

	/*@Override
	public Cart removeProductFromCart(Cart cart, Product p) {
		int id = p.getProductId();
		cartRepo.deleteById(id);
		return cart;
	}

	@Override
	public Cart updateProductQuantity(Cart cart, Product p, int quantity) {
		p.setQuantity(quantity);
		productRepo.save(p);
		cartRepo.save(cart);
		return cart;
	}

	/*@Override
	public Cart removeAllProducts(Cart cart) {
		return null;
	}

	@Override
	public List<Product> viewAllProducts(Cart cart) {
		List<Product> list = new ArrayList<>(cart.getProduct());
		if(list.isEmpty())
			throw new CartNotFoundException("Cart Not Found");
		else
			return list;
		
	}*/

}
