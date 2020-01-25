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
<style type="text/css">

body {
  font-family: "Lato", sans-serif;
  
}

	#link { color: white; } 
	
	#link:hover {background-color:black;}
	
a:hover {
  background-color: green;
}

.vl {
  border-left: 6px solid green;
  height: 500px;
}

	.sidenav {
  height: 100%;
  width: 0;
  position: fixed;
  z-index: 1;
  top: 0;
  left: 0;
  background-color: #111;
  overflow-x: hidden;
  transition: 0.5s;
  padding-top: 60px;
}

.sidenav a {
  padding: 8px 8px 8px 32px;
  text-decoration: none;
  font-size: 25px;
  color: #818181;
  display:white;
  transition: 0.3s;
}

.sidenav a:hover {
  color: #f1f1f1;
}

.sidenav .closebtn {
  position: absolute;
  top: 0;
  right: 25px;
  font-size: 36px;
  margin-left: 50px;
}

@media screen and (max-height: 450px) {
  .sidenav {padding-top: 15px;}
  .sidenav a {font-size: 18px;}
}



.AppyBid{
  background-color :red;
  color: white;
  padding: 10px 20px;
  border-radius: 4px;
  border-color: red;
}

#mybutton {
  position: fixed;
  bottom: 30px;
  right: 60px;
}


</style>
</head>
<body>

<c:if test="${sessionScope.uname == null}">
	<%-- user is not available --%>
	<c:redirect url="index.jsp"></c:redirect>
</c:if>

<c:if test="${sessionScope.uname !=null && sessionScope.role == 2}">

<div class="container-fluid" >

	<div class="row bg-dark" style="height:50px; padding:10px; font-size:20px;">
		<div class="col-5"><span class="text-light" style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776;Menu</span></div>
		<div class="col-5"><h4 class="text-light">List Of StartUp</h4> </div>
		<div class="col-1"><a href="#" class="text-light">HOME</a></div>
		 <div class="col-1"><a href="logout" class="text-light"><h4>Logout</h4></a></div>
	</div>
	
	<div class="row">
		<div class="LeftSideBar"></div>
	</div>
	
	<div id="mySidenav" class="sidenav">
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
  <a href="comp_add_project.jsp">Add project</a>
  <a href="#">Funds List</a><br>
 <a href="#">Bid Details</a>
</div>

</div>
<div class="container mt-5">

<!-- --------------------------------------------------------------------------------- -->
		<table class="table">
  <thead>
    <tr class="table-danger">
     <th scope="col"></th>
      <th scope="col">Employee</th>
      <th scope="col">Email</th>
      <th scope="col">Description</th>
       <th scope="col">Profile</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${lists}" var="temp">
    <tr class="table-info">
      <th scope="row"></th>
      <td>${temp.noOfEmployee}</td>
      <td>${temp.email}</td>
       <td>${temp.discription}</td>
       <td class="bg-light" ><a href="view_profile">View Profile</a></td>
    </tr>
  
    </c:forEach>
  </tbody>
</table>		

<!-- ------------------------------------------------------------------------------------- -->
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