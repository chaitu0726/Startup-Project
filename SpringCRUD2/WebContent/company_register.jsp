<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<script>
	function validate()
	{
		const user = document.getElementById("uid").value;
		const name = document.getElementById("name").value;
		const gst = document.getElementById("gstid").value;
		const phone = document.getElementById("phone").value;
		const email = document.getElementById("email").value;
		const company = document.getElementById("cid").value;
		const des = document.getElementById("dse").value;
		var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;


		if(user=="" || user==null)
			{
				alert("user_id cannot be blank");
				return false;
			}
		else if(name==""||name==null)
			{
			alert("name cannot be blank");
			return false;
			}
		else if(gst==""||gst==null)
		{
			alert("gst_id cannot be blank");
			return false;
		}
		else if(phone.length<10)
		{
			alert("invalid phone no");
			return false;
		}
		else if(filter.test(email.value))
		{
			alert("invalid email");
			return false;
		}
		else if(des==""||des==null)
		{
			alert("description cannot be blank");
			return false;
		}
		else if(cid==""||cid==null)
		{
			alert("company id  cannot be blank");
			return false;
		}
		
	}
	


</script>




<meta charset="ISO-8859-1">
<title>Registration Form For Company</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>

<div class="login-page">
    <div class="form">
    <form class="register-form" action="compReg.htm" method="post">
        <div class="col-3"></div>
        <div class="col-6" style="font-size:20px;">Registration Form For Company</div> 
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