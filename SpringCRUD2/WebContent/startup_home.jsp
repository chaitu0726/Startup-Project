<%@page import="com.project.bean.StartUp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" 
integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="home.css">
</head>
<body>
<c:if test="${sessionScope.uname == null}">
	<%-- user is not available --%>
	<c:redirect url="index.jsp"></c:redirect>
</c:if>

<!--   <s:url var="lgot" value="/logout.htm"></s:url> -->

<c:if test="${sessionScope.uname !=null && sessionScope.role == 1}">
<div class="container">

	<div class="row">
		<div class="LeftSideBar"></div>
	</div>
	
	<div id="mySidenav" class="sidenav">
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
  <a href="#">Applied</a>
  <a href="#">Selected</a>
  <a href="add_funding.jsp">Funding</a>
  <a href="bidding.jsp">Bidding</a>
</div>


<div class="row" style="background-color:lightgreen;  height:50px; text-align: center; padding:10px;">
<div class="col-5"></div>
<div class="col-3"><h2>Project List</h2></div>
<div class="col-2"></div>
<div class="col-1"><a href="logout.htm"><h4>Logout</h4></a></div>
</div>

<span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; Menu</span>

		<c:forEach items="${lists}" var="temp">
			<div class="row" style="height:90px">
			<div class="col-2"></div>
			<div class="col-8" style="background-color: #E2e2e2">${temp.projectName}</div>
			<div class="col-2"></div>
			</div>
		</c:forEach>

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