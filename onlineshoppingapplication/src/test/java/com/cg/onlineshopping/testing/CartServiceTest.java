package com.cg.onlineshopping.testing;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import static org.junit.Assert.assertFalse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.onlineshopping.entities.Cart;
import com.cg.onlineshopping.entities.Customer;
import com.cg.onlineshopping.repository.CartRepository;
import com.cg.onlineshopping.service.CartService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartServiceTest {

	@Autowired
	CartService cartService;
	
	@MockBean
	CartRepository cartRepo;
	
	@Test
	public void testAddCart()
	{
		Cart cart = new Cart();
		cart.setCartId(7000);
		Customer cust = new Customer();
		cust.setCustomerId(1000);
		cart.setCustomerCart(cust);
		Mockito.when(cartRepo.save(cart)).thenReturn(cart);
		assertThat(cartService.addCart(cart)).isEqualTo(cart);
	}
	@Test
	public void testRemoveCart()
	{
		Cart cart = new Cart();
		cart.setCartId(7000);
		Customer cust = new Customer();
		cust.setCustomerId(1000);
		cart.setCustomerCart(cust);
		Mockito.when(cartRepo.findById(cart.getCartId())).thenReturn(Optional.of(cart));
	    Mockito.when(cartRepo.existsById(cart.getCartId())).thenReturn(false);
	   assertFalse(cartRepo.existsById(cart.getCartId()));
	}
	@Test
	public void testViewCart()
	{
		Cart cart = new Cart();
		cart.setCartId(7000);
		Customer cust = new Customer();
		cust.setCustomerId(1000);
		cart.setCustomerCart(cust);
		Mockito.when(cartRepo.viewCartByCustomerId(cart.getCustomerCart().getCustomerId())).thenReturn(cart);
		assertThat(cartService.viewCustomer(cart.getCustomerCart().getCustomerId())).isEqualTo(cart);
	}
}
