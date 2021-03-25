package com.cg.onlineshopping.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineshopping.entities.Address;
import com.cg.onlineshopping.service.AddressService;
import com.cg.onlineshopping.service.AddressServiceImpl;

@RestController
@RequestMapping("/onlineshopping/api")
public class AddressRestController {
	
	@Autowired
	AddressService addService;
	
	Logger logger = LoggerFactory.getLogger(AddressRestController.class);
	
	@PostMapping("/address")
	public Address addAddress(@Valid@RequestBody Address add)
	{
		logger.info("Address addAddress()");
		return addService.addAddress(add);
	}
	
	/*@GetMapping("/address/{addId}")
	public List<Address> viewAllAddress(@PathVariable("addId")int addId)
	{
		logger.info("Address viewAllAddress()");
		return addService.viewAllAddress(addId);
	}*/
	
	@GetMapping("/address/{addId}")
	public Address viewAddress(@PathVariable("addId")int addId)
	{
		logger.info("Address viewAddress()");
		return addService.viewAddress(addId);
	}
	@PutMapping("/address")
	public Address updateAddress(@Valid@RequestBody Address add)
	{
		logger.info("Address updateAddress()");
		return addService.updateAddress(add);
	}
	
	@DeleteMapping("/address/{addId}")
	public Address removeCustomer(@PathVariable("addId")int addId)
	{
		logger.info("Address removeAddress()");
		return addService.removeAddress(addId);
	}
	
	
}
