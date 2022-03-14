<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>

<link 
	type="text/css" 
	rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>

<meta charset="UTF-8">
<title>Customers List</title>
</head>
<body>

	<div id="wrapper">
		<div id ="header" >
		
			<h2>CRM - Customer Relationship Manager</h2>
		
		</div>
	</div>
	
	<div class="container" >
		
		<div class="content" >
		
		<button class="add-button" onclick="window.location.href = 'addCustomer'">Add Customer</button>
		
			<table>
			
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
				</tr>
				
				<c:forEach var="customer" items="${customers}">
					<tr>
						<td>${customer.firstName}</td>
						<td>${customer.lastName}</td>
						<td>${customer.email}</td>
					</tr>
				</c:forEach>
					
			</table>
			
		</div>
		
	</div>
	
</body>
</html>