package com.cg.onlineshopping.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.onlineshopping.entities.Order;


public interface OrderService {
	public Order addOrder(Order order);
	
	public Order updateOrder(Order order);
	
	public Order removeOrder(int orderId);
	
	public Order viewOrder(Order order);
	
	public List<Order> viewAllOrders(LocalDate date);
	
	public List<Order> viewAllOrdersByLocation(String location);
	
	public Order viewAllOrderById(int id);

}
