<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
	<h1>Home page</h1>
	
	<a href="login">Login</a> / <a href="shop-register">Register</a> 
	
	<hr>
	
	User: <security:authentication property="principal.username"/> <br>
	Role: <security:authentication property="principal.authorities"/>
	
	<br>
	<br>
	
	<security:authorize access="hasRole('MANAGER')">
	
		<p>
			<a href="${pageContext.request.contextPath}/owner/home/items">Owner page</a>
		</p>
	
	</security:authorize>

	<security:authorize access="hasRole('EMPLOYEE')">
	
		<p>
			<a href="${pageContext.request.contextPath}/user-2/home/items">customer page</a>
		</p>
	
	</security:authorize>
	
	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout" 
			   method="POST">
	
		<input type="submit" value="Logout" />
	
	</form:form>
</body>
</html>