package com.food.DAOimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;





import com.food.DAO.UserDAO;
import com.food.model.User;



public class UserDAOImp implements UserDAO{
	String url="jdbc:mysql://localhost:3306/online_food_delivery";
	String username="root";
	String password="root";
	
	String insert="INSERT INTO user(`username`,`email`,`address`,`role`,`password`) VALUES(?,?,?,?,?)";
	String select="SELECT * FROM `user` WHERE username=?";
	String update="UPDATE `User` SET `username`=?, `email`=? ,`address`=?,`role`=?,`password`=? WHERE `user_id`=?";
	String selectAll="SELECT * FROM `user`";
	String delete="DELETE FROM `user` WHERE user_id=?";

	Connection connection=null;
	PreparedStatement statement=null;
	ResultSet res=null;
	User user =null;
	

	
	public UserDAOImp() {
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
	public int  addUser(User user) {
		PreparedStatement statement=null;
		try {
			
			statement=connection.prepareStatement(insert);
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getEmail());
			statement.setString(3,  user.getAddress());
			statement.setString(4, user.getRole());
			statement.setString(5, user.getPassword());		
			return statement.executeUpdate();
		} 
		catch (Exception e) 
		{
			
			e.printStackTrace();
			return 0;
		}

		
	}
	@Override
	public User getUser(String username) {
		
		try {
		statement=connection.prepareStatement(select);
		statement.setString(1,	 username);
		 res=statement.executeQuery();
		
		 if(res.next()) {
			user= extractUserFromResultSet(res);
		}
	}
	
		catch (Exception ex) 
		{
			
			ex.printStackTrace();
		}
		return user;

	}
	
	private User extractUserFromResultSet(ResultSet res) throws SQLException{
		User user=new User();
		user.setUserid(res.getInt("user_id"));
		user.setUsername(res.getString("username"));
		user.setPassword(res.getString("Password"));
		user.setEmail(res.getString("email"));
		user.setAddress(res.getString("address"));
		user.setRole(res.getString("role"));
	
		return user;
		
	}

	
	
	
	@Override
	public void updateUser(User user) {
try {
			
		    statement = connection.prepareStatement(update);
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getEmail());
			statement.setString(3,  user.getAddress());
			statement.setString(4, user.getRole());
			statement.setString(5, user.getPassword());	
			statement.setInt(6, user.getUserid());	
			
			System.out.println(statement.executeUpdate());
			statement.executeUpdate();

		} 
		catch (Exception e) 
		{
			
			e.printStackTrace();
		}
		
	}

		
	
	@Override
	public void deleteUser(int user) {
		try {
			statement = connection.prepareStatement(delete);
			statement.setInt(1,user);
			System.out.println("row affected: " + statement.executeUpdate());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		
	}
	@Override
	public List<User> getAllUser() {
		List<User> al = new ArrayList<User>();
	
		 try {
			Statement statement = connection.createStatement();
			ResultSet res = statement.executeQuery(selectAll);
				
			while(res.next()) {
				User user=	extractUserFromResultSet(res);			
				al.add(user);			 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return al;

	}
}