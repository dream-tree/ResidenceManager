<%@ page language="java" contentType="text/html; charset=ISO-8859-2" pageEncoding="ISO-8859-2" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>  
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
	<title>Welcome to the Residence Manager</title>
	<meta charset="UTF-8">
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main-page.css" />
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/header-footer-a.css" />
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Residence Manager</h2>
		</div>
	</div>
	<p>Welcome to Residence Manager application.</p>
	<p>You can search for a particular house owner using search bar below. Searching is possible by the first name,
	the last name as well as by the owner id. You are allowed to search for substrings too. Search is case 
	insensitive.</p>	
	<p>You can also check all house owners in the database and then update or delete chosen owner account by choosing
	Show All Owners tab.</p>
	<p>You can also add a new house owner and his apartment(s) data by choosing Add New Owner tab. You can set new
	rates for utilities and calculate rents for all apartments.</p>
	<p>Fetching bank data and sending messages features are not available yet. All other features available on the
	subsequent pages. Try one of the appropriate links below.</p>
	
	<div id="container">
		<div id="content">
			<table>
				<tr>
					<form:form action="search" method="POST">
						<td>
							<input type="text" name="theSearchName" class="search" maxlength="20"/>
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
						<form:form action="showRatesForm" method="GET">
							<input type="submit" value="Rates Config" class="button" />
						</form:form>	
					</td>
					<td>
						<form:form action="calculateRent" method="GET">
							<input type="submit" value="Calculate Rents" class="button"
								onclick="if(!(confirm('You are going to re-calculate rent for all owners in the database.\nIt may take a while.\nProceed with caution!\nConfirm yor decision.'))) return false;" />
						</form:form>	
					</td>
				</tr>
				<tr>
					<td>
						<form:form action="xxx" method="GET">
							<input type="submit" value="Fetch Bank Infos" class="button" />
						</form:form>	
					</td>
					<td>
						<form:form action="xxx" method="GET">
							<input type="submit" value="Send Messages" class="button" />
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