package com.food.DAOimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.food.DAO.OrderItemDAO;
import com.food.model.OrderItem;
import com.food.model.Restaurant;

public class OrderItemDAOImp implements OrderItemDAO{
	
	String url="jdbc:mysql://localhost:3306/online_food_delivery";
	String username="root";
	String password="root";
	
	String insert="INSERT INTO `order_item`(`quantity`,`item_total`) VALUES(?,?)";
	String select="SELECT * FROM `order_item` WHERE `order_item_id`=?";
	String update="UPDATE `order_item` SET `quantity`=?,`item_total`=? WHERE `order_item_id`=?";
	String selectAll="SELECT * FROM `order_item`";
	String delete="DELETE FROM `order_item` WHERE order_item_id=?";

	Connection connection=null;
	PreparedStatement statement=null;
	ResultSet res=null;
	OrderItem oi=null;
	
	
	
	
	public OrderItemDAOImp() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url,username,password);
			
		}
		catch (Exception e) 
		{
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void addOrderItem(OrderItem OrderItem) {
		PreparedStatement statement=null;
		try {
			
			statement=connection.prepareStatement(insert);
			statement.setInt(1, OrderItem.getQuantity());
			statement.setDouble(2, OrderItem.getItem_total());
			
			System.out.println(statement.executeUpdate());
		} 
		catch (Exception e) 
		{
			
			e.printStackTrace();
		}
	}
		
	

	@Override
	public OrderItem getOrderItem(int Order_item_id) {
		OrderItem oi=null;

		
		try {
			statement=connection.prepareStatement(select);
			statement.setInt(1, Order_item_id);
			 res=statement.executeQuery();
			
			  if(res.next()) {
				  oi=extractUserFromResultSet(res);
			}
		}
		
			catch (Exception ex) 
			{
				
				ex.printStackTrace();
			}
			return oi;

	}

	private OrderItem extractUserFromResultSet(ResultSet res) throws SQLException{
		OrderItem oi=new OrderItem();
		oi.setOrderItem_id(res.getInt("order_item_id"));
		oi.setOrder_id(res.getInt("order_id"));
		oi.setMenu_id(res.getInt("menu_id"));
		oi.setQuantity(res.getInt("quantity"));
		oi.setItem_total(res.getDouble("item_total"));
		
	
		return oi;
		
	}

		

	@Override
	public void updateOrderItem(OrderItem OrderItem) {
		try {
			
		    statement = connection.prepareStatement(update);
			
			statement.setInt(1, OrderItem.getQuantity());
			statement.setDouble(2,  OrderItem.getItem_total());
			statement.setDouble(3,  OrderItem.getOrderItem_id());
			
			
			System.out.println(statement.executeUpdate());
			statement.executeUpdate();

		} 
		catch (Exception e) 
		{
			
			e.printStackTrace();
		}
	}

	@Override
	public void deleteOrderItem(int Order_item_id) {
		try {
			statement = connection.prepareStatement(delete);
			statement.setInt(1,Order_item_id);
			System.out.println("row affected: " + statement.executeUpdate());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<OrderItem> getAllOrderItem() {
		List<OrderItem> al = new ArrayList<OrderItem>();
		
		 try {
			Statement statement = connection.createStatement();
			ResultSet res = statement.executeQuery(selectAll);
				
			while(res.next()) {
				OrderItem oid=extractUserFromResultSet(res);
				
				al.add(oid);			 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return al;
	}

}
