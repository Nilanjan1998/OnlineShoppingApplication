package com.cg.onlineshopping.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.cg.onlineshopping.entities.Address;

@Service
public interface AddressService {

	public Address addAddress(Address add);
	public Address updateAddress(Address add);
	public Address removeAddress(int addId);
	public List<Address> viewAllAddress();
	public Address viewAddress(int addId);
	
}
