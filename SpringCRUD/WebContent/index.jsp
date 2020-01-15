<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body align="center">
 <h1><%=request.getAttribute("msg") %> </h1>  
       <form method="post" action="save.htm">    
        	<table>    
         		<tr>    
          			<td>id : </td>   
          			<td><input name="id"  /></td>  
         		</tr>    
         		<tr>    
          			<td>Name :</td>    
          			<td><input name="name" /></td>  
         		</tr>   
         		<tr>    
          			<td>Age :</td>    
          			<td><input name="age" /></td>  
         		</tr>   
         		<tr>    
          			<td> </td>    
          			<td><input type="submit" value="Save" /></td>    
         		</tr>    
        	</table>    
       </form>    
</body>
</html>