package com.tap.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.food.DAOimpl.MenuDAOImp;
import com.food.DAOimpl.OrderDAoImp;
import com.food.DAOimpl.OrderHistoryDAOImp;
import com.food.DAOimpl.OrderItemDAOImp;
import com.food.DAOimpl.RestaurantDAOImp;
import com.food.DAOimpl.UserDAOImp;
import com.food.model.Menu;
import com.food.model.Order;
import com.food.model.OrderHistory;
import com.food.model.OrderItem;
import com.food.model.Restaurant;
import com.food.model.User;

public class Launch {
	


	public static void main(String[] args) throws ParseException {
		//SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	   //User u=new User(2,"rani", "def@gmail.com","UK","Customer","def@123");
	  //  UserDAOImp ud=new UserDAOImp();
	  //  ud.addUser(u);
		
		//UserDAOImp u=new UserDAOImp();
		//User user=u.getUser(1);
		//System.out.println(user);
		
		//User u1=new User(1,"raju", "abc@gmail.com","hsr","Customer","abc@123");
		//UserDAOImp u=new UserDAOImp();
		//u.updateUser(u1);
	    
	    //UserDAOImp u=new UserDAOImp();
	    //u.deleteUser(3);
		
	   //UserDAOImp u=new UserDAOImp();
	   //List res=u.getAllUser();
	   //System.out.println(res);
		
		
	//Restaurant	restaurant=new Restaurant(1, "Dominose", "Italian", 12, "BTM", 4.5, true, "Image");
		//RestaurantDAOImp rd=new RestaurantDAOImp();
	 //rd.addRestaurant(restaurant);
		

		//RestaurantDAOImp rd=new RestaurantDAOImp();
		//Restaurant restaurant=rd.getRestaurant(2);
		//System.out.println(restaurant);
		
		
      // Restaurant r=new Restaurant(2,"Olive","north Indian",11,"Indiranagar",4.2,false);
	 //RestaurantDAOImp rd=new RestaurantDAOImp();
	//rd.updateRestaurant(r);
			   
		  
	    //RestaurantDAOImp rd=new RestaurantDAOImp();
	   // rd.deleteRestaurant(1);
		
	
		 RestaurantDAOImp rd=new RestaurantDAOImp();
		  List res=rd.getAllRestaurant();
		  System.out.println(res);
       // OrderDAoImp od = new OrderDAoImp();
		
		//Order order = new Order(2, 24.3, "delivered", "UPI");
		//od.addOrder(order);
		//Order order = od.getOrder(1);
	    //System.out.println(order);

		
		  //Menu m=new Menu("pizza","good",5.1,true);
		   //MenuDAOImp md=new MenuDAOImp();
		    //md.addMenu(m);
		    

		   // MenuDAOImp mdi=new MenuDAOImp();
		    //Menu user=mdi.getMenu(3);
			//System.out.println(user);
		    
		//Menu m=new Menu(1,"burgger","not",1.1,true);
		//MenuDAOImp mdi=new MenuDAOImp();
		//mdi.updateMenu(m);
		
		
		//MenuDAOImp u=new MenuDAOImp();
	    //u.deleteMenu(3);
		
		//MenuDAOImp u=new MenuDAOImp();
		  // List res=u.getAllMenu();
		   //System.out.println(res);
		//Order order=new Order(1,,5.2,"yes","card");
		//OrderDAoImp odi=new OrderDAoImp();
		
		
		 //OrderHistory oh=new OrderHistory(1, "Bill Amount", 23.2);
		  //  OrderHistoryDAOImp ud=new OrderHistoryDAOImp();
		  // ud.addOrderHistory(oh);
		
		//OrderItem oi=new OrderItem(30,3.2);
	    //OrderItemDAOImp ud=new OrderItemDAOImp();
		  //  ud.addOrderItem(oi);
		    
		    //OrderItemDAOImp ud=new OrderItemDAOImp();
		  //List	n=ud.getAllOrderItem();
			//System.out.println(n);
		
		
		///OrderItemDAOImp ud=new OrderItemDAOImp();
			///	ud.deleteOrderItem(1);
	}

}
