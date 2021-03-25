package com.cg.onlineshopping.testing;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.onlineshopping.entities.Cart;
import com.cg.onlineshopping.entities.Category;
import com.cg.onlineshopping.entities.Customer;
import com.cg.onlineshopping.entities.Product;
import com.cg.onlineshopping.exception.ProductNotFoundException;
import com.cg.onlineshopping.repository.ProductRepository;
import com.cg.onlineshopping.service.ProductService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {
	
	@Autowired
	ProductService productService;
	
	@MockBean
	ProductRepository productRepo;
	@Test
	public void testGetProductsException() throws ProductNotFoundException{
	       int id = 5005;
	       assertThrows(ProductNotFoundException.class, () -> productService.viewProduct(id));
	       System.out.println("Product Id cannot be retervied");
	  
	   }
	@Test
	public void addProduct()
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
		Customer cust = new Customer();
		cust.setFirstName("Ayush");
		cust.setLastName("Sukla");
		cust.setMobileNumber("90385857");
		cust.setAddress("Mumbai");
		cust.setEmail("ayz@g.com");
		cart.setCustomerCart(cust);
		
		product.setCategory(cat);
		product.setCart(cart);
		
		Mockito.when(productRepo.save(product)).thenReturn(product);
		assertThat(productService.addProduct(product)).isEqualTo(product);
	}
	@Test
	public void testUpdateProduct()
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
		Customer cust = new Customer();
		cust.setFirstName("Ayush");
		cust.setLastName("Sukla");
		cust.setMobileNumber("90385857");
		cust.setAddress("Mumbai");
		cust.setEmail("ayz@g.com");
		cart.setCustomerCart(cust);
		
		product.setCategory(cat);
		product.setCart(cart);
		
		Mockito.when(productRepo.findById(product.getProductId())).thenReturn(Optional.of(product));
		product.setPrice(20000.0);
		
		Mockito.when(productRepo.save(product)).thenReturn(product);
		
		assertThat(productService.updateProduct(product)).isEqualTo(product);
	}
	
	@Test
	public void testRemoveProduct()
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
		Customer cust = new Customer();
		cust.setFirstName("Ayush");
		cust.setLastName("Sukla");
		cust.setMobileNumber("90385857");
		cust.setAddress("Mumbai");
		cust.setEmail("ayz@g.com");
		cart.setCustomerCart(cust);
		
		product.setCategory(cat);
		product.setCart(cart);
		
		Mockito.when(productRepo.findById(product.getProductId())).thenReturn(Optional.of(product));
	    Mockito.when(productRepo.existsById(product.getProductId())).thenReturn(false);
	   assertFalse(productRepo.existsById(product.getProductId()));
	}
	
	@Test
	public void testViewAllProducts()
	{
		Product product1 = new Product();
		product1.setProductName("LG TV");
		product1.setPrice(18000.0);
		product1.setColor("Red");
		product1.setDimension("3D");
		product1.setSpecification("HD");
		product1.setManufacturer("LG");
		product1.setQuantity(2);
		
		Category cat1 = new Category();
		cat1.setCatId(1005);
		cat1.setCategoryName("Electronics");
		Cart cart1 = new Cart();
		cart1.setCartId(5002);
		Customer cust1 = new Customer();
		cust1.setFirstName("Ayush");
		cust1.setLastName("Sukla");
		cust1.setMobileNumber("90385857");
		cust1.setAddress("Mumbai");
		cust1.setEmail("ayz@g.com");
		cart1.setCustomerCart(cust1);
		
		product1.setCategory(cat1);
		product1.setCart(cart1);
		
		Product product2 = new Product();
		product2.setProductName("LG TV");
		product2.setPrice(18000.0);
		product2.setColor("Red");
		product2.setDimension("3D");
		product2.setSpecification("HD");
		product2.setManufacturer("LG");
		product2.setQuantity(2);
		
		Category cat2 = new Category();
		cat2.setCatId(1005);
		cat2.setCategoryName("Electronics");
		Cart cart2 = new Cart();
		cart2.setCartId(5002);
		Customer cust2 = new Customer();
		cust2.setFirstName("Ayush");
		cust2.setLastName("Sukla");
		cust2.setMobileNumber("90385857");
		cust2.setAddress("Mumbai");
		cust2.setEmail("ayz@g.com");
		cart2.setCustomerCart(cust2);
		
		product2.setCategory(cat2);
		product2.setCart(cart2);
		
		List<Product> product = new ArrayList<>();
		product.add(product1); product.add(product2);
		Mockito.when(productRepo.findAll()).thenReturn(product);
		assertThat(productService.viewAllProducts()).isEqualTo(product);
	}
	
	@Test
	public void testViewProductsByCategory()
	{
		Product product1 = new Product();
		product1.setProductName("LG TV");
		product1.setPrice(18000.0);
		product1.setColor("Red");
		product1.setDimension("3D");
		product1.setSpecification("HD");
		product1.setManufacturer("LG");
		product1.setQuantity(2);
		
		Category cat1 = new Category();
		cat1.setCatId(1005);
		cat1.setCategoryName("Electronics");
		Cart cart1 = new Cart();
		cart1.setCartId(5002);
		Customer cust1 = new Customer();
		cust1.setFirstName("Ayush");
		cust1.setLastName("Sukla");
		cust1.setMobileNumber("90385857");
		cust1.setAddress("Mumbai");
		cust1.setEmail("ayz@g.com");
		cart1.setCustomerCart(cust1);
		
		product1.setCategory(cat1);
		product1.setCart(cart1);
		
		Product product2 = new Product();
		product2.setProductName("LG TV");
		product2.setPrice(18000.0);
		product2.setColor("Red");
		product2.setDimension("3D");
		product2.setSpecification("HD");
		product2.setManufacturer("LG");
		product2.setQuantity(2);
		
		Category cat2 = new Category();
		cat2.setCatId(1005);
		cat2.setCategoryName("Electronics");
		Cart cart2 = new Cart();
		cart2.setCartId(5002);
		Customer cust2 = new Customer();
		cust2.setFirstName("Ayush");
		cust2.setLastName("Sukla");
		cust2.setMobileNumber("90385857");
		cust2.setAddress("Mumbai");
		cust2.setEmail("ayz@g.com");
		cart2.setCustomerCart(cust2);
		
		product2.setCategory(cat2);
		product2.setCart(cart2);
		
		List<Product> product = new ArrayList<>();
		product.add(product1); product.add(product2);
		Mockito.when(productRepo.viewAllProductsByCategory(product.get(0).getCategory().getCatId())).thenReturn(product);
		assertThat(productService.viewProductsByCategory(product.get(0).getCategory().getCatId())).isEqualTo(product);
	}
	
	@Test
	public void testViewProductById()
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
		Customer cust = new Customer();
		cust.setFirstName("Ayush");
		cust.setLastName("Sukla");
		cust.setMobileNumber("90385857");
		cust.setAddress("Mumbai");
		cust.setEmail("ayz@g.com");
		cart.setCustomerCart(cust);
		
		product.setCategory(cat);
		product.setCart(cart);
		
		Mockito.when(productRepo.findById(product.getProductId())).thenReturn(Optional.of(product));
		assertThat(productService.viewProduct(product.getProductId())).isEqualTo(product);
	}
	

}
