<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

</head>
<body>

 <div class="row bg-dark sticky-top" style="height: 50px">
<div class="col-5"></div>
<div class="col-4 text-light" style="font-size: 30px">Registration for Startup </div>
<div class="col-2"></div>
</div>
<div class="login-page">
    <div class="form">
    

    
    <form name="form1" class="register-form" onsubmit="return validate()" action="add" method="post">
 
        
        <input type="text" id="name" name="name" placeholder="Company Name"/>
        	<span id="avail1" style="color:red"></span>
        <input type="text" id="gstid" name="gstId" placeholder="gst-Id"/>
        	<span id="avail2" style="color:red"></span>
        <input type="text" id="contact" name="contactNo" placeholder="Phone No"/>
        	<span id="avail3" style="color:red"></span>
        <input type="text" id="email"  name="email" placeholder="Email-Id"/>
        <span id="avail4" style="color:green"></span>
        <input type="text" id="desc" name="discription" placeholder="Description"/>
        	<span id="avail5" style="color:red"></span>
        <input type="text" id="noe" name="noOfEmployee" placeholder="No Of Employee"/>
        	<span id="avail6" style="color:red"></span>
		<input type="text" id="pan" name="pan" placeholder="Enter PAN"/>
			<span id="avail7" style="color:red"></span>
		<input type="password" id="pass" name="password" placeholder="Enter Password"/>
        	<span id="avail9" style="color:red"></span>
        <input type="submit" onclick=" return ValidateEmail(document.form1.email)" />
        <p class="message">Already Registered?<a href="index.jsp">Login</a></p>
    </form>
    </div>
    </div>
</body>
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
<script>
function validate()
{
var username = document.getElementById("email").value.trim();
var id1 = document.getElementById("name").value.trim();
var id2 = document.getElementById("gstid").value.trim();
var id3 = document.getElementById("contact").value.trim();
var id4 = document.getElementById("desc").value.trim();
var id5 = document.getElementById("noe").value.trim();
var id6 = document.getElementById("pan").value.trim();
var id8 = document.getElementById("pass").value.trim();

if(id1=="" || id2=="" || id3=="" || id4=="" || id5=="" || id6=="" || id8=="" ||username==""){
	if(username =="")
		{
		document.getElementById("avail4").innerHTML="email cannot blank";
		
		}
	if(id1 =="")
	{
	document.getElementById("avail1").innerHTML="Name cannot Empty";
	}
	if(id2 =="")
	{
	document.getElementById("avail2").innerHTML="Gst cannot Empty";
	
	}
	if(id3 =="")
	{
	document.getElementById("avail3").innerHTML="contact cannot blank";
	
	}
	if(id4 =="")
	{
	document.getElementById("avail5").innerHTML="desc cannot blank";
	
	}
	if(id5 =="")
	{
	document.getElementById("avail6").innerHTML="No Of Emplyee cannot blank";
	
	}
	if(id6 =="")
	{
	document.getElementById("avail7").innerHTML="pan cannot blank";
	
	}
	if(id8 =="")
	{
	document.getElementById("avail9").innerHTML="password cannot blank";
	
	}
	return false;
}
	else{
		return true;
	}
}
</script>
<script type = "text/javascript">
   function preventBack(){window.history.forward();}
    setTimeout("preventBack()", 0);
    window.onunload=function(){null};
</script>
<script type="text/javascript">
$(document).ready(function(){
	$("#gstid").change(function(){
		$.ajax({
			url : 'check_gstS',
			data : {gst : $("#gstid").val()},
			success : function(data){
				$("#avail2").html(data);
			}
		});
		
	});
});
</script>
<script type="text/javascript">
$(document).ready(function(){
	$("#pan").change(function(){
		$.ajax({
			url : 'check_panS',
			data : {pan: $("#pan").val()},
			success : function(data){
				$("#avail7").html(data);
			}
		});
		
	});
});
</script>
<script type="text/javascript">
function ValidateEmail(inputText)
{
var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
if(inputText.value.match(mailformat))
{
document.form1.text1.focus();
return true;
}
else
{
alert("You have entered an invalid email address!");
document.form1.text1.focus();
return false;
}
}
</script>
</html>


