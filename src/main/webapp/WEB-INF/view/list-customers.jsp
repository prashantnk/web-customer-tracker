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
		
			
			<!-- add search bar -->
			
			<form action="search" method="get">
				<label>Customer Name : </label>
				<input type="text" name="name" value="${name}"/>
				<button type="submit" class="add-button">Search</button>
			</form>
			
			
			<table>
			
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				
				
				<c:forEach var="customer" items="${customers}">
					<!-- update URL -->
				
					<c:url var="updateURL" value="/customer/updateCustomer">
						<c:param name="customerId" value="${customer.id}"></c:param>
					</c:url>
					<c:url var="deleteURL" value="deleteCustomer">
						<c:param name="customerId" value="${customer.id}"></c:param>
					</c:url>
					<tr>
						<td>${customer.firstName}</td>
						<td>${customer.lastName}</td>
						<td>${customer.email}</td>
						<td>
							<a href="${updateURL}">Update</a> | 
							<a href="${deleteURL}" onclick="confirmWindow(event)">Delete</a> 
						</td>
					</tr>
				</c:forEach>
					
			</table>
			
			<div>
				<a href="list"> Back to Customers List </a>
			</div>
			
		</div>
		
	</div>
	
</body>

<script type="text/javascript">
	var confirmWindow = (e) => {
		if(window.confirm("Are you sure , you want to delete ? ")) return true; 
		else e.preventDefault();
	}
</script>

</html>