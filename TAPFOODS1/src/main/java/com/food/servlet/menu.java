package com.food.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.food.DAO.MenuDAO;
import com.food.DAOimpl.MenuDAOImp;
import com.food.model.Menu;
import com.food.model.Restaurant;

/**
 * Servlet implementation class menu
 */
@WebServlet("/menu")
public class menu extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	MenuDAOImp menuDAOImp;
	
	@Override
	public void init() throws ServletException {
		menuDAOImp=new MenuDAOImp();
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Menu");
		int restaurantId= Integer.parseInt(req.getParameter("restaurantId"));
		System.out.println(restaurantId);
	}
	
	
    public menu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		List<Menu>	menuList=menuDAOImp.getAllMenu();
		   
	    
	    req.setAttribute("menuList", menuList);
	    System.out.println("asdfasdfg");
	    
	     RequestDispatcher	dispatcher=req.getRequestDispatcher("Menu.jsp");
	     dispatcher.include(req, res);
	}

}
