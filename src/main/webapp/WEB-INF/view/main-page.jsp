<%@ page language="java" contentType="text/html; charset=ISO-8859-2" pageEncoding="ISO-8859-2"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>  
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main-page.css"/>
	<title>Welcome to the Residence Manager</title>
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Residence Manager</h2>
		</div>
	</div>
	<p>Welcome to Residence Manager application.</p>
	<p>You can search for a particular house owner using search bar below.
	You can search by the first name, the last name or the owner id. You are allowed to search for substrings too.</p>	
	<p>Search is case insensitive.</p>	
	<p>You can also check all house owners in the database and then update or delete chosen owner account
	by choosing Show All Owners tab.</p>
	<p>You can also add a new house owner, his apartment data, transactions and occupants by choosing Add New Owner tab.</p>
	<p>Try one of the appropriate link below.</p>
	
	
	<div id="container">
		<div id="content">		
			<table align="center">
				<tr>
					<form:form action="search" method="POST">
						<td>
							<input type="text" name="theSearchName" maxlength="20" style="width: 180px; height: 25px;" />
						</td>
						<td>
							<input type="submit" value="Search Owner" class="button" />
						</td>
					</form:form>
				</tr>
				<tr>
					<td>
						<form:form action="list" method="GET">
							<input type="submit" value="Show All Owners" class="button" />
						</form:form>	
					</td>
					<td>
						<form:form action="showFormForAdd" method="GET">
							<input type="submit" value="Add New Owner" class="button" />
						</form:form>	
					</td>
				</tr>
				<tr>
					<td>
						<form:form action="${pageContext.request.contextPath}/logout" method="POST">
							<input type="submit" value="Logout" class="button" />
						</form:form>
					</td>
				</tr>		
			</table>
			<br> <br>
			<hr>
			<p>
				User:
				<security:authentication property="principal.username" />
				<br>
				<br> Role(s):
				<security:authentication property="principal.authorities" />
			</p>
			<hr>
			<div id="wrapper">
				<div id="bottom">
					<h5>@Copyright 2018 dream-tree</h5>
				</div>
			</div>
		</div>
	</div>	
</body>
</html>