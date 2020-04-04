<head>
<style>
body {font-family: Arial, Helvetica, sans-serif;
	background-image:url('images/dav.jpg');
	background-repeat: no-repeat;
	background-size: 840px 690px;
}
</style>
</head>
<body bgcolor="grey">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page isELIgnored="false"%>

	<center>
	<form:form action="save" method="post" modelAttribute="bean">
	 <fieldset>
	 <legend><h2 style="color:white;">Register Here !!</h2></legend>
	<font color="white">Enter Name: <form:input path="cname" /><br/><br/>
	Enter Email: <form:input path="cemail" type="email"/>
		<br /><br/>
		Enter Password: <form:input path="cpass" type="password" />
		<br /><br/>
		Select Gender: <form:radiobutton path="gender" value="Male" />Male&nbsp;
					   <form:radiobutton path="gender" value="Female" />Female&nbsp;<br /><br/>
		

		Address: <form:input path="caddress" type="text"/>
		<br/><br/></font>

		<input type="submit" value="Save It."><input type="submit" formaction="/jspfiles/index.jsp" value="Back">

	</fieldset>
	</form:form></center>
	
	<h2> ${msg }  </h2>
	</body>