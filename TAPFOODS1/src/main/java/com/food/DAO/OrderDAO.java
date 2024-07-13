package com.food.DAO;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.food.model.Order;

public interface OrderDAO {
	
	 void addOrder(Order Order,HttpSession ressession, int user_id, HttpSession session) ;
	Order getOrder(int Order_id);
	void updateOrder(Order Order);
	void deleteOrder(int Order);
	List<Order> getAllOrder();


}
