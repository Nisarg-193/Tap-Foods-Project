package com.food.DAOimpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.food.DAO.OrderDAO;
import com.food.model.Order;
import com.food.model.Restaurant;


public class OrderDAoImp implements OrderDAO{
	
	
	String url="jdbc:mysql://localhost:3306/online_food_delivery";
	String username="root";
	String password="root";
	
	String insert="INSERT INTO order1(`user_id`,`restaurant_id`,`total_amount`,`status`,`payment_method`) VALUES(?,?,?,?,?)";
	String select="SELECT * FROM `order1` WHERE `order_id`=?";
	String update="UPDATE `order1` SET `order_date`=?,`total_amount`=?,`status`=?,`payment_method`=? WHERE `order_id`=?";
	String selectAll="SELECT * FROM `order1`";
	String delete="DELETE FROM `order1` WHERE `order_id`=?";

	Connection connection=null;
	PreparedStatement statement=null;
	ResultSet res=null;
	Order order=null;
	
	public OrderDAoImp() {
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
	public void addOrder(Order Order, HttpSession ressession, int user_id, HttpSession session) {
		PreparedStatement statement=null;
		try {
			
			statement=connection.prepareStatement(insert);
			statement.setInt(1, Order.getUser_id());
			statement.setDouble(2, Order.getRestaurant_id());
			statement.setDouble(3,  Order.getTotal_amount());
			statement.setString(4, Order.getStatus());
			statement.setString(5, Order.getPayment_method());
				
			System.out.println(statement.executeUpdate());
		} 
		catch (Exception e) 
		{
			
			e.printStackTrace();
		}
		
	}

	@Override
	public Order getOrder(int Order_id) {
		
		try {
			statement=connection.prepareStatement(select);
			statement.setInt(1, Order_id);;
			 res=statement.executeQuery();
			
			  if(res.next()) {
				  order= extractUserFromResultSet(res);
			}
		}
		
			catch (Exception ex) 
			{
				
				ex.printStackTrace();
			}
			return order;
	}
	private Order extractUserFromResultSet(ResultSet res) throws SQLException{
		
		Order order=new Order();
		order.setOrder_id(res.getInt("order_id"));
		order.setUser_id(res.getInt("user_id"));
		order.setRestaurant_id(res.getInt("Restaurant_id"));
		order.setOrder_date(res.getDate("order_date"));
		order.setTotal_amount(res.getInt("total_amount"));
		order.setStatus(res.getString("status"));
		order.setPayment_method(res.getString("payment_menthod"));
	
		return order;
	
		
	}

	@Override
	public void updateOrder(Order Order) {

		try {
					
				    statement = connection.prepareStatement(update);
					
					statement.setDate(1, new Date(Order.getOrder_date().getTime()));
					statement.setDouble(2,  Order.getTotal_amount());
					statement.setString(3, Order.getStatus());
					statement.setString(4, Order.getPayment_method());
					statement.setInt(5, Order.getOrder_id());
					System.out.println(statement.executeUpdate());
					statement.executeUpdate();

				} 
				catch (Exception e) 
				{
					
					e.printStackTrace();
				}
		
	}

	@Override
	public void deleteOrder(int Order) {
		try {
			statement = connection.prepareStatement(delete);
			statement.setInt(1,Order);
			System.out.println("row affected: " + statement.executeUpdate());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Order> getAllOrder() {
		List<Order> al = new ArrayList<Order>();
		
		 try {
			Statement statement = connection.createStatement();
			ResultSet res = statement.executeQuery(selectAll);
				
			while(res.next()) {
					
				Order order=extractUserFromResultSet(res);				
				al.add(order);			 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return al;
	}

	}


