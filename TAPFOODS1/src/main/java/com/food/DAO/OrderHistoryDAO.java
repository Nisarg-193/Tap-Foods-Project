package com.food.DAO;

import java.util.List;


import com.food.model.OrderHistory;

public interface OrderHistoryDAO {
	void addOrderHistory( OrderHistory OrderHistory);
	OrderHistory getOrderHistory(int Order_history_id);
	void updateOrderHistory(OrderHistory OrderHistory);
	void deleteOrderHistory(int OrderHistory);
	List<OrderHistory> getAllOrderHistory();
	
	
}
