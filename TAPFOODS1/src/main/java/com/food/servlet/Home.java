package com.food.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.food.DAO.RestaurantDAO;
import com.food.DAOimpl.RestaurantDAOImp;
import com.food.model.Restaurant;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	RestaurantDAO restaurantDAO;
		
	@Override
		public void init() throws ServletException {
		restaurantDAO=new RestaurantDAOImp();
		
		}

	@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
				
		List<Restaurant> restaurantList = restaurantDAO.getAllRestaurant();
		System.out.println(restaurantList);
	   
	    req.setAttribute("restaurantList", restaurantList);
	    System.out.println("asdfasdfg");
	    
	     RequestDispatcher	dispatcher = req.getRequestDispatcher("Home.jsp");
	     dispatcher.include(req, resp);
			}
		
		}
		
	
	


