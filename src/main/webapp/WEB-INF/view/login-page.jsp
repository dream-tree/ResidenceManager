<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<!doctype html>
<html lang="en">

<head>
	<title>Login Page</title>
	<meta charset="utf-8">
	<!-- <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"> -->
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main-page.css"/>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/login-page.css"/>

</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Residence Manager</h2>
		</div>
	</div>
	
	<!-- Login Form -->
	<form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST" class="login">
		<h1 class="login-title">Residence Manager Login</h1>
		<input type="text" name="username" placeholder="username" class="login-input">
		<input type="password" name="password" placeholder="password" class="login-input">
		<button type="submit" class="login-button">Login</button>
		
		<!-- Check for login error -->
		<c:if test="${param.error != null}">
			<div class="login-alert">
				Invalid username and/or password.</div>
		</c:if>
		
		<!-- Check for logout -->
		<c:if test="${param.logout != null}">
			<div class="login-alert">You have been logged out.</div>
		</c:if>
	</form:form>

	<div id="wrapper">
		<div id="bottom">
			<h5>@Copyright 2018 dream-tree</h5>
		</div>
	</div>

</body>
</html>