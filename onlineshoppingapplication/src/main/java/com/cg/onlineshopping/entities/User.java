package com.cg.onlineshopping.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user_details")
public class User {

	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
	@SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1)
	private int userId;

	@Column(name = "password")
	@Size(min=4, max=10,message="Password size should be minimum 4 and maximum 10")
	private String password;

	@Column(name = "role")
	@NotEmpty(message="Role should not be Empty")
	private String role;

	// Mapping
	@OneToOne
	@JoinColumn(name = "customer_id")
	private Customer customerUser;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int userId, String password, String role, Customer customerUser) {
		super();
		this.userId = userId;
		this.password = password;
		this.role = role;
		this.customerUser = customerUser;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Customer getCustomerUser() {
		return customerUser;
	}

	public void setCustomerUser(Customer customerUser) {
		this.customerUser = customerUser;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", role=" + role + ", customerUser=" + customerUser
				+ "]";
	}

}
