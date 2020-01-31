<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    
    <title>Document</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" 
integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<style type="text/css">
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
   font-size: 13px;

}

.form .message a{
    color:#4CAF50;
    text-decoration:none ;
}
</style>
</head>
<body>
<c:if test="${sessionScope.uname == null}">
	<%-- user is not available --%>
	<c:redirect url="index.jsp"></c:redirect>
</c:if>
<c:if test="${sessionScope.uname !=null && sessionScope.role == 2}">
<div class="">

<div class="row bg-dark sticky-top " >
		<div class="col-9"></div>
		<div class="col-1" ><h5 style="height:60px; text-align: center; padding:15px"><a href="home_startup">Home</a></h5></div>
		<div class="col-1" ><h5 style="height:60px; text-align: center; padding:15px"><a href="logout">Logout</a></h5></div>
		<div class="col-1"></div>
	</div>

<div class="login-page">
		
    <div class="form">
    <form class="register-form" onsubmit="return validate()" action="comProjectAdd" method="post">
        <div class="col-1"></div>
        <div class="col-10" style="font-size:30px;text-align: center;">Project Details</div> 
        <div class="col-1"><br></div> 
       
         <label>Project Name</label>
        <input type="text" id="pname" name="projectName" placeholder="Project-Name"/>
        <span id="msg1" style="color:red;"></span><br>
         <label>Technology</label>
        <input type="text" id="pt" name="projectTechnology" placeholder="Project-technology"/>
        <span id="msg2" style="color:red;"></span><br>
         <label>Duration</label>
        <input type="text" id="pd" name="projectDuration" placeholder="Project-Duration"/>
        <span id="msg3" style="color:red;"></span><br>
         <label>Description</label>
        <input type="text" id="pdd" name="projectDescription" placeholder="Project-Description"/>
        <span id="msg4" style="color:red;"></span><br>
         <label>Bid Amount</label>
        <input type="text" id="pa" name="projectBidAmount" placeholder="Project-Bid-amount"/>
        <span id="msg5" style="color:red;"></span>
        <input type="submit" value="Add Project">
        
    </form>
    </div>
    </div>
    </div>
    </c:if>
</body>

<script type="text/javascript">
	function validate()
	{

		const pname=document.getElementById("pname").value.trim();
		const pt=document.getElementById("pt").value.trim();
		const pd=document.getElementById("pd").value.trim();
		const pdd=document.getElementById("pdd").value.trim();
		const pa=document.getElementById("pa").value.trim();

	if(pname=="" || pt=="" || pd=="" || pdd=="" || pa==""  )
		{
			if(pname=="")
				{
					document.getElementById("msg1").innerHTML=" Project Name cannot Empty";
				}
			if(pt=="")
			{
				document.getElementById("msg2").innerHTML="Please Enter Technology";
			}
			if(pd=="")
			{
				document.getElementById("msg3").innerHTML="Please Enter Duration";
			}
			if(pdd=="")
			{
				document.getElementById("msg4").innerHTML="Please Enter Discription";
			}
			if(pa=="")
			{
				document.getElementById("msg5").innerHTML="Please Mention Bid Amount";
			}
			return false;
		}
	else
		return true;
	}		

</script>
<script type = "text/javascript">
   function preventBack(){window.history.forward();}
    setTimeout("preventBack()", 0);
    window.onunload=function(){null};
</script>
</html>