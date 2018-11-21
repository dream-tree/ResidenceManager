<%@ page language="java" contentType="text/html; charset=ISO-8859-2" pageEncoding="ISO-8859-2" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
	<title>Owner Details</title>
	<meta charset="UTF-8">
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/header-footer-a.css" />
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/detailed-owner-list.css" />	
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
				<h3>Owner Info</h3>
			</div>	
					
			<table>
				<c:url var="updateOwnerLink" value="/residence/showFormForUpdate">
					<c:param name="ownerId" value="${owner.id}" />
				</c:url>
				<c:url var="deleteOwnerLink" value="/residence/deleteOwner">
					<c:param name="ownerId" value="${owner.id}" />
				</c:url>
					<c:url var="addApartmentLink" value="/apartment/addApartment">
					<c:param name="ownerId" value="${owner.id}" />
				</c:url>
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
				<tr>
					<td>${owner.id}</td>
					<td>${owner.firstName}</td>
					<td>${owner.lastName}</td>
					<td>${owner.dateOfBirth}</td>
					<td>${owner.email}</td>
					<td>${owner.phoneNumber}</td>
					<td>${owner.pesel}</td>
					<td>${owner.bankAccount}</td>
					<td class="link">
						<a href="${updateOwnerLink}">Update Owner</a><br>
						<a href="${deleteOwnerLink}"
						onclick="if(!(confirm('Are you sure you want to delete this house owner?'))) return false;">
						      Delete Owner</a><br>
						<a href="${addApartmentLink}">Add Apartment</a>
					</td>
				</tr>
			</table>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
				<c:url var="updateMailingAddressLink" value="/residence/updateMailingAddress">
					<c:param name="ownerId" value="${owner.id}" />
				</c:url>	 				
				<table class="address-table">
					<tr>
						<th class="address-header" colspan=2>Owner Mailing Address</th>
						<th class="action-header">Action</th>
					</tr>
					<tr>
						<th class="city-header">Postal Code/City</th>
						<td class="details-header">
							${ownerMailingAddress.postalCode}
							${ownerMailingAddress.city}
						</td>
						<td class="link" rowspan="2">
							<a href="${updateMailingAddressLink}">Add/Update</a>		
						</td>
					</tr>
					<tr>
						<th class="city-header">Street/Apartment Number</th>
						<td class="details-header">
							<c:if test="${ownerMailingAddress.street != null}">ul.</c:if>						
							${ownerMailingAddress.street}
							${ownerMailingAddress.apartmentNumber}
						</td>
					</tr>
				</table>
				<br>
		</div>
	</div>

	<div id="section">
		<h3>Apartment Info</h3>
	</div>

	<div id="container">
		<div id="content">
		
			<c:forEach var="tempApartment" items="${apartments}" varStatus="status">
				<c:url var="updateApartmentDetailsLink" value="/apartment/updateApartmentDetails">
					<c:param name="apartmentId" value="${tempApartment.id}" />
				</c:url>
				<c:url var="updateApartmentAddressLink" value="/apartment/updateApartmentAddress">
					<c:param name="apartmentId" value="${tempApartment.id}" />
					<c:param name="ownerId" value="${tempApartment.owner.id}" />
				</c:url>
				<c:url var="deleteApartmentLink" value="/apartment/deleteApartment">
					<c:param name="apartmentId" value="${tempApartment.id}" />
					<c:param name="ownerId" value="${tempApartment.owner.id}" />
				</c:url>
						
				<table class="address-table">
					<tr>
						<th class="address-header" colspan=2>Apartment #${status.count} Address</th>
						<th class="action-header">Action</th>
					</tr>
					<tr>
						<th class="city-header">Postal Code/City</th>
						<td class="details-header">
							${tempApartment.apartmentAddress.postalCode}
							${tempApartment.apartmentAddress.city}
						</td>
						<td class="link" rowspan="2">
							<a href="${updateApartmentAddressLink}">Update</a><br>
							<a href="${deleteApartmentLink}"
								onclick="if(!(confirm('Are you sure you want to delete this apartment (Address & Details sections)?'))) return false;">Delete</a>				
						</td>
					</tr>
					<tr>
						<th class="city-header">Street/Apartment Number</th>
						<td class="details-header">
							<c:if test="${tempApartmentAddress.street != null}">ul.</c:if>	
							${tempApartment.apartmentAddress.street}
							${tempApartment.apartmentAddress.apartmentNumber}
						</td>
					</tr>
				</table>
				<br>
				<table class="apartment-table">
					<tr>
						<th class="apartment-header" colspan="6">Apartment #${status.count} Details</th>
						<th class="action-header">Action</th>
					</tr>
					<tr>
						<th class="apartment100">Area</th>
						<td class="apartment100">${tempApartment.area}</td>
						<th class="apartment200">Number of Rooms</th>
						<td class="apartment100">${tempApartment.numberOfRooms}</td>
						<th class="apartment100" rowspan="7">Notes</th>
						<td class="apartment300" rowspan="7" >${tempApartment.notes}</td>
						<td class="apartment130" rowspan="7">
							<a href="${updateApartmentDetailsLink}">Update</a><br>
							<a href="${deleteApartmentLink}"
								onclick="if(!(confirm('Are you sure you want to delete this apartment
									 (Address & Details sections)?'))) return false;">Delete</a>
						</td>
					</tr>
					<tr>
						<th class="apartment100"></th>
						<td class="apartment100"></td>
						<th class="apartment200">Number of Occupants</th>
						<td class="apartment100">${tempApartment.numberOfOccupants}</td>
					</tr>	
					<tr>
						<th class="apartment100"></th>
						<td class="apartment100"></td>
						<th class="apartment200">Heater Consumption<br><small>(monthly forecast)</small></th>
						<td class="apartment100">${tempApartment.heaterConsumption}</td>
					</tr>		
					<tr>
						<th class="apartment100"></th>
						<td class="apartment100"></td>
						<th class="apartment200">Water Consumption<br><small>(monthly forecast)</small></th>
						<td class="apartment100">${tempApartment.waterConsumption}</td>
					</tr>			
					<tr>
						<th class="apartment100">Rent</th>
						<td class="apartment100">${tempApartment.rent.monthlyTotalRent}</td>
						<th class="apartment200">Liabilities</th>
						<td class="apartment100">${tempApartment.apartmentAccountBalance.totalLiabilitiesValue}</td>
					</tr>
					<tr>
						<td class="apartment100c" colspan="2">
							<a href="${pageContext.request.contextPath}
							/apartment/showRentDetails?apartmentId=${tempApartment.id}&ownerId=
                                        ${owner.id}">Show Rent Details</a> 
						</td>
						<td class="apartment200c" colspan="2">
							<a href="${pageContext.request.contextPath}
							/apartment/showApartmentLiabilities?apartmentId=${tempApartment.id}&ownerId=
                                        ${owner.id}">Show Liabilities</a>
						</td>
					</tr>
					<tr>
						<td class="apartment100c" colspan="4"><a
							href="${pageContext.request.contextPath}/apartment/showApartmentTransactions?apartmentId=
						              ${tempApartment.id}&ownerId=${owner.id}">Show Transactions</a>
						</td>
					</tr>
				</table>
				<br><br><br>
			</c:forEach>
		</div>
	</div>
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