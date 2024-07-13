<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.food.model.Order"%>
 <%@page import=" java.util.List,  com.food.DAO.RestaurantDAO, com.food.model.Restaurant, com.food.model.User"%>
<html>
<head>
<title>Order Confirmation</title>
<link rel="stylesheet" href="Home.css">
<!-- Update with your actual CSS path -->
</head>
<body class="ordercom-body">
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
   

    <form action="orderConfirmation" method="get">
        <h1 class="ordercom-h1">Order Confirmation</h1>
        <%
        Order order = (Order) session.getAttribute("order");
        if (order != null) {
        %>
        <div class="order-details" >
            <p >Thank you for your order!</p>
            <p>Total Amount: <span><%=order.getTotal_amount()%></span></p>
            <p>Status: <span><%=order.getStatus()%></span></p>
            <p>Payment Method: <span><%=order.getPayment_method()%></span></p>
            <!-- You can add more details here if needed -->
            <%-- You may also list the items in the order if you have that data --%>
        </div>
        <%
        } else {
        %>
        <p>Order details are not available at the moment.</p>
        <%
        }
        %>
        <a href="Home" class="ordercom-a">Return to Home</a>
    </form>
</body>
</html>
