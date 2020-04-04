<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

</head>
<body>
	<h2>Customer List</h2>
	<table>
		<tr>
			<th> Cus. Code </th>
			<th>Email</th>
			<th>Name</th>
			
			<th>Address</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="tab1" items="${data}">
		<tr>
		<td> 
			<form action="update1" method="post" modelAttribute="bean">
			<input type="text" value="${tab1.cid}" name="cid" readonly/>
		 </td>
		
		<td ><input type="text" value="${tab1.cemail}" name="cemail"/></td>
		
		<td ><input type="text" value="${tab1.cname}" name="cname"/></td>
		
		<td><input type="text" value="${tab1.caddress}" name="caddress"/></td>
		<td align="center"> <input type="submit" value="Update"/> 
		</form> </td>
		
		
		<td align="center"> 
			<form action="delete1" method="post" modelAttribute="bean">
			<input type="hidden" value="${tab1.cid}" name="cid"/>
			
			<input type="submit" value="Delete"/> 
			</form>
		</td>
		</tr>		
		</c:forEach>
	</table>
<br>
<h3 style="color:green;"> ${msg } </h3>
<h3> ${msg3 } </h3>
<h3> ${msg2 } </h3>
<h3> ${msg1 } </h3>
</body>
</html>