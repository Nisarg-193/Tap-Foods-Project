package com.food.DAOimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.food.DAO.MenuDAO;
import com.food.model.Menu;
import com.food.model.Restaurant;

public class MenuDAOImp implements MenuDAO{
	String url="jdbc:mysql://localhost:3306/online_food_delivery";
	String username="root";
	String password="root";
	
	String insert="INSERT INTO `menu`(`itemname`,`description`,`price`,`isAvailable`) VALUES(?,?,?,?)";
	String select="SELECT * FROM `menu` WHERE `menu_id`=?";
	String update="UPDATE `menu` SET `itemname`=?, `description`=? ,`price`=?,`isAvailable`=? WHERE `menu_id`=?";
	String selectAll="SELECT * FROM `menu`";
	String delete="DELETE FROM `menu` WHERE `menu_id`=?";
    String restaurant="SELECT * FROM `restaurant` WHERE `restaurant_id`=?";
    
    
	Connection connection=null;
	PreparedStatement statement=null;
	ResultSet res=null;
	Menu menu=null;
	
	
	public MenuDAOImp() {
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
	public void addMenu(Menu Menu) {
		PreparedStatement statement=null;
		try {
			
			statement=connection.prepareStatement(insert);
			statement.setString(1, Menu.getItemname());
			statement.setString(2, Menu.getDescription());
			statement.setDouble(3,  Menu.getPrice());
			statement.setBoolean(4, Menu.getisAvailable());
			
			System.out.println(statement.executeUpdate());
		} 
		catch (Exception e) 
		{
			
			e.printStackTrace();
		}
		
	}

	@Override
	public Menu getMenu(int Menu_id) {

		try {
			statement=connection.prepareStatement(select);
			statement.setInt(1, Menu_id);;
			 res=statement.executeQuery();
			
			  if(res.next()) {
				  menu= extractUserFromResultSet(res);
			}
		}
		
			catch (Exception ex) 
			{
				
				ex.printStackTrace();
			}
			return menu;

	}
	private Menu extractUserFromResultSet(ResultSet res) throws SQLException{
		Menu menu=new Menu();
		menu.setMenu_id(res.getInt("menu_id"));
		menu.setRestaurant_id(res.getInt("restaurant_id"));
		menu.setItemname(res.getString("itemname"));
		menu.setDescription(res.getString("description"));
		menu.setPrice(res.getInt("price"));
		menu.setisAvailable(res.getBoolean("isAvailable"));
		
		return menu;
	
		
	}


	@Override
	public void updateMenu(Menu Menu) {

		try {
					
				    statement = connection.prepareStatement(update);
					
					statement.setString(1, Menu.getItemname());
					statement.setString(2,  Menu.getDescription());
					statement.setDouble(3, Menu.getPrice());
					statement.setBoolean(4, Menu.getisAvailable());	
					statement.setDouble(5, Menu.getMenu_id());	
					
					
					System.out.println(statement.executeUpdate());
					statement.executeUpdate();

				} 
				catch (Exception e) 
				{
					
					e.printStackTrace();
				}
	}

	@Override
	public void deleteMenu(int Menu) {
		try {
			statement = connection.prepareStatement(delete);
			statement.setInt(1,Menu);
			System.out.println("row affected: " + statement.executeUpdate());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Menu> getAllMenu() {
		List<Menu> al = new ArrayList<Menu>();
		
		 try {
			Statement statement = connection.createStatement();
			ResultSet res = statement.executeQuery(selectAll);
				
			while(res.next()) {
				Menu menu=extractUserFromResultSet(res);		
				al.add(menu);			 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return al;
	}
	
	

}
