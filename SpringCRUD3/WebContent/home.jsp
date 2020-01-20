<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" href="style.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" 
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="login-page">
    <div class="form">
    <form class="register-form" action="add.htm" method="post">
        <div class="col-3"></div>
        <div class="col-6" style="font-size:20px;">Registration Form For Startup</div> 
        <div class="col-3"><br></div> 
        
        <input type="text" name="name" placeholder="Company Name"/>
        <input type="text" name="gstId" placeholder="gst-Id"/>
        <input type="text" name="contactNo" placeholder="Phone No"/>
        <input type="text" name="email" placeholder="Email-Id"/>
        <input type="text" name="discription" placeholder="Description"/>
        <input type="text" name="noOfEmployee" placeholder="No Of Employee"/>
		<input type="text" name="pan" placeholder="Enter PAN"/>
		<input type="text" name ="date" placeholder="Registarion Date in YYYY-MM-DD"/>
		<input type="password" name="password" placeholder="Enter Password"/>
        <input type="submit"/>
        <p class="message">Already Registered?<a href="login.jsp">Login</a></p>
    </form>
    </div>
    </div>
</body>
</html>