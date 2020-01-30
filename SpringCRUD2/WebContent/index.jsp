<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
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
   background-image:url('https://www.northeastern.edu/graduate/blog/wp-content/uploads/2017/10/Code-on-Computer-Hero.gif');
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
    background:white;
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
<body align="center">
   <div class="login-page">
         <div class="form">
         
             <form autocomplete="on" onsubmit="return validate()" action="login" method="post">
           		<label>Username</label>
                 <input type="text"  id ="uname" name ="username"  placeholder="Username"/>
                 <span id="ures" class="text-danger"></span><br>
                 <label>Password</label>
                 <input type="password" id="pass" name="password" placeholder="Password"/>
                 <span id="pres" class="text-danger"></span>
                 <button type="submit" class="bg-success">Login</button>
            </form>
                 
            <div class="row  mt-4" >
                <div class="col-1"></div>
                <div class="col-4 btn btn-primary"><a class="text-light" href="company_register.jsp"> Company  </a> </div> 
                <div class="col-1"></div>
                <div class="col-4 btn btn-primary"><a class="text-light"  href="home.jsp">  Startup </a></div>
            </div>
         </div>
     </div>   

<script type="text/javascript">
function validate()
{
var username = document.getElementById("uname");
var password = document.getElementById("pass");

	if(username.value.trim() =="" || password.value.trim() == "")
		{
		 if(username.value.trim() =="")
			{
				document.getElementById("ures").innerHTML = "Username cannot be blank";
			}	
		 if(password.value.trim() == "")
			{
				 document.getElementById("pres").innerHTML = "Password cannot be blank";
			}
		 return false;
		}
	else{
		return true;
	}
}
</script>
<script type="text/javascript">
$(document).ready(function(){
	$("#uname").change(function(){
		$.ajax({
			url : 'check_username',
			data : {username : $("#uname").val()},
			success : function(data){
				$("#ures").html(data);
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
</body>
</html>