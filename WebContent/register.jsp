<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="styles.css" />

<title>BaseX Register</title>
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

<table class="view" ><caption class="d">User Registration</caption></table>
         

<form action="RegisterUser" method="post" theme="simple">
<table class="input">
    <tr>
        <td>Username</td>
        <td><input type="text" key="uname" name="username" maxlength="10"/></td>
   </tr>
   <tr>
       <td>Password</td>
       <td><input type="password" key="pwd" name="password" maxlength="10"/></td>     
   </tr>
   <tr>
       <td>Email</td>   
       <td><input type="email" key="email" name="email" maxlength="10" /></td>  
   </tr>
   <tr>
       <td>Address</td>   
       <td><input type="text" key="address" name="address" maxlength="10"/></td>  
   </tr>
   <tr>
       <td></td>   
       <td><input type="submit" value="Register"></td>  
   </tr>
   <tr>
        <td><if test="hasActionMessages()"><a href="homeMenu">  Click Here </a> to start !
               </if></td>
        <td>Back to login page <a href="login.jsp">login</a></td>
   </tr>

</table>  
</form>      
</body>
</html>
        