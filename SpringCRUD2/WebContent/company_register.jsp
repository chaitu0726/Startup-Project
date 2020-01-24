<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
    
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
        <input type="text" placeholder="Name" name="compName"/>
        <input type="text" placeholder="gst-Id" name="gstId"/>
        <input type="text" placeholder="Phone No" name="contactNo"/>
        <input type="text" placeholder="Email-Id" name="email"/>
        <input type="text" placeholder="PAN" name="pan"/>
        <input type="text" placeholder="description" name="description"/>
        <input type="password" name ="password" placeholder="Password"/>
        <input type="submit" value="Register"/>
        <p class="message">Already Registered?<a href="index.jsp">Login</a></p>
    </form>
    </div>
    </div>
</body>
<script>
function validate()
	{
		const user = document.getElementById("uid").value;
		const name = document.getElementById("name").value;
		const gst = document.getElementById("gstid").value;
		const phone = document.getElementById("phone").value;
		const email = document.getElementById("email").value;
		const des = document.getElementById("dse").value;

if(user.trim()=="" || name.trim()=="" || gst.trim()==""  || email.trim()=="" || des.trim()=="")
{
	alert("Value/s cannot be blank");
	return false;
}
else
{
	alert("hiiii")
	return true;
}

}

</script>

</html>