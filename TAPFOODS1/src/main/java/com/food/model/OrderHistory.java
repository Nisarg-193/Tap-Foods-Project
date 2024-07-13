package com.food.model;

import java.util.Date;

public class OrderHistory {
	private int order_history_Id;
	private int ordr_id;
	private int user_id;
	private String status;
	private Date orderDate;
	private double totalAmount;
	
	
	
	public OrderHistory() {
		super();
	}



	public OrderHistory(int order_history_Id,  String status, double totalAmount) {
		super();
		this.order_history_Id = order_history_Id;
		
		this.status = status;
		
		this.totalAmount = totalAmount;
	}



	public int getOrder_history_Id() {
		return order_history_Id;
	}



	public void setOrder_history_Id(int order_history_Id) {
		this.order_history_Id = order_history_Id;
	}



	public int getOrdr_id() {
		return ordr_id;
	}



	public void setOrdr_id(int ordr_id) {
		this.ordr_id = ordr_id;
	}



	public int getUser_id() {
		return user_id;
	}



	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public Date getOrderDate() {
		return orderDate;
	}



	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}



	public double getTotalAmount() {
		return totalAmount;
	}



	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}



	@Override
	public String toString() {
		return "OrderHistory [order_history_Id=" + order_history_Id + ", ordr_id=" + ordr_id + ", user_id=" + user_id
				+ ", status=" + status + ", orderDate=" + orderDate + ", totalAmount=" + totalAmount + "]";
	}

		
	

}
