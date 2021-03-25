package com.cg.onlineshopping.entities;

import java.util.Set;
import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cart_details")
public class Cart {

	@Id
	@Column(name = "cart_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cart_seq")
	@SequenceGenerator(name = "cart_seq", sequenceName = "cart_seq", allocationSize = 1)
	private int cartId;

	// private Map<Product, Integer>products; // product and quantity

	// Mapping
	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "cart")
	Set<Product> product = new HashSet<>();

	@OneToOne
	@JoinColumn(name = "customer_id")
	private Customer customerCart;

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(int cartId, Set<Product> product, Customer customerCart) {
		super();
		this.cartId = cartId;

		this.product = product;
		this.customerCart = customerCart;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public Set<Product> getProduct() {
		return product;
	}

	public void setProduct(Set<Product> product) {
		this.product = product;
	}

	public Customer getCustomerCart() {
		return customerCart;
	}

	public void setCustomerCart(Customer cat) {
		this.customerCart = cat;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", product=" + product + ", customerCart=" + customerCart + "]";
	}

}
