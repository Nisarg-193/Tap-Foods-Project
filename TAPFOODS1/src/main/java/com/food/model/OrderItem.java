package com.food.model;

public class OrderItem {
	private int orderItem_id;
	private int order_id;
	private int menu_id;
	private int quantity;
	private double item_total;
	
	
	
	public OrderItem() {
		super();
	}



	public OrderItem(int  orderItem_id, int quantity, double item_total) {
		super();
		//this.orderItem_id = orderItem_id;
		this.orderItem_id=orderItem_id;
		this.quantity = quantity;
		this.item_total = item_total;
	}



	public int getOrderItem_id() {
		return orderItem_id;
	}



	public void setOrderItem_id(int orderItem_id) {
		this.orderItem_id = orderItem_id;
	}



	public int getOrder_id() {
		return order_id;
	}



	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}



	public int getMenu_id() {
		return menu_id;
	}



	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public double getItem_total() {
		return item_total;
	}



	public void setItem_total(double item_total) {
		this.item_total = item_total;
	}



	@Override
	public String toString() {
		return "OrderItem [orderItem_id=" + orderItem_id + ", order_id=" + order_id + ", menu_id=" + menu_id
				+ ", quantity=" + quantity + ", item_total=" + item_total + "]";
	}
	
	
	
	
	
}
