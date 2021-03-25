package com.cg.onlineshopping.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.onlineshopping.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{

	/*public Order addOrder(Order order);
	public Order updateOrder(Order order);
	public Order removeOrder(Order order);
	public Order viewOrder(Order order);
	public List<Order> viewAllOrders(LocalDate date);
	public List<Order> viewAllOrdersByLocation(String location);
	public List<Order> viewAllOrderByUserId(String userid);*/
	
	@Query("select o from Order o where o.orderDate=:orderDate")
    public List<Order> viewAllOrderByDate(@Param("orderDate")LocalDate localdate);
	
	  @Query("select o from Order o where o.customerOrder.address=:address")
	   public List<Order> viewAllCustomersByLocation(@Param("address")String address);
}
