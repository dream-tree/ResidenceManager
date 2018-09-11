<%@ page language="java" contentType="text/html; charset=ISO-8859-2" pageEncoding="ISO-8859-2"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
	<title>Apartment Update Form</title>
	<meta charset="UTF-8">
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-form.css" />
	<link type = "text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/header-footer-a.css"/>
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Residence Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Save Apartment</h3>		
		<form:form action="saveApartmentDetails" modelAttribute="apartment" method="POST">			
			<form:hidden path="id"/>
			<form:hidden path="rent"/>
			<form:hidden path="liabilities"/>
			<form:hidden path="apartmentAddress.id"/>	
			<form:hidden path="owner.id"/>
			<table>
				<tbody>
					<tr>
						<td><label>Area:</label></td>
						<td><form:input path="area"/></td>
						<td><label class=label1><form:errors path="area" class="error"/></label></td>
					</tr>
					<tr>
						<td><label>Number of Rooms:</label></td>
						<td><form:input path="numberOfRooms"/></td>
						<td><label class=label1><form:errors path="numberOfRooms" class="error"/></label></td>
					</tr>
					<tr>
						<td><label>Notes:</label></td>
						<td><form:input path="notes"/></td>
						<td><label class=label1><form:errors path="notes" class="error"/></label></td>
					</tr>				
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save"/></td>
					</tr>
				</tbody>
			</table>
		</form:form>	

		<div style="clear; both;"></div>
		
		<p><a href="${pageContext.request.contextPath}/residence/showDetails?ownerId=${apartment.owner.id}">Back to Owner Detail</a></p>		
		<p><a href="${pageContext.request.contextPath}/residence/start">Back to Main Page</a></p>
	
	</div>

	<div id="wrapper">
		<div id="bottom">
			<h5>@Copyright 2018 dream-tree</h5>
		</div>
	</div>

</body>

</html>