<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="Home.css">
 
</head>
<body  class="signbody">
<form action="register" method="post">

<div  class="loginForm">
        <div class="modal-content">
            <span class="closeBtn"></span>
            <p>Already have an accont <a href="SignIn.jsp" class="switch">LogIn</a></p>
            <h1 class="form-title">Registration Form</h1>
            <label for="name">Name:</label>
            <input type="text" id="name" name="username"><br>
            <label for="email">Email:</label>
            <input type="email" id="email" name="email"><br>
            <label for="passwordReg">Password:</label>
            <input type="password" id="passwordReg" name="password"><br>
            <label for="cpasswordReg">cPassword:</label>
            <input type="password" id="cpasswordReg" name="cpassword"><br>
            <label for="address">Address:</label>
            <input type="text" id="address" name="address"><br>
            <label for="address">Role:</label>
            <input type="text" id="role" name="role"><br>
            <button class="btn" id="registerSubmit">Submit</button>
            
        </div>
    </div>

</form>
</body>
</html>