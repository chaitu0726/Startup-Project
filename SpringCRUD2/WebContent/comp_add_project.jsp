<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
   font-size: 13px;

}

.form .message a{
    color:#4CAF50;
    text-decoration:none ;
}
</style>
</head>
<body>

<div class="">

<div class="row bg-dark sticky-top " >
		<div class="col-9"></div>
		<div class="col-1" ><h5 style="height:60px; text-align: center; padding:15px"><a href="home_startup">Home</a></h5></div>
		<div class="col-1" ><h5 style="height:60px; text-align: center; padding:15px"><a href="logout">Logout</a></h5></div>
		<div class="col-1"></div>
	</div>

<div class="login-page">
		
    <div class="form">
    <form class="register-form" action="comProjectAdd" method="post">
        <div class="col-1"></div>
        <div class="col-10" style="font-size:30px;text-align: center;">Project Details</div> 
        <div class="col-1"><br></div> 
       
        <input type="text" name="projectName" placeholder="Project-Name"/>
        <input type="text" name="projectTechnology" placeholder="Project-technology"/>
        <input type="text" name="projectDuration" placeholder="Project-Duration"/>
        <input type="text" name="projectDescription" placeholder="Project-Description"/>
        <input type="text" name="projectBidAmount" placeholder="Project-Bid-amount"/>
        <input type="submit" value="Add Project">
        
    </form>
    </div>
    </div>
    </div>
</body>
</html>