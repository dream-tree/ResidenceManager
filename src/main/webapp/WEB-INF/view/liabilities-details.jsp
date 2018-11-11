<%@ page language="java" contentType="text/html; charset=ISO-8859-2" pageEncoding="ISO-8859-2" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
	<title>Owner Details</title>
	<meta charset="UTF-8">
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/detailed-owner-list.css" />
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
			
			<form:form action="search" method="POST">
			Search another owner: <input type="text" name="theSearchName" />
								  <input type="submit" value="Search" class="add-button" />
			</form:form>
			<br><br>
					
			<div id="section">
				<h3>Apartment Liabilities Info</h3>
			</div>	
					
			<table>
				<tr>
					<th>No.</th>
					<th class="apartment150">Calculation Date</th>
					<th class="apartment150">Amount of Liability</th>
					<th>Reduced</th>
				</tr>	
				<c:forEach var="liability" items="${liabilityList}" varStatus="status"> 	
					<tr>
					    <td>${status.count}</td>
						<td>${liability.chargeDate}</td>
						<td>${liability.singleLiabilityValue}</td>
						<td><c:if test="${liability.liabilityFlag==true}">YES</c:if>
						    <c:if test="${liability.liabilityFlag==false}">NO</c:if></td>
                </c:forEach>
				<tr>
					<th colspan="3">Total Current Amount of Liabilities</th>
					<td>${totalLiabilitiesValue}</td>
				</tr>
			</table>
		</div>
	</div>
	<p>
        <a href="${pageContext.request.contextPath}/residence/showDetails?ownerId=${ownerId}">Back to Owner Details</a>
    </p>
	<p>
		<a href="${pageContext.request.contextPath}/residence/list">Back to List of Owners</a>
	</p>
	<p>
		<a href="${pageContext.request.contextPath}/residence/start">Back to Main Page</a>
	</p>

	<div id="wrapper">
		<div id="bottom">
			<h5>@Copyright 2018 dream-tree</h5>
		</div>
	</div>

</body>
</html>