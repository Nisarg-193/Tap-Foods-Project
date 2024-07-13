<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <%@page import=" java.util.List,  com.food.DAO.RestaurantDAO, com.food.model.Restaurant, com.food.model.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <title>Swiggy Clone</title>
   <link rel="stylesheet" href="Home.css">
   
</head>
<body class="homebody" method="post">

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
   
    <section class="hero">
        <div class="hero-container">
            <h1 class="hero-title">Order food from your favorite restaurants And get your food in your table</h1>
           
        </div>
    </section>
    
     <h2 class="res-title">Find Your favorite restaurant </h2>
    <section class="restaurants">
           
        <div class="restaurant-wrapper">
        <button class="arrow left-arrow">&#10094;</button>
        <section class="restaurant-container">
        
        <%
        @SuppressWarnings("unchecked")
        List<Restaurant> restaurantList = (List<Restaurant>)request.getAttribute("restaurantList");
        if(restaurantList != null){
        	for(Restaurant restaurant : restaurantList){
        		
        %>
        <div class="restaurant">
            <img src="images/<%=restaurant.getImagePath() %>" 
             alt="Image of <%=restaurant.getName() %>">
            <h3><%=restaurant.getName() %></h3>
            <p><%=restaurant.getCuisineType() %>
            <%=restaurant.getDeliveryTime() %>mins</p>
          
            
            <a  href="menu?restaurantId= <%=restaurant.getRestaurant_Id()%>"> view munu</a>
            
        </div>
        <% 
        	}
        }else{
        %>
        <p>No restaurant available</p>
        <%
        }
        %>
        
        
    <button class="arrow right-arrow">&#10095;</button>
 </section>
       
    </section>

    <section class="restaurants">
        <h2>Find Your favorite restaurant </h2>
        <div class="restaurant-wrapper">
            <button class="arrow left-arrow">&#10094;</button>
    <div class="restaurant-container">
    <div class="restaurant">
     <a href="Menu.jsp">
        <img src="images/NorthIndian.jpg" alt="Restaurant 1">
        </a>
        <h3>North Indian</h3>
    </div>
    <div class="restaurant">
        <img src="images/southindian.webp" alt="Restaurant 2">
        <h3>South Indian</h3>
        
    </div>
    <div class="restaurant">
        <img src="images/chines.jpeg" alt="Restaurant 3">
        <h3>Chinese</h3>
        
    </div>
    <div class="restaurant">
        <img src="images/pizza.jpg" alt="Restaurant 4">
        <h3>Pizza</h3>
        
    </div>
    <div class="restaurant">
        <img src="images/pizza.jpg" alt="Restaurant 4">
        <h3>Pizza</h3>
        
    </div>
    <div class="restaurant">
        <img src="images/pizza.jpg" alt="Restaurant 4">
        <h3>Pizza</h3>
        
    </div>
</div>
<button class="arrow right-arrow">&#10095;</button>
</div>
   
</section>


    <footer>
        <div class="footer-container">
            <div class="footer-links">
                <a href="#">Privacy Policy</a>
                <a href="#">Terms of Service</a>
                <a href="#">Contact Us</a>
            </div>
            <p>&copy; 2024 Swiggy Clone. All rights reserved.</p>
        </div>
    </footer>
    <script src="Home.js"></script>
</body>
</html>




