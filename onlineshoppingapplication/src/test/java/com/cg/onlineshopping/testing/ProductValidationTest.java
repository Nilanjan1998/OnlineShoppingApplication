package com.cg.onlineshopping.testing;


import static org.junit.Assert.assertTrue;


import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.Test;

import com.cg.onlineshopping.entities.Cart;
import com.cg.onlineshopping.entities.Category;
import com.cg.onlineshopping.entities.Customer;
import com.cg.onlineshopping.entities.Product;

public class ProductValidationTest {

	private Validator validator;
	@Before
	public void setUp()
	{
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}
	
	@Test
	public void addProductTest()
	{
		Product product = new Product();
		product.setProductName("LG TV");
		product.setPrice(18000.0);
		product.setColor("Red");
		product.setDimension("3D");
		product.setSpecification("HD");
		product.setManufacturer("LG");
		product.setQuantity(2);
		
		Category cat = new Category();
		cat.setCatId(1005);
		cat.setCategoryName("Electronics");
		Cart cart = new Cart();
		cart.setCartId(5002);
		
		product.setCategory(cat);
		product.setCart(cart);
		
		Set<ConstraintViolation<Product>> vio = validator.validate(product);
		assertTrue(vio.isEmpty());
	}
}
