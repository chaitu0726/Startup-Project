<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" 
integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.4.1.min.js"></script>
<script
  src="https://code.jquery.com/jquery-3.4.1.min.js"
  integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
  crossorigin="anonymous"></script>
 <style>
<style>
.body{
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
    text-align: left;
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
</head>
<body>

<c:if test="${sessionScope.uname == null}">
	<%-- user is not available --%>
	<c:redirect url="index.jsp"></c:redirect>
</c:if>


<c:if test="${sessionScope.uname !=null && sessionScope.role == 0}">

<div class="row bg-dark sticky-top" style="height: 50px">
<div class="col-1"></div>
<div class="col-4"><a href="#" class="text-light" style="font-size: 25px">Home</a></div>
<div class="col-5 text-light" style="font-size: 30px">Admin Home</div>
<div class="col-2"><a href="logout" class="text-light" style="font-size: 25px">Logout</a></div>
</div>

<div class="login-page">
    <div class="form">
    <form class="Bidding Details" onsubmit="return validate()" action="gstadd" method="post">
        <div class="col-3"></div>
        <div class="col-3"><br></div> 
        <label>GST Id</label>
        <input type="text" id="id1" name="gstId"   placeholder="Enter GST"/>
        <span id="msg1" style="color:red;"></span><br>
         <label>Company Name</label>
        <input type="text" id="id3" name="name"  placeholder="Enter Company Name"/>
        <span id="msg3" style="color:red;"></span><br>
         <label>PAN</label>
         <input type="text" id="id2" name="pan"  placeholder="Enter PAN"/>
         <span id="msg2" style="color:red;"></span>
        <input type="submit" class ="bg-primary" value="Add Company"/>
    </form>
    </div>
    </div>
    </c:if>
</body>
<script type="text/javascript">
$(document).ready(function(){
	$("#id1").change(function(){
		$.ajax({
			url : 'check_gst',
			data : {gst : $("#id1").val()},
			success : function(data){
				$("#msg1").html(data);
			}
		});
		
	});
});
</script>
<script type="text/javascript">
$(document).ready(function(){
	$("#id2").change(function(){
		$.ajax({
			url : 'check_pan',
			data : {pan : $("#id2").val()},
			success : function(data){
				$("#msg2").html(data);
			}
		});
		
	});
});
</script>
<script type="text/javascript">
function validate()
{
	var gstid=document.getElementById("id1").value.trim();
	var name=document.getElementById("id3").value.trim();
	var pan=document.getElementById("id2").value.trim();

	if(gstid=="" || pan=="" || name=="")
		{
			if(gstid=="")
				{
					document.getElementById("msg1").innerHTML=" GstId cannot Empty";
				}
			if(pan=="")
				{
				document.getElementById("msg2").innerHTML=" Pan Id cannot Empty";
				}
			if(name=="")
				{
				document.getElementById("msg3").innerHTML="Company Name cannot be Empty";
				}
			return false;
		}
	else{
	return true;}
}
</script>
<script type = "text/javascript">
   function preventBack(){window.history.forward();}
    setTimeout("preventBack()", 0);
    window.onunload=function(){null};
</script>
</html>