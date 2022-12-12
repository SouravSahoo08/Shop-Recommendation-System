<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration-Shop</title>
</head>
<body>

	<form:form action="homePage" modelAttribute="shop-registration-details">
		
		<table>
		
			<tbody>
			
				<tr>
					<td><label>Name</label></td>
					<td><form:input path="ownerName"/></td>
					
				</tr>
				
				<tr>
					<td><label>License No.</label></td>
					<td><form:input path="licenseNo"/></td>
				</tr>

				<tr>
					<td><label>Age</label></td>
					<td><form:input path="age"/></td>
				</tr>
				
				<tr>
					<td><label>Shop type</label></td>
					<td><form:input path="shopType"/></td>
				</tr>
				
				<tr>
					<td><label>Shop address</label></td>
					<td><form:input path="shopAddress"/></td>
				</tr>
				
				<tr><td>Login details</td></tr>
				
				<tr>
					<td><label>Username</label></td>
					<td><form:input path="sUsername"/></td>
				</tr>	

				<tr>
					<td><label>Password</label></td>
					<td><form:input path="sPwd"/></td>
				</tr>	
							
			</tbody>
			
		</table>
			
	</form:form>

</body>
</html>