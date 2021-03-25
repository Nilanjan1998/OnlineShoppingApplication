package com.cg.onlineshopping.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "customer_details")
public class Customer {

	@Id
	@Column(name = "customer_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
	@SequenceGenerator(name = "customer_seq", sequenceName = "customer_seq", allocationSize = 1)
	
	private int customerId;

	@Column(name = "first_name")
	@NotNull(message="First Name can not be null")
	private String firstName;

	@Column(name = "last_name")
	@NotNull(message="Last Name can not be null")
	private String lastName;

	@Column(name = "mobile_number")
	@Size(min = 10, message="Mobile no should be in 10 digits")
	private String mobileNumber;

	@Column(name = "email")
	@Email(message="Email should be valid")
	private String email;
	
	@Column(name = "address")
	@NotEmpty(message="Address can not be Empty")
	private String address;

	// Mapping
	@JsonIgnore
	@OneToOne(mappedBy = "customerAdd")
	private Address addressCust;

	@JsonIgnore
	@OneToOne(mappedBy = "customerUser")
	private User user;

	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "customerOrder")
	private Set<Order> products = new HashSet<Order>();

	@JsonIgnore
	@OneToOne(mappedBy = "customerCart")
	private Cart cart;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(int customerId, String firstName, String lastName, String mobileNumber, String email,
			String address, Address addressCust, User user, Set<Order> products, Cart cart) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.address = address;
		this.addressCust = addressCust;
		this.user = user;
		this.products = products;
		this.cart = cart;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Address getAddressCust() {
		return addressCust;
	}

	public void setAddressCust(Address addressCust) {
		this.addressCust = addressCust;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Order> getProducts() {
		return products;
	}

	public void setProducts(Set<Order> products) {
		this.products = products;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", mobileNumber=" + mobileNumber + ", email=" + email + ", address=" + address + ", addressCust="
				+ addressCust + "]";
	}

}
