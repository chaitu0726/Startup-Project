<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" 
integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="sample.css">
</head>
<body>

<c:if test="${sessionScope.uname == null}">
	<%-- user is not available --%>
	<c:redirect url="index.jsp"></c:redirect>
</c:if>

<c:if test="${sessionScope.uname !=null && sessionScope.role == 2}">

<div class="container" >

	<div class="row" style="height:50px; padding:10px; font-size:20px; background-color:gray; ">
		<div class="col-7"></div>
		<div class="col-1 "> <a id="link" href="#">HOME</a></div>
		<div class="col-1 "> <a id="link" href="#">UPDATE</a></div>
		<div class="col-1"></div>
		 <div class="col-2 "><a href="logout"><h4 id="link" >Logout</h4></a></div>
	</div>
	
	<div class="row">
		<div class="LeftSideBar"></div>
	</div>
	
	<div id="mySidenav" class="sidenav">
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
  <a href="#">Add project</a>
  <a href="#">Funds List</a><br>
 <a href="#">Bid Details</a>
</div>

<div class="row" style="padding:10px;"></div>
<h2 style="background-color:lightgreen;  height:50px; text-align: center; padding:10px;">List of Startup</h2>

<span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; Menu</span>

<script>
function openNav() {
  document.getElementById("mySidenav").style.width = "250px";
}

function closeNav() {
  document.getElementById("mySidenav").style.width = "0";
}
</script>
	
</div>
</c:if>
</body>
</html>