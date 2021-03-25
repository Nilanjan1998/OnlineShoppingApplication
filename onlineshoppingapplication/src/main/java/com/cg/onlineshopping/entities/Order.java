package com.cg.onlineshopping.entities;

import java.time.LocalDate;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "order_details")
public class Order {

	@Id
	@Column(name = "order_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq")
	@SequenceGenerator(name = "order_seq", sequenceName = "order_seq", allocationSize = 1)
	private int orderId;
	@Column(name = "order_status")
	@NotNull(message="Order status should not null")
	private String orderStatus;
	@Column(name = "order_date")
	//@NotEmpty(message="Order Date should not empty")
	private LocalDate orderDate;

	// Mapping
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "product_order", joinColumns = { @JoinColumn(name = "order_id") }, inverseJoinColumns = {
			@JoinColumn(name = "product_id") })
	Set<Product> products = new TreeSet<>();

	@ManyToOne
	@JoinColumn(name = "address_id")
	private Address addressOrder;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customerOrder;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(int orderId, String orderStatus, LocalDate orderDate, Set<Product> products, Address addressOrder,
			Customer customerOrder) {
		super();
		this.orderId = orderId;
		this.orderStatus = orderStatus;
		this.orderDate = orderDate;
		this.products = products;
		this.addressOrder = addressOrder;
		this.customerOrder = customerOrder;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public Address getAddressOrder() {
		return addressOrder;
	}

	public void setAddressOrder(Address addressOrder) {
		this.addressOrder = addressOrder;
	}

	public Customer getCustomerOrder() {
		return customerOrder;
	}

	public void setCustomerOrder(Customer customerOrder) {
		this.customerOrder = customerOrder;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderStatus=" + orderStatus + ", orderDate=" + orderDate + ", products="
				+ products + ", addressOrder=" + addressOrder + ", customerOrder=" + customerOrder + "]";
	}

	

}
