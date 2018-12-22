<%@ page language="java" contentType="text/html; charset=ISO-8859-2"
	pageEncoding="ISO-8859-2"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Owner Details</title>
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/detailed-owner-list.css" />
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/header-footer-a.css" />
<title>Owners List</title>
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Residence Manager</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">

			<form:form action="search" method="POST">
			Search another owner: <input type="text" name="theSearchName" />
				<input type="submit" value="Search" class="add-button" />
			</form:form>
			<br> <br>

			<div id="section">
				<h3>E-mail Messages Sending Results</h3>
			</div>

			<h4>Messages were sent successfully.</h4>
			<br> <br> <br>
		</div>
	</div>
	<p>
		<a href="${pageContext.request.contextPath}/residence/start">Back
			to Main Page</a>
	</p>

	<div id="wrapper">
		<div id="bottom">
			<h5>@Copyright 2018 dream-tree</h5>
		</div>
	</div>

</body>
</html>