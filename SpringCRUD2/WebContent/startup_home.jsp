<%@page import="com.project.model.StartUp"%>
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
</style>

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
  <a href="appliedProject">Applied</a>
  <a href="selected_project.jsp">Selected</a>
  <a href="add_funding.jsp">Funding</a>
</div>


<div class="row bg-dark" style="height:50px; text-align: center; padding:10px;">
<div class="col-2 text-light"><span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; Menu</span></div>
<div class="col-2"></div>
<div class="col-3"><h2 class="text-light">Project List</h2></div>
<div class="col-3"></div>
<div class="col-1"><a href="logout"><h4>Logout</h4></a></div>
</div>

<!-- ----------------------------------------------------------------------------------------------------------------- -->

		<c:forEach items="${lists}" var="temp">
			<div class="row mt-4" >
			<div class="col-1"></div>
			<div class="col-6" style="height:90px ;background-color: #E2e2e2;font-size:30px">${temp.projectName}</div>
			<div class="col-1" style="height:90px ;background-color: #E2e2e2"></div>
			<div class="col-2" style="height:90px ;background-color: #E2e2e2;font-size:25px">
			<c:url value = "/apply" var = "myURL">
   				<c:param name = "Id" value = "${temp.projetcId}"/>
			</c:url>
			<c:import url = "${myURL}"/>
			<a href="${myURL}">Apply</a></div>
			<div class="2"></div>
			</div>
		
		</c:forEach>
<!-- ------------------------------------------------------------------------------------------------------------------ -->
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