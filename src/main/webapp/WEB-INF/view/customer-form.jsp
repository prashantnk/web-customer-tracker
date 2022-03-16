<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Customer</title>
<link 
	type="text/css" 
	rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
	
<link 
	type="text/css" 
	rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-customer-style.css"/>

</head>
<body>

	<div id="wrapper">
		<div id ="header" >
		
			<h2>CRM - Customer Relationship Manager</h2>
		
		</div>
	</div>
	
	<div class="container" >
		
		<div class="content" >
		
			<h2>Add Customer</h2>
			
			<table>
			
			<form:form action="saveCustomer" modelAttribute="customer" method="POST">
				
				<form:hidden path="id"/>
						
			<tr>
				<td> <label>First Name : </label> </td>
				<td> <form:input path="firstName" /></td>
			</tr>
			<tr>
				<td> <label>Last Name : </label> </td>
				<td> <form:input path="lastName" /></td>
			</tr>
			<tr>
				<td> <label>Email : </label> </td>
				<td> <form:input path="email" /></td>
			</tr>
			<tr>
				<td> <label></label> </td>
				<td> <input type="submit" class="save"/> </td>
			</tr>			
			</form:form>
			
			</table>
			
			<div>
			
<%-- 				<a href="${pageContext.request.contextPath}/customer/list"> Back to Customers List </a>
 --%>				<a href="list"> Back to Customers List </a>
			
			</div>
		
		</div>
	</div>

</body>
</html>