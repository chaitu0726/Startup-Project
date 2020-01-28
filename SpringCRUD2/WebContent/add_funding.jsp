<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css">
<style>
body{
   background-image:url('Startup-India-Scheme.jpg');
  background-repeat:no-repeat;
  background-attachment:fixed;
    background-color:aliceblue;
    height: 100vh;
    background-size: cover;
    background-position: center;
}

.login-page{
    
  width: 360px;
  padding:10% 0 0 ;
  margin: auto;  
}

.form{

    position: relative;
    z-index: 1;
    background:lightgrey;
    max-width: 360px;
    margin: 0 auto 100px;
    padding: 45px;
    text-align: center;
    box-shadow: 10px 10px 5px grey;
}

.form input{

    font-family: "Roboto",sans-serif;
    outline: 1;
    background: #f2f2f2;
    width: 100%;
    border: 0;
    margin: 0 0 15px;
    padding: 15px;
    box-sizing: border-box;
    font-size: 14px;
}

.form button{
    font-family: "Roboto",sans-serif;
    text-transform: uppercase;
    outline: 0;
    background: #4CAF50;
    width: 100%;
    border: 0;
    padding: 15px;
    color: #FFFFFF;
    font-size: 14px;
    cursor: pointer;
}

.form button:hover,.form button:active{
    background: #43A047;

}

.form .message{
   margin: 15px 0 0;
   color: aliceblue;
   font-size: 12px;

}
</style>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" 
integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">	
</head>
<body>
<c:if test="${sessionScope.uname == null}">
	<%-- user is not available --%>
	<c:redirect url="index.jsp"></c:redirect>
</c:if>
<c:if test="${sessionScope.uname !=null && sessionScope.role == 1}">


<div class="row bg-dark sticky-top" style="height: 50px">
<div class="col-1"></div>
<div class="col-4"><a href="home_startup" class="text-light" style="font-size: 25px">Home</a></div>
<div class="col-5 text-light" style="font-size: 30px">Form For Fund</div>
<div class="col-2"><a href="logout" class="text-light" style="font-size: 25px">Logout</a></div>
</div>
<div class="login-page">
    <div class="form">
    <form class="Bidding Details" action="addfunding" method="post">
        <div class="col-3"></div>
        <div class="col-3"><br></div> 
        <input type="text" name="fundAmount" placeholder="Fund Amount"/>
        Add Description
        <textarea rows="5" cols="35" name="fundDescription"></textarea>  
        <input type="submit" class="bg-primary" value="Apply For Funding"/>
   
    </form>
    </div>
    </div>
</c:if>
</body>
</html>