package com.food.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.DAO.OrderDAO;
import com.food.DAOimpl.OrderDAoImp;

import com.food.model.Cart;
import com.food.model.CartItem;
import com.food.model.Order;
import com.food.model.Restaurant;
import com.food.model.User;

@WebServlet("/checkout")
public class checkout extends HttpServlet {

	private OrderDAO orderDAO;

	@Override
	public void init() {
		orderDAO =new OrderDAoImp();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		User user = (User) session.getAttribute("loggedInUser");

		if (cart != null && user != null && !cart.getItems().isEmpty()) {
			// Extract checkout form data
			String paymentMethod = request.getParameter("paymentMethod");

			// Create and populate the order object
			Order order = new Order();
			order.setUser_id(user.getUserid());
//			System.out.println(Integer.parseInt((String)session.getAttribute("resturantId")));
			order.setRestaurant_id((int)session.getAttribute("resturantId"));
			order.setOrder_date(new Date());
			order.setPayment_method("UPI");
			order.setStatus("Pending");

			// Add cart items to the order and calculate the total amount
			double totalAmount = 0;
			for (CartItem item : cart.getItems().values()) {
				// Assuming Order has a method to handle the logic of adding items
//                order.addOrderItem(item);  (this was throwing error)
				totalAmount += item.getPrice() * item.getQuantity();
			}
			order.setTotal_amount(totalAmount);
			

		
			
			// Save the order to the database
			orderDAO.addOrder(order, session, user.getUserid(), session);

			// Clear the cart and redirect to the order confirmation page
			session.removeAttribute("cart");
			session.setAttribute("order", order);
			System.out.println("Checkout");
			response.sendRedirect("checkout.jsp");
		} else {
			response.sendRedirect("cart.jsp"); // Redirect to cart if it's empty or user is not logged in
		}
	}
}