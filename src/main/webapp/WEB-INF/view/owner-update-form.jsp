<%@ page language="java" contentType="text/html; charset=ISO-8859-2" pageEncoding="ISO-8859-2"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
	<title>Owner Update Form</title>
	<meta charset="UTF-8">
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-form.css"/>
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/header-footer-a.css"/>
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Residence Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Save Owner</h3>
		
		<form:form action="saveOwner" modelAttribute="owner" method="POST">	
			<form:hidden path="id"/>
			<form:hidden path="ownerMailingAddress.id"/>
			<table>
				<tbody>
					<tr>
						<td><label>First Name (*):</label></td>
						<td><form:input path="firstName"/></td>
						<td><label class="label1"><form:errors path="firstName" class="error"/></label></td>
					</tr>
					<tr>
						<td><label>Last Name (*):</label></td>
						<td><form:input path="lastName"/></td>
						<td><label class="label1"><form:errors path="lastName" class="error"/></label></td>
					</tr>
					<tr>
						<td><label>Date of Birth:</label></td>
						<td><form:input path="dateOfBirth"/></td>
						<td><label class="label1"><form:errors path="dateOfBirth" class="error"/></label></td>
					</tr>
					<tr>
						<td><label>Email:</label></td>
						<td><form:input path="email"/></td>
						<td><label class="label1"><form:errors path="email" class="error"/></label></td>
					</tr>
					<tr>
						<td><label>Phone Number:</label></td>
						<td><form:input path="phoneNumber"/></td>
						<td><label class="label1"><form:errors path="phoneNumber" class="error"/></label></td>
					</tr>
					<tr>
						<td><label>PESEL:</label></td>
						<td><form:input path="pesel"/></td>
						<td><label class="label1"><form:errors path="pesel" class="error"/></label></td>
					</tr>
					<tr>
						<td><label>Bank Account Number:</label></td>
						<td><form:input path="bankAccount"/></td>
						<td><label class="label1"><form:errors path="bankAccount" class="error"/></label></td>
					</tr>
					<tr>
						<td><label>(*) Required field</label></td>
					</tr>					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save"/></td>
					</tr>
				</tbody>
			</table>
		</form:form>	

		<div style="clear; both;"></div>
		
		<c:if test="${owner.id!=0}">
			<p><a href="${pageContext.request.contextPath}/residence/showDetails?ownerId=${owner.id}">Go to Owner Details</a></p>
		</c:if>
		<p><a href="${pageContext.request.contextPath}/residence/start">Back to Main Page</a></p>
	
	</div>

	<div id="wrapper">
		<div id="bottom">
			<h5>@Copyright 2018 dream-tree</h5>
		</div>
	</div>

</body>

</html>