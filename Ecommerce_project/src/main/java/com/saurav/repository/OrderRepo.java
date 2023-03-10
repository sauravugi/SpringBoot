package com.saurav.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.saurav.exceptions.OrderException;
import com.saurav.models.Orders;

public interface OrderRepo extends JpaRepository<Orders, Integer> {
	
	@Query(value = "Select * from order where DAY(orderdate)= :date", nativeQuery = true)
	List<Orders> getDateWiseOrders(int date) throws OrderException;
	
	@Query(value = "Select * from order where MONTH(orderdate)= :date", nativeQuery = true)
	List<Orders> getMonthWiseOrders(int date) throws OrderException;

}
