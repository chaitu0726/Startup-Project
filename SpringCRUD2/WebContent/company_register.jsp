<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.4.1.min.js"></script>
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
<div class="row bg-dark sticky-top" style="height: 50px">
<div class="col-5"></div>
<div class="col-4 text-light" style="font-size: 30px">Registration for Company</div>
<div class="col-2"></div>
</div>

<div class="login-page">
    <div class="form">
    
    <form class="register-form" onsubmit="return validate()" action="compReg" method="post">
        <div class="col-3"></div>
        <div class="col-3"><br></div> 
        <input type="text" id="id1" placeholder="Name" name="compName"/>
        <span id="msg1" style="color:red;"></span>
        <input type="text" id="id2" placeholder="gst-Id" name="gstId"/>
         <span id="msg2" style="color:red;"></span>
        <input type="text"  id="id3" placeholder="Phone No" name="contactNo"/>
         <span id="msg3" style="color:red;"></span>
        <input type="text" id="email" placeholder="Email-Id" name="email"/>
        <span id="avail4" style="color:blue;"></span>
        <input type="text" id="id5" placeholder="PAN" name="pan"/>
         <span id="msg5" style="color:red;"></span>
        <input type="text" id="id6" placeholder="description" name="description"/>
         <span id="msg6" style="color:red;"></span>
        <input type="password" id="id7" name ="password" placeholder="Password"/>
         <span id="msg7" style="color:red;"></span>
        <input type="submit" value="Register"/>
        <p class="message">Already Registered?<a href="index.jsp">Login</a></p>
    </form>
    </div>
    </div>
</body>
<script>
function validate()
{
	var id1 = document.getElementById("id1").value.trim();
	var id2 = document.getElementById("id2").value.trim();
	var id3 = document.getElementById("id3").value.trim();
	var id5 = document.getElementById("id5").value.trim();
	var id6 = document.getElementById("id6").value.trim();
	var id7 = document.getElementById("id7").value.trim();
	var email = document.getElementById("email").value.trim();

if(id1=="" || id2=="" || id3=="" || id4=="" || id5=="" || id6=="" || id7=="" || email=="")
{
	
	if(id1 =="")
	{
	document.getElementById("msg1").innerHTML="Name cannot Empty";
	}
	if(id2 =="")
	{
	document.getElementById("msg2").innerHTML="Gst cannot Empty";
	
	}
	if(id3 =="")
	{
	document.getElementById("msg3").innerHTML="Contact cannot empty";
	
	}
	
	if(id5 =="")
	{
	document.getElementById("msg5").innerHTML="Please Add PAN details";
	
	}
	if(id6 =="")
	{
	document.getElementById("msg6").innerHTML="please Fill Description";
	
	}
	if(id7 =="")
	{
	document.getElementById("msg7").innerHTML="must enter password";
	
	}
	if(email=="")
		{
		document.getElementById("avail4").innerHTML = "Email Cannot be Blank";
		}

	return false;
}
else
{
	return true;
}

}

</script>
<script type="text/javascript">
$(document).ready(function(){
	$("#email").change(function(){
		$.ajax({
			url : 'check_avail',
			data : {username : $("#email").val()},
			success : function(data){
				$("#avail4").html(data);
			}
		});
		
	});
});
</script>
<script type = "text/javascript">
   function preventBack(){window.history.forward();}
    setTimeout("preventBack()", 0);
    window.onunload=function(){null};
</script>
</html>