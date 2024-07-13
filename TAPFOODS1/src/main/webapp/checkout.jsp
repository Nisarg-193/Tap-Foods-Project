<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.food.model.User" %>
<html>
<head>
    <title>Checkout</title>
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
   
   
    <h2 class="checkout-title">Checkout</h2>
    <form class="checkout-form" action="orderConfirmation" >
        <label for="address">Delivery Address:</label>
        <textarea id="address" name="address" required class="checkout-input"></textarea><br><br>
        
        <label for="paymentMethod">Payment Method:</label>
        <select id="paymentMethod" name="paymentMethod" class="checkout-input">
            <option value="CreditCard">Credit Card</option>
            <option value="DebitCard">Debit Card</option>
            <option value="UPI">UPI</option>
        </select><br><br>

        <button type="submit" class="checkout-btn">Place Order</button>
    </form>
</body>
</html>