package com.cg.onlineshopping.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.onlineshopping.entities.Cart;
import com.cg.onlineshopping.entities.Product;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>{
	/*public Cart addProductToCart(Cart cart, Product p,int quantity);
	public Cart removeProductFromCart(Cart cart,Product p);
	public Cart updateProductQuantity(Cart cart, Product p,int quantity);
	public Cart removeAllProducts(Cart cart);
	public List<Product> viewAllProducts(Cart cart);*/
	@Query("select c from Cart c where c.customerCart.customerId=:customerId")
	public Cart viewCartByCustomerId(@Param("customerId")int customerId);
}
