package com.cg.onlineshopping.testing;


import static org.junit.Assert.assertTrue;


import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.Test;

import com.cg.onlineshopping.entities.Customer;

public class CustomerValidationTest {

	private Validator validator;
	@Before
	public void setUp()
	{
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}
	
	@Test
	public void addCustomerTest()
	{
		Customer cust = new Customer();
		cust.setFirstName("Ayush");
		cust.setLastName("Sukla");
		cust.setMobileNumber("9038585752");
		cust.setAddress("Mumbai");
		cust.setEmail("ayz@g.com");
		
		Set<ConstraintViolation<Customer>> vio = validator.validate(cust);
		assertTrue(vio.isEmpty());
	}
}
