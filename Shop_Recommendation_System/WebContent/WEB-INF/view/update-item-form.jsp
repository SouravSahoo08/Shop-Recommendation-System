<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Item modification</title>
</head>
<body>

	<h2>Update item.</h2>

	<form:form action="saveItem" modelAttribute="item" method="POST">

		<form:hidden path="itemId" />
		<table>

			<tbody>

				<tr>
					<td><label>Item type: </label></td>
					<td><form:input path="itemType" /></td>
					<%-- <form:errors path="itemName" cssClass="error" /> --%>
				</tr>

				<tr>
					<td><label>Item name: </label></td>
					<td><form:input path="itemName" /></td>
					<%-- <form:errors path="itemType" cssClass="error" /> --%>
				</tr>

				<tr>
					<td><label>Price: </label></td>
					<td><form:input path="price" /></td>
					<%-- <form:errors path="price" cssClass="error" /> --%>
				</tr>

				<tr>
					<td><label>Expiry Date: </label></td>
					<td><form:input path="expDate" /></td>
					<%-- <form:errors path="expDate" cssClass="error" /> --%>
				</tr>

				<tr>
					<td><label>Stock available: </label></td>
					<td><form:input path="stock" /></td>
					<!-- <form:errors path="expDate" cssClass="error" /> -->
				</tr>

				<tr>
					<td><label></label></td>
					<td><input type="submit" value="Update" /></td>
				</tr>

			</tbody>

		</table>

	</form:form>

	<p>
		<a href="items">Back to list</a>
	</p>
</body>
</html>