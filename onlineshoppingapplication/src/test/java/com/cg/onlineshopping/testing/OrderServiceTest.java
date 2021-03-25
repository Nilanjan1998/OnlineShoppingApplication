package com.cg.onlineshopping.testing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;

import java.time.LocalDate;
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
import com.cg.onlineshopping.entities.Order;
import com.cg.onlineshopping.repository.OrderRepository;

import com.cg.onlineshopping.service.OrderService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTest {
	
	@Autowired
	OrderService orderService;

	@MockBean
	OrderRepository orderRepo;
	
	@Test
	public void testAddOrder()
	{
		Order order = new Order();
		order.setOrderDate(LocalDate.of(2020, 1, 8));
		order.setOrderStatus("Pending");
		Customer cust = new Customer();
		cust.setCustomerId(1006);
		Address add = new Address();
		add.setAddressId(4002);
		order.setCustomerOrder(cust);
		order.setAddressOrder(add);
		Mockito.when(orderRepo.save(order)).thenReturn(order);
		assertThat(orderService.addOrder(order)).isEqualTo(order);
	}
	
	@Test
	public void testUpdateOrder()
	{
		Order order = new Order();
		order.setOrderDate(LocalDate.of(2020, 1, 8));
		order.setOrderStatus("Pending");
		Customer cust = new Customer();
		cust.setCustomerId(1006);
		Address add = new Address();
		add.setAddressId(4002);
		order.setCustomerOrder(cust);
		order.setAddressOrder(add);
		Mockito.when(orderRepo.save(order)).thenReturn(order);
		assertThat(orderService.addOrder(order)).isEqualTo(order);
		Mockito.when(orderRepo.findById(order.getOrderId())).thenReturn(Optional.of(order));
		order.setOrderStatus("Delivered");
		Mockito.when(orderRepo.save(order)).thenReturn(order);
		assertThat(orderService.updateOrder(order)).isEqualTo(order);
	}
	
	@Test 
	public void testRemoveOrder()
	{
		Order order = new Order();
		order.setOrderDate(LocalDate.of(2020, 1, 8));
		order.setOrderStatus("Pending");
		Customer cust = new Customer();
		cust.setCustomerId(1006);
		Address add = new Address();
		add.setAddressId(4002);
		order.setCustomerOrder(cust);
		order.setAddressOrder(add);
		Mockito.when(orderRepo.findById(order.getOrderId())).thenReturn(Optional.of(order));
	    Mockito.when(orderRepo.existsById(order.getOrderId())).thenReturn(false);
	    assertFalse(orderRepo.existsById(order.getOrderId()));
	}
	
	@Test
	public void testOrderByDate()
	{
		Order order1 = new Order();
		order1.setOrderDate(LocalDate.of(2020, 1, 8));
		order1.setOrderStatus("Pending");
		Customer cust1 = new Customer();
		cust1.setCustomerId(1006);
		Address add1 = new Address();
		add1.setAddressId(4002);
		order1.setCustomerOrder(cust1);
		order1.setAddressOrder(add1);
		
		Order order2 = new Order();
		order2.setOrderDate(LocalDate.of(2020, 1, 8));
		order2.setOrderStatus("Pending");
		Customer cust2 = new Customer();
		cust2.setCustomerId(1006);
		Address add2 = new Address();
		add2.setAddressId(4002);
		order2.setCustomerOrder(cust2);
		order2.setAddressOrder(add2);
		List<Order> orderList = new ArrayList<>();
		orderList.add(order1); orderList.add(order2);
		Mockito.when(orderRepo.viewAllOrderByDate(orderList.get(0).getOrderDate())).thenReturn(orderList);
		assertThat(orderService.viewAllOrders(orderList.get(0).getOrderDate())).isEqualTo(orderList);
	}
	@Test
	public void testOrderById()
	{
		Order order = new Order();
		order.setOrderDate(LocalDate.of(2020, 1, 8));
		order.setOrderStatus("Pending");
		Customer cust = new Customer();
		cust.setCustomerId(1006);
		Address add = new Address();
		add.setAddressId(4002);
		order.setCustomerOrder(cust);
		order.setAddressOrder(add);
		Mockito.when(orderRepo.findById(order.getOrderId())).thenReturn(Optional.of(order));
		assertThat(orderService.viewAllOrderById(order.getOrderId())).isEqualTo(order);
	}
	
	@Test
	public void testOrderByLocation()
	{
		Order order1 = new Order();
		order1.setOrderDate(LocalDate.of(2020, 1, 8));
		order1.setOrderStatus("Pending");
		Customer cust1 = new Customer();
		cust1.setCustomerId(1006);
		cust1.setAddress("Kolkata");
		Address add1 = new Address();
		add1.setAddressId(4002);
		order1.setCustomerOrder(cust1);
		order1.setAddressOrder(add1);
		
		Order order2 = new Order();
		order2.setOrderDate(LocalDate.of(2020, 1, 8));
		order2.setOrderStatus("Pending");
		Customer cust2 = new Customer();
		cust2.setCustomerId(1006);
		cust2.setAddress("Mumbai");
		Address add2 = new Address();
		add2.setAddressId(4002);
		order2.setCustomerOrder(cust2);
		order2.setAddressOrder(add2);
		List<Order> orderList = new ArrayList<>();
		orderList.add(order1); orderList.add(order2);
		
		Mockito.when(orderRepo.viewAllCustomersByLocation(orderList.get(0).getCustomerOrder().getAddress())).thenReturn(orderList);
		assertThat(orderService.viewAllOrdersByLocation(orderList.get(0).getCustomerOrder().getAddress())).isEqualTo(orderList);
	}
}
