<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <title>Sign In</title>
    <link rel="stylesheet" href="Home.css">
   
</head>

<body class="signbody">
    <form action="SignIn" method="post">
    
    <div  class="loginForm">
        <div class="modal-content">
            <span class="closeBtn"></span>
            <h1 class="form-title" >Login Form</h1>
            <label for="username">Username:</label>
            <input type="text" id="username" name="username"><br>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password"><br>
            <button class="btn" id="loginSubmit">Submit</button><br><br>
            <p class="">Don't have an account? <a href="Register.jsp" class="switch">Create Account</a></p>
        </div>
    </div>
    </form>

 
</body>
</html>
