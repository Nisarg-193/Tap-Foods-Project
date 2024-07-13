package com.food.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import com.food.DAO.UserDAO;
import com.food.DAOimpl.UserDAOImp;
import com.food.model.User;

/**
 * Servlet implementation class Register
 */
@WebServlet("/register")
public class Register extends HttpServlet {
	
	UserDAO userDAO;
	
	  
    @Override
    public void init() throws ServletException {
    	userDAO=new UserDAOImp();
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		userDAO=new UserDAOImp();
		
		String username,email,password,cpassword,address,role;
		
		username=request.getParameter("username");
		email=request.getParameter("email");
		password=request.getParameter("password");		
		cpassword = request.getParameter("cpassword");
		address=request.getParameter("address");
		role=request.getParameter("role");
		
		if(password.equals(cpassword)) {
			
			int x = userDAO.addUser(new User(username, email, address, role, password));
			
			if(x != 0) {
				response.sendRedirect("SignIn.jsp");
			}
			else {
				response.sendRedirect("failure.jsp");
			}
		}
		else {
			response.sendRedirect("PasswordError.jsp");
		}
		
		
	}

}
