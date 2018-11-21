<%@ page language="java" contentType="text/html; charset=ISO-8859-2" pageEncoding="ISO-8859-2" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
	<title>List of Owners</title>
	<meta charset="UTF-8">	
 		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/owner-list.css" />
 		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/header-footer-a.css" />
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
			<input type="button" value="Add Owner" 
				onclick="window.location.href='showFormForAdd'; return false;"
				class="add-button"/>
			<form:form action="search" method="POST">
			Search owner:<input type="text" name="theSearchName" />
						 <input type="submit" value="Search" class="add-button" />
			</form:form>	
			<table>
				<tr>
					<th>Owner ID</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Date of Birth</th>
					<th>Email</th>
					<th>Phone Number</th>
					<th>PESEL</th>
					<th>Bank Account Number</th>
					<th>Action</th>
				</tr>
				<c:forEach var="tempOwner" items="${owners}">
					<c:url var="updateLink" value="/residence/showFormForUpdate">
						<c:param name="ownerId" value="${tempOwner.id}"/>
					</c:url>
					<c:url var="deleteLink" value="/residence/deleteOwner">
						<c:param name="ownerId" value="${tempOwner.id}"/>
					</c:url>
					<c:url var="detailsLink" value="/residence/showDetails">
						<c:param name="ownerId" value="${tempOwner.id}"/>
					</c:url>				
					<tr>
						<td>${tempOwner.id}</td>
						<td>${tempOwner.firstName}</td>
						<td>${tempOwner.lastName}</td>
						<td>${tempOwner.dateOfBirth}</td>
						<td>${tempOwner.email}</td>
						<td>${tempOwner.phoneNumber}</td>
						<td>${tempOwner.pesel}</td>
						<td>${tempOwner.bankAccount}</td>
						<td> <a href="${updateLink}">Update</a>
							 | 
							 <a href="${deleteLink}"
							    onclick="if(!(confirm('Are you sure you want to delete this house owner?'))) 
								    return false;">Delete</a>
							 |
							 <a href="${detailsLink}">Details</a>
						</td>
					</tr>		
				</c:forEach>		
			</table>
		</div>
		
		<p>
			<a href="${pageContext.request.contextPath}/residence/start">Back to Main Page</a>
		</p>
	</div>
	
	<div id="wrapper">
		<div id="bottom">
			<h5>@Copyright 2018 dream-tree</h5>
		</div>
	</div>

</body>
</html>