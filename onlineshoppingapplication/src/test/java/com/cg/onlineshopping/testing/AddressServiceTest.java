package com.cg.onlineshopping.testing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;

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

import com.cg.onlineshopping.entities.Address;
import com.cg.onlineshopping.entities.Customer;
import com.cg.onlineshopping.repository.AddressRepository;
import com.cg.onlineshopping.service.AddressService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressServiceTest {
	
	@Autowired
	AddressService addressService;
	
	@MockBean
	AddressRepository addressRepo;
	
	@Test
	public void testAddAddress()
	{
		Address add = new Address();
		add.setStreetNo("AuroBindo Street");
		add.setBuildingName("XYZ Building");
		add.setCity("Madhyamgram");
		add.setState("WB");
		add.setCountry("INDIA");
		add.setPincode("700130");
		Customer cust = new Customer();
		cust.setCustomerId(1006);
		add.setCustomerAdd(cust);
		Mockito.when(addressRepo.save(add)).thenReturn(add);
		assertThat(addressService.addAddress(add)).isEqualTo(add);
	}
	@Test
	public void testUpdateAddress()
	{
		Address add = new Address();
		add.setStreetNo("AuroBindo Street");
		add.setBuildingName("XYZ Building");
		add.setCity("Madhyamgram");
		add.setState("WB");
		add.setCountry("INDIA");
		add.setPincode("700130");
		Customer cust = new Customer();
		cust.setCustomerId(1006);
		add.setCustomerAdd(cust);
		
		Mockito.when(addressRepo.findById(add.getAddressId())).thenReturn(Optional.of(add));
		
		add.setCity("Kolkata");
		Mockito.when(addressRepo.save(add)).thenReturn(add);
		
		assertThat(addressService.updateAddress(add)).isEqualTo(add);
	}
	
	@Test
	public void testRemoveAddress()
	{
		Address add = new Address();
		add.setStreetNo("AuroBindo Street");
		add.setBuildingName("XYZ Building");
		add.setCity("Madhyamgram");
		add.setState("WB");
		add.setCountry("INDIA");
		add.setPincode("700130");
		Customer cust = new Customer();
		cust.setCustomerId(1006);
		add.setCustomerAdd(cust);
		
		Mockito.when(addressRepo.findById(add.getAddressId())).thenReturn(Optional.of(add));
	    Mockito.when(addressRepo.existsById(add.getAddressId())).thenReturn(false);
	   assertFalse(addressRepo.existsById(add.getAddressId()));
	}
	
	@Test
	public void viewAddressById()
	{
		Address add = new Address();
		add.setStreetNo("AuroBindo Street");
		add.setBuildingName("XYZ Building");
		add.setCity("Madhyamgram");
		add.setState("WB");
		add.setCountry("INDIA");
		add.setPincode("700130");
		Customer cust = new Customer();
		cust.setCustomerId(1006);
		add.setCustomerAdd(cust);
		Mockito.when(addressRepo.findById(add.getAddressId())).thenReturn(Optional.of(add));
		assertThat(addressService.viewAddress(add.getAddressId())).isEqualTo(add);
	}
	
	@Test
	public void viewAllAddress()
	{
		Address add1 = new Address();
		add1.setStreetNo("AuroBindo Street");
		add1.setBuildingName("XYZ Building");
		add1.setCity("Madhyamgram");
		add1.setState("WB");
		add1.setCountry("INDIA");
		add1.setPincode("700130");
		Customer cust1 = new Customer();
		cust1.setCustomerId(1006);
		add1.setCustomerAdd(cust1);
		
		Address add2 = new Address();
		add2.setStreetNo("AuroBindo Street");
		add2.setBuildingName("XYZ Building");
		add2.setCity("Madhyamgram");
		add2.setState("WB");
		add2.setCountry("INDIA");
		add2.setPincode("700130");
		Customer cust2 = new Customer();
		cust2.setCustomerId(1006);
		add2.setCustomerAdd(cust2);
		
		List<Address> addList = new ArrayList<>();
		addList.add(add1); addList.add(add2);
		
		Mockito.when(addressRepo.findAll()).thenReturn(addList);
		
		assertThat(addressService.viewAllAddress()).isEqualTo(addList);
	}
	

}
