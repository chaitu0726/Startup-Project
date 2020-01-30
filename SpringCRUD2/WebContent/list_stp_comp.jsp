<%@page import="com.project.model.Funding"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Funds for Startup</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" 
integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<style>
body {
  font-family: "Lato", sans-serif;
}
	
a:hover {
  background-color: lightgreen;
}
.vl {
  border-left: 6px solid green;
  height: 500px;
}
@media screen and (max-height: 450px) {
  .sidenav {padding-top: 15px;}
  .sidenav a {font-size: 18px;}
}
</style>
<link rel="stylesheet" href="home.css">
</head>
<body>

<c:if test="${sessionScope.uname == null}">
	<%-- user is not available --%>
	<c:redirect url="index.jsp"></c:redirect>
</c:if>


	<c:if test="${sessionScope.uname !=null && sessionScope.role == 2}">
<div>
<div class="row bg-dark sticky-top " >
		<div class="col-5"></div>
		<div  class="col-3">Funding List</div>
		<div class="col-1" ><h5 style="height:60px; text-align: center; padding:15px"><a href="home_startup">Home</a></h5></div>
		<div class="col-1" ><h5 style="height:60px; text-align: center; padding:15px"><a href="logout">Logout</a></h5></div>
		<div class="col-1"></div>
	</div>
</div>
<div class="container mt-2">
<div class="row">
	<div class="col-3">
		
		<table class="table">
  			<thead>
    			<tr class="table-danger">
     				<th scope="col"></th>
      				<th scope="col">Startup Name</th>
  				</tr>
  			</thead>
  			<tbody>
  			
  				<c:forEach items="${startupname}" var="temp">
      				<tr class="table-info">
      				<th></th>
      				<th scope="row">${temp}</th>
   				</c:forEach>
   			
   			</tbody>
   		</table>	
	</div>
	   
  	<div class="col-9">
  	 
 		<table class="table">	 	
  			<thead>
    			<tr class="table-danger">
     				<th scope="col"></th>
    				<th scope="col">Description</th>
       				<th scope="col">Amount</th>
       				<th scope="col"></th>
  				</tr>
  			</thead>
   			<tbody>
   				<c:forEach items="${lists}" var="copy">
   				<tr class="table-info">
   					<th scope="col"></th>
      				<td>${copy.fundDescription}</td>
      				<td>${copy.fundAmount}</td>
       				<td class="bg-light" >
       				<form style="height: 20px;" action="fundSelected" method="post">
       				<input type="hidden" value="${copy.fundId}" name="fundId">
       				<input type="submit" class="bg-dark text-light" value="Select"></form></td>
 					<tr>
 	 			 </c:forEach>
   			</tbody>   		
		</table>	
   </div>
</div> 	
</div>
</c:if>
</body>
<script type = "text/javascript">
   function preventBack(){window.history.forward();}
    setTimeout("preventBack()", 0);
    window.onunload=function(){null};
</script>
</html>