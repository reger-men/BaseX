<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="styles.css" />

<title>BaseX Login</title>
</head>
<body>
<table class="menu" >
	<thead>
	<tr>
        <th><a href="login.jsp">Home</a></th>
        <th><a href="addMenu">Add Book</a></th>
        <th><a href="view.jsp">View Books</a></th>
        <th><a href="logout">Logout</a></th>
    </tr>
</table>
	
	
<table class="view" ><caption class="d">Login Page</caption></table>

<form action="LoginServlet" method="post" theme="simple">
<table class="input">
    <tr>
        <td>Username</td>
        <td><input type="text" name="username"></td>
   </tr>
   <tr>
       <td>Password</td>
       <td><input type="password" name="password"></td>     
   </tr>
   <tr>
       <td></td>   
       <td><input type="submit" value="Login"></td>  
   </tr>
   <tr>
        <td><a href="register.jsp">Sing Up</a></td>
        <td><a href="register.jsp">If you don't have account,click here</a></td>
   </tr>
   <tr>
       <td></td>   
       <td><actionerror cssClass="error"/>
		<actionmessage cssClass="message"/></td>  
   </tr>
</table>    
</form>
</body>
</html>




      