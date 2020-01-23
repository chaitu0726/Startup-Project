<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<c:if test="${sessionScope.uname == null}">
	<%-- user is not available --%>
	<c:redirect url="index.jsp"></c:redirect>
</c:if>

<div class="row" style="background-color:lightgreen;  height:50px; text-align: center; padding:10px;">
<div class="col-5"></div>
<div class="col-3"><h2>Project List</h2></div>
<div class="col-2"></div>
<div class="col-1"><a href="logout.htm"><h4>Logout</h4></a></div>
</div>

<div class="login-page">
    <div class="form">
    <form class="Bidding Details">
        <div class="col-3"></div>
        <div class="col-6" style="font-size:20px;">Bidding Details</div> 
        <div class="col-3"><br></div> 
        <input type="text" placeholder="Bid-Id"/>
        <input type="text" placeholder="Project-Id"/>
        <input type="text" placeholder="Company-Id"/>
        <input type="text" placeholder="StartUp-Id"/>
        <input type="text" placeholder="Bid Amount"/>
        <input type="text" placeholder="Bid-Duration"/>
        <input type="text" placeholder="Bid-Status"/>
        <button>
            Apply
        </button>
        
    </form>
    </div>
    </div>
</body>
</html>