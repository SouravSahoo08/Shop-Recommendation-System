<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
.login-panel {
	box-sizing: border-box;
	position: absolute;
	left: 65.67%;
	right: 5.42%;
	top: 17.01%;
	bottom: 21.79%;
	background: #FFFFFF;
	border: 2px solid #000000;
	border-radius: 48px;
}

.sign_in_title {
	
	left: 1036px;
	right: 23.81%;
	top: 205px;
	bottom: 74.54%;
	font-family: 'Inter';
	font-style: normal;
	font-weight: 400;
	font-size: 36px;
	line-height: 44px;
	color: #2400FF;
}

.username-label {
	position: absolute;
	left: 68.92%;
	right: 25.93%;
	top: 33.1%;
	bottom: 64.97%;
	font-family: 'Inter';
	font-style: normal;
	font-weight: 400;
	font-size: 16px;
	line-height: 19px;
	color: #000000;
	right: 25.93%;
	top: 33.1%;
	bottom: 64.97%;
	font-family: 'Inter';
	font-style: normal;
	font-weight: 400;
	font-size: 16px;
	line-height: 19px;
}

.user-input-box {
	/* Rectangle 5 */
	position: absolute;
	left: 68.52%;
	right: 8.6%;
	top: 35.54%;
	bottom: 59.27%;
	background: #D9D9D9;
	border-radius: 17px;
	/* Line 1 */
	position: absolute;
	left: 69.78%;
	right: 9.79%;
	top: 39.82%;
	bottom: 60.18%;
	border: 2px solid #3E3AF0;
	transform: rotate(-0.2deg);
	left: 68.52%;
	right: 8.6%;
	top: 35.54%;
	bottom: 59.27%;
	background: #D9D9D9;
	border-radius: 17px;
	/* Line 1 */
	position: absolute;
	left: 69.78%;
	right: 9.79%;
	top: 39.82%;
	bottom: 60.18%;
	border: 2px solid #3E3AF0;
}

.username-text {
	position: absolute;
	left: 70.11%;
	right: 24.6%;
	top: 36.86%;
	bottom: 60.69%;
	font-family: 'Inter';
	font-style: italic;
	font-weight: 700;
	font-size: 20px;
	line-height: 24px;
	color: #000000;
	right: 24.6%;
	top: 36.86%;
	bottom: 60.69%;
	font-family: 'Inter';
	font-style: italic;
	font-weight: 700;
	font-size: 20px;
	line-height: 24px;
}

.password-lable {
	position: absolute;
	left: 11.21%;
	right: 71.85%;
	top: 46.39%;
	bottom: 50.18%;
	font-family: 'Inter';
	font-style: normal;
	font-weight: 400;
	font-size: 16px;
	line-height: 19px;
	color: #000000;
}
</style>

</head>
<body>

	<div id="loginbox" class="login-panel">

		<div class="sign_in_title">Sign In</div>

		<form:form
			action="${pageContext.request.contextPath}/authenticateTheUser"
			method="POST">

			<!-- username -->
			<p class="username-label">Username</p>
			<div class="user-input-box">
				<input type="text" name="username" placeholder="username"
					class="username-text">
			</div>

		</form:form>

	</div>


</body>
</html>




















