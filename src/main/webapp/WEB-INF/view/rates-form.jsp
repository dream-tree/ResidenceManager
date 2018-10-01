<%@ page language="java" contentType="text/html; charset=ISO-8859-2" pageEncoding="ISO-8859-2"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
	<title>Rates Form</title>
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
		<h3>Rates</h3>
		
		<form:form action="saveRatesForm" modelAttribute="rates" method="POST">	
			<form:hidden path="id"/>
			<table>
				<tbody>
					<tr>
						<td><label>Repair Fund Rate:</label></td>
						<td><form:input path="repairFundRate"/></td>
						<td><label class="label1"><form:errors path="repairFundRate" class="error"/></label></td>
					</tr>
					<tr>
						<td><label>Water Rate:</label></td>
						<td><form:input path="waterRate"/></td>
						<td><label class="label1"><form:errors path="waterRate" class="error"/></label></td>
					</tr>
					<tr>
						<td><label>Heating Rate:</label></td>
						<td><form:input path="heatingRate"/></td>
						<td><label class="label1"><form:errors path="heatingRate" class="error"/></label></td>
					</tr>
					<tr>
						<td><label>Waste Fee:</label></td>
						<td><form:input path="wasteFee"/></td>
						<td><label class="label1"><form:errors path="wasteFee" class="error"/></label></td>
					</tr>
					<tr>
						<td><label>TV Fee:</label></td>
						<td><form:input path="tvFee"/></td>
						<td><label class="label1"><form:errors path="tvFee" class="error"/></label></td>
					</tr>
					<tr>
						<td><label>All fields are required.</label></td>
					</tr>					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save"/></td>
					</tr>
				</tbody>
			</table>
		</form:form>	

		<div style="clear; both;"></div>
		
		<p><a href="${pageContext.request.contextPath}/residence/start">Back to Main Page</a></p>
	
	</div>

	<div id="wrapper">
		<div id="bottom">
			<h5>@Copyright 2018 dream-tree</h5>
		</div>
	</div>

</body>

</html>