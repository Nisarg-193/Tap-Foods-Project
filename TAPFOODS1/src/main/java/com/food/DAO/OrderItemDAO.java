package com.food.DAO;

import java.util.List;


import com.food.model.OrderItem;

public interface OrderItemDAO {
	
	void addOrderItem(OrderItem OrderItem);
	OrderItem getOrderItem(int Order_item_id);
	void updateOrderItem(OrderItem Order_item_id);
	void deleteOrderItem(int OrderItem);
	List<OrderItem> getAllOrderItem();

}
