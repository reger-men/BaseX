<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="styles.css" />

<title>BaseX Books</title>
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


<table class="view" >
	<caption class="d">ADDRESS LIST</caption>
	<thead>
	<tr>
		<th>isbn</th>
		<th>author</th>
		<th>title</th>
		<th>genre</th>
		<th>price</th>
		<th>publish_date</th>
		<th>description</th>
		<th>Modify</th>
		<th>Delete</th>
	</tr>
	</thead>
	<tbody>


	<s:iterator value="list">
		<tr>
               <td>0321392795<td>
               Gray, Simon
               <td>Data Structures in Java
               <td>Computer 
               <td>53.99<td>
               2006-11-13
               <td>From Abstract Data Types to the Java Collections Framework.

               <td><a href='modifyAddress?id=<s:property value="id"/>&first_name=<s:property value="first_name"/>&last_name=<s:property value="last_name"/>&gender=<s:property value="gender"/>&phone=<s:property value="phone"/>&email=<s:property value="email"/>&city_name=<s:property value="city_name"/>&zip_code=<s:property value="zip_code"/>&street=<s:property value="street"/>&street_no=<s:property value="street_no"/>&country_name=<s:property value="country_name"/>&alpha2=<s:property value="alpha2"/>&alpha3=<s:property value="alpha3"/>&sex_id=<s:property value="sex_id"/>&city_id=<s:property value="city_id"/>&country_id=<s:property value="country_id"/>&address_id=<s:property value="address_id"/>'>Modify</a></td>
              
               <td><a href='deleteAddress?id=<s:property value="id"/>'>Delete</a></td>
           </tr>
           
           <tr>
               <td><s:property value="isbn"/><td>
               <s:property value="author"/>
               <td><s:property value="title"/><td>
               <s:property value="genre"/>
               <td><s:property value="price"/><td>
               <s:property value="publish_date"/>
               <td><s:property value="description"/>

               <td><a href='modifyAddress?id=<s:property value="id"/>&first_name=<s:property value="first_name"/>&last_name=<s:property value="last_name"/>&gender=<s:property value="gender"/>&phone=<s:property value="phone"/>&email=<s:property value="email"/>&city_name=<s:property value="city_name"/>&zip_code=<s:property value="zip_code"/>&street=<s:property value="street"/>&street_no=<s:property value="street_no"/>&country_name=<s:property value="country_name"/>&alpha2=<s:property value="alpha2"/>&alpha3=<s:property value="alpha3"/>&sex_id=<s:property value="sex_id"/>&city_id=<s:property value="city_id"/>&country_id=<s:property value="country_id"/>&address_id=<s:property value="address_id"/>'>Modify</a></td>
              
               <td><a href='deleteAddress?id=<s:property value="id"/>'>Delete</a></td>
           </tr>
      </s:iterator>     
	</tbody>
</table> 
</body>
</html>