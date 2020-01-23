<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" href="style.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" 
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body align="center">
   <div class="login-page">
         <div class="form">
            <div class="col-3"></div>
            <div class="col-6" style="font-size:20px;">Login Form</div> 
            <div class="col-3"><br></div> 
           
             <form class="Login-form" action="login.htm" method="post">
                 <input type="text" name ="username"placeholder="Username"/>
                 <input type="password" name="password" placeholder="Password"/>
                 <input type="submit" class="bg-success" value="Login"/>
            </form>
                 
            <div class="row  mt-4" >
                <div class="col-1"></div>
                <div class="col-4 btn btn-primary"><a class="text-light" href="company_register.jsp"> Company  </a> </div> 
                <div class="col-1"></div>
                <div class="col-4 btn btn-primary"><a class="text-light"  href="home.jsp">  Startup </a></div>
            </div>
          
         </div>

     </div>

 
</body>
</html>