<%@ page language="java" contentType="text/html; charset=ISO-8859-2" pageEncoding="ISO-8859-2"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Save Owner</title>
	<link type="text/css" rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css" />
	<link type="text/css" rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/add-apartment-style.css" />
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Residence Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Save Apartment Address</h3>
		
		<form:form action="saveOwnerMailingAddress" modelAttribute="ownerMailingAddress" method="POST">			
			<form:hidden path="id"/>
			<form:hidden path="owner.id"/>
			<table>
				<tbody>
					<tr>
						<td><label>Postal Code:</label></td>
						<td><form:input path="postalCode"/></td>
						<td><label class=label1><form:errors path="postalCode" class="error"/></label></td>
					</tr>
					<tr>
						<td><label>City:</label></td>
						<td><form:input path="city"/></td>
						<td><label class=label1><form:errors path="city" class="error"/></label></td>
					</tr>
					<tr>
						<td><label>Street:</label></td>
						<td><form:input path="street"/></td>
						<td><label class=label1><form:errors path="street" class="error"/></label></td>
					</tr>
					<tr>
						<td><label>Apartment Number:</label></td>
						<td><form:input path="apartmentNumber"/></td>
						<td><label class=label1><form:errors path="apartmentNumber" class="error"/></label></td>
					</tr>			
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save"/></td>
					</tr>
				</tbody>
			</table>
		</form:form>	

		<div style="clear; both;"></div>
		
		<p><a href="${pageContext.request.contextPath}/residence/showDetails?ownerId=${ownerMailingAddress.owner.id}">Back to Owner Details</a></p>		
		<p><a href="${pageContext.request.contextPath}/residence/start">Back to Main Page</a></p>
	
	</div>

</body>

</html>