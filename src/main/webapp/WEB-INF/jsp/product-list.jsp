<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product List</title>
</head>
<body>

	<div align="center">
		<table>
			<thead>
				<tr>
					<th width="20%">Id</th>
					<th width="20%">Name</th>
					<th width="20%">Quantity</th>
					<th width="20%">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="product" items="${products}" varStatus="status">
					<tr>
						<td>${product.id}</td>
						<td>${product.name}</td>
						<td>${product.quantity}</td>
						<td>
							<a href="delete?id=${product.id}">Delete</a> 
							<a href="update/${product.id}">Update</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>