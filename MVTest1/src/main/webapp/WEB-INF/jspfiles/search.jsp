<head>
<style>
body {font-family: Arial, Helvetica, sans-serif;
	background-image:url('images/adr.jpg');
	background-repeat: no-repeat;
	background-size: 840px 700px;
}
h2 {

  color: white;
}
th {

  color: white;
}
td {

  color: white;
}
</style>
</head>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<html>
<body>
	
	
	<fieldset>
	 <legend><h2 style="color:blue"> Search For A Customer</h2></legend>
	<hr>
    <form:form action="search1" method="post" modelAttribute="bean">
    <font color="white">  <form:input path="cname" placeholder="Search.."/> &nbsp;&nbsp;
      <input type="submit" value="Search">
      </form:form>
    <br><br>
	<table class="w3-table-all w3-centered">
		<tr>
		<th>Customer Name | </th>
		<th>Customer Email | </th>
		<th>Employee Address</th>

		</tr>

		<c:forEach var="tab" items= "${li }">
		<tr>
		<td>  ${ tab.cname } </td>
		<td>${ tab.cemail }  </td>
		<td> ${ tab.caddress } </td>
		</tr>
		
		</c:forEach>

	</table>
	
	</fieldset>




	<h2>${msg1 }</h2>

</body>
</html>