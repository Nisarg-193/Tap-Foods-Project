<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.food.model.Cart, com.food.model.CartItem,com.food.model.User" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Your Cart</title>
    <link rel="stylesheet" href="Home.css">
</head>
<body class="homebody">

    <header>  
        <div class="logo">
            <img src="images/logo.png" alt="Swiggy Logo">
        </div>
        <div class="location-search">
            <a class="location-btn" href="SwiggyLocation.html">Locate Me</a>
           <a class="header-search-btn" href="SwiggySearch.html">Search </a>
         

        </div>
        <nav>
            <ul>
               
                <%
                User loggedInUser=(User) session.getAttribute("loggedInUser");
                if(loggedInUser !=null){
                
                %>
                <span>wellcome,<%=loggedInUser.getUsername() %>!
                
                </span>
                 <li><a href="#">Home</a></li>
                	<li><a href="#">Offers</a></li>
                <li><a href="#">About</a></li>
       
                 <li><a href="#">Cart</a></li>
               <%
                }else{
               %>
                 <li> <a href="SignIn.jsp" >Sign In</a></li>
                 <%
                }
                 %>
            </ul>
        </nav>
    </header>
   
	
    <h1 class="cart-title">Your Shopping Cart</h1>
    <div class="cart-items">
        <%
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart != null && !cart.getItems().isEmpty()) {
            for (CartItem item : cart.getItems().values()) {
        %>
        <div class="cart-item">
            <h3><%= item.getName() %></h3>
            <p>&#x20B9; <%= item.getPrice() %></p>
            <form action="cart" method="post">
                <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
                <label>Quantity: <input type="number" name="quantity" value="<%= item.getQuantity() %>" min="1" class="quantity-input"></label>
                <input type="hidden" name="action" value="update">
                <button type="submit" class="update-btn">Update</button>
                <input type="hidden" name="action" value="remove">
                <button type="submit" class="remove-btn">Remove</button>
            </form>
        </div>
        <%
            }
        } else {
        %>
        <p>Your cart is empty.</p>
        <%
        }
        %>
    
        <!-- Add More Items Button -->
        <a href="menu?restaurantId=<%= session.getAttribute("restaurantId") %>" class="btn add-more-items-btn">Add More Items</a>

        <!-- Proceed to Checkout Button -->
        <%
        if (session.getAttribute("cart") != null) {
        %>
        <form action="checkout" method="post">
            <input type="submit" value="Proceed to Checkout" class="btn proceed-to-checkout-btn">
        </form>
        <%
        }
        %>
    </div>
</body>
</html>