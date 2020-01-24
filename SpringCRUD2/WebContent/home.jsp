<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" href="style1.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" 
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
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
    

    
    <form class="register-form" action="add.htm" method="post">
 
        
        <input type="text" name="name" placeholder="Company Name"/>
        <input type="text" name="gstId" placeholder="gst-Id"/>
        <input type="text" name="contactNo" placeholder="Phone No"/>
        <input type="text" id="email" name="email" placeholder="Email-Id"/>
        <input type="text" name="discription" placeholder="Description"/>
        <input type="text" name="noOfEmployee" placeholder="No Of Employee"/>
		<input type="text" name="pan" placeholder="Enter PAN"/>
		<input type="text" name ="date" placeholder="Registarion Date in YYYY-MM-DD"/>
		<input type="password" name="password" placeholder="Enter Password"/>
        <input type="submit"/>
        <p class="message">Already Registered?<a href="login.jsp">Login</a></p>
    </form>
    </div>
    </div>
</body>
<script type="text/javascript">


</script>
</html>


