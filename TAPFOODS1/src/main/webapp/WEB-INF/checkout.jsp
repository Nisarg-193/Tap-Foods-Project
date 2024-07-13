<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.food.model.Menu" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Checkout</title>
    <link rel="stylesheet" href="Home.css">
</head>
<body class="Menubody">
    <header class="Mheader">
        <div class="logo">
            <img src="images/logo.png" alt="Swiggy Logo">
        </div>
        <nav>
            <ul>
                <li><a href="#">Home</a></li>
                <li><a href="#">Offers</a></li>
                <li><a href="#">Help</a></li>
                <li><a href="SwiggySignIn.html">Sign In</a></li>
                <li><a href="Cart">Cart</a></li>
            </ul>
        </nav>
    </header>

    <h2>Checkout</h2>
    <main class="Mmain">
        <section class="checkout-items">
            <h3>Order Summary</h3>
            <ul>
                <% 
                    HttpSession sessi = request.getSession(false); // Get existing session, if any
                    List<Menu> cart = (List<Menu>) session.getAttribute("cart");
                    if (cart != null && !cart.isEmpty()) {
                        for (Menu menu : cart) {
                %>
                <li>
                    <span><%= menu.getItemname() %></span>
                    <span class="price">₹<%= menu.getPrice() %></span>
                </li>
                <% 
                        }
                    }
                %>
            </ul>
            <hr>
            <div class="total">
                <span>Total:</span>
                <span class="price">₹<%= session.getAttribute("totalPrice") %></span>
            </div>
        </section>

        <section class="payment">
            <h3>Payment</h3>
            <form action="PaymentServlet" method="post">
                <!-- Payment form fields can be added here -->
                <button type="submit">Pay Now</button>
            </form>
        </section>
    </main>
</body>
</html>
