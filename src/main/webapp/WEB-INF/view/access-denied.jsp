<%@ page language="java" contentType="text/html; charset=ISO-8859-2" pageEncoding="ISO-8859-2"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
	<title>Access Denied</title>
	<meta charset="UTF-8">
</head>
<body>
	<h2>Access Denied. You are not authorized to access this resource.</h2>
	<hr>	
	<a href="${pageContext.request.contextPath}/">Back to Home Page</a>	
</body>
</html>