package com.food.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

import com.food.DAO.MenuDAO;
import com.food.DAOimpl.MenuDAOImp;
import com.food.model.Cart;
import com.food.model.CartItem;
import com.food.model.Menu;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CartServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }

        String action = request.getParameter("action");
        if ("add".equals(action)) {
            addItemToCart(request, cart);
        } else if ("update".equals(action)) {
            updateItem(request, cart);
        } else if ("remove".equals(action)) {
            removeItem(request, cart);
        }

        session.setAttribute("cart", cart);
        response.sendRedirect("cart.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("cart.jsp").forward(request, response);
    }

//    private void addItemToCart(HttpServletRequest request, Cart cart) {
//        int itemId = Integer.parseInt(request.getParameter("itemId"));
//        int quantity = Integer.parseInt(request.getParameter("quantity"));
//
//        // Assuming you have a method to get item details like price, name, etc.
//        CartItem item = new CartItem(itemId, "Item Name", quantity, price);
//        cart.addItem(item);
//    }

    
    private void addItemToCart(HttpServletRequest request, Cart cart) {
        int itemId = Integer.parseInt(request.getParameter("itemId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));


        
        MenuDAO menuDAO = new MenuDAOImp();
        Menu menuItem = menuDAO.getMenu(itemId);

        HttpSession session = request.getSession();
        session.setAttribute("resturantId", menuItem.getRestaurant_id());

        if (menuItem != null) {
            CartItem item = new CartItem(
                menuItem.getMenu_id(),
                menuItem.getRestaurant_id(),
                menuItem.getItemname(),
                quantity,
                menuItem.getPrice()
            );
            cart.addItem(item);
        }
    }

    
    
    
    
    private void updateItem(HttpServletRequest request, Cart cart) {
        int itemId = Integer.parseInt(request.getParameter("itemId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        cart.updateItem(itemId, quantity);
    }

    private void removeItem(HttpServletRequest request, Cart cart) {
        int itemId = Integer.parseInt(request.getParameter("itemId"));
        cart.removeItem(itemId);
    }
}
