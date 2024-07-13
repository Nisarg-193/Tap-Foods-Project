<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.food.model.Menu,com.food.model.User"%>

<html>
<head>
<title>Menu</title>
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
	 <h1 class="mh1">Menu</h1>
    <div class="menu-container">
        <%
        List<Menu> menuList = (List<Menu>) request.getAttribute("menuList");
        if (menuList != null) {
            for (Menu menu : menuList) {
        %>
        <div class="menu-item">
            <img src="images/<%= menu.getImagePath() %>" alt="Image of <%= menu.getItemname() %>">
            <h3><%= menu.getItemname() %></h3>
            <p><%= menu.getDescription() %></p>
            <p>Price: <%= menu.getPrice() %></p>
            <form action="CartServlet" method="post">
                <input type="hidden" name="itemId" value="<%= menu.getMenu_id() %>">
                Quantity: <input type="number" name="quantity" value="1" min="1" class="quantity-input">
                <input type="hidden" name="action" value="add">
                <button type="submit" class="add-to-cart-btn">Add to Cart</button>
            </form>
        </div>
        <%
            }
        } else {
        %>
        <p>No menu items available.</p>
        <%
        }
        %>
    </div>
</body>
</html>