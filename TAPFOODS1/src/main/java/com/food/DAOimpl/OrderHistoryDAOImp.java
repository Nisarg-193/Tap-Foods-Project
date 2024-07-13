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

import com.food.DAO.OrderHistoryDAO;
import com.food.model.OrderHistory;
import com.food.model.OrderItem;
import com.food.model.Restaurant;


public class OrderHistoryDAOImp implements OrderHistoryDAO{
	
	
	
	String url="jdbc:mysql://localhost:3306/online_food_delivery";
	String username="root";
	String password="root";
	
	String insert="INSERT INTO order_history(`order_history_id`,`status`,`TotalAmount`) VALUES(?,?,?)";
	String select="SELECT * FROM `order_history` WHERE `order_history_id`=?";
	String update="UPDATE `order_history` SET  `status`=?,`orderDate`=?,`TotalAmount`=? WHERE `order_history_id`=?";
	String selectAll="SELECT * FROM `order_history`";
	String delete="DELETE FROM `order_history` WHERE order_history_id=?";

	Connection connection=null;
	PreparedStatement statement=null;
	ResultSet res=null;
	OrderHistory oh=null;
	
	public OrderHistoryDAOImp() {
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
	public void addOrderHistory(OrderHistory OrderHistory) {
		PreparedStatement statement=null;
		try {
			
			statement=connection.prepareStatement(insert);
			statement.setInt(1, OrderHistory.getOrder_history_Id());
			statement.setString(2,  OrderHistory.getStatus());
			statement.setDouble(3,  OrderHistory.getTotalAmount());
			System.out.println(statement.executeUpdate());
		} 
		catch (Exception e) 
		{
			
			e.printStackTrace();
		}
		
	}

	@Override
	public OrderHistory getOrderHistory(int Order_history_id) {
		try {
			statement=connection.prepareStatement(select);
			statement.setInt(1, Order_history_id);
			 res=statement.executeQuery();
			
			  if(res.next()) {
				  oh= extractUserFromResultSet(res);
			}
		}
		
			catch (Exception ex) 
			{
				
				ex.printStackTrace();
			}
			return oh;
	}
	
	private OrderHistory extractUserFromResultSet(ResultSet res) throws SQLException{
		OrderHistory oh=new OrderHistory();
		oh.setOrder_history_Id(res.getInt("order_history_Id"));
		oh.setOrdr_id(res.getInt("order_id"));
		oh.setUser_id(res.getInt("user_id"));
		oh.setStatus(res.getString("status"));
		oh.setOrderDate(res.getDate("orderDate"));
		oh.setTotalAmount(res.getInt("TotalAmount"));
		
		return oh;
		
	}

	@Override
	public void updateOrderHistory(OrderHistory OrderHistory) {

		try {
					
				    statement = connection.prepareStatement(update);
					
					statement.setString(1, OrderHistory.getStatus());
					statement.setDate(2,  new Date(OrderHistory.getOrderDate().getTime()));
					statement.setDouble(3, OrderHistory.getTotalAmount());
					statement.setInt(4, OrderHistory.getOrder_history_Id());
					
					
					System.out.println(statement.executeUpdate());
					statement.executeUpdate();

				} 
				catch (Exception e) 
				{
					
					e.printStackTrace();
				}
		
	}

	@Override
	public void deleteOrderHistory(int OrderHistory) {
		try {
			statement = connection.prepareStatement(delete);
			statement.setInt(1,OrderHistory);
			System.out.println("row affected: " + statement.executeUpdate());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<OrderHistory> getAllOrderHistory() {
		List<OrderHistory> al = new ArrayList<OrderHistory>();
		
		 try {
			Statement statement = connection.createStatement();
			ResultSet res = statement.executeQuery(selectAll);
				
			while(res.next()) {
				OrderHistory oh=extractUserFromResultSet(res);
				
				
				al.add(oh);			 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return al;
	}

}
