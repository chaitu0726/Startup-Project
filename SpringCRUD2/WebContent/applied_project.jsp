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
<div class="col-5 text-light" style="font-size: 30px">Applied Project</div>
<div class="col-2"><a href="logout" class="text-light" style="font-size: 25px">Logout</a></div>
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
  			
  				<c:forEach items="${startupProjectList}" var="temp">
      				<tr class="table-info">
      				<th></th>
      				<th scope="row">${temp.projectName}</th>
   				</c:forEach>
   			
   			</tbody>
   		</table>	
	</div>
	   
  	<div class="col-9">
  	 
 		<table class="table">	 	
  			<thead>
    			<tr class="table-danger">
     				<th scope="col"></th>
    				<th scope="col">Amount</th>
       				<th scope="col">Duration</th>
       				
  				</tr>
  			</thead>
   			<tbody>
   				<c:forEach items="${startupBidList}" var="copy">
   				<tr class="table-info">
   					<th scope="col"></th>
      				<td>${copy.bidAmount}</td>
      				<td>${copy.bidDuration}</td>
 					<tr>
 	 			 </c:forEach>
   			</tbody>   		
		</table>	
   </div>
</div> 	
</div>
</c:if>
</body>
</html>