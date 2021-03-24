package com.cg.onlineshopping.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.onlineshopping.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	/*public Customer addCustomer(Customer cust);
	public Customer updateCustomer(Customer cust);
	public Customer removeCustomer(Customer cust);
	public Customer viewCustomer(Customer cust);
	public List<Customer> ViewAllCustomers(String location);*/
	
	@Query("select c from Customer c where c.address=:address")
	public List<Customer> viewAllCustomer(@Param("address")String address);

}
