<%@ page language="java" contentType="text/html; charset=ISO-8859-2" pageEncoding="ISO-8859-2"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link type = "text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/detailed-owner-list.css"/>
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
			</form:form><br><br>
			
			<div id="section">
				<h3><u>Owner info</u></h3>
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
					<td rowspan="3">${owner.id}</td>
					<td rowspan="3">${owner.firstName}</td>
					<td rowspan="3">${owner.lastName}</td>
					<td rowspan="3">${owner.dateOfBirth}</td>
					<td rowspan="3">${owner.email}</td>
					<td rowspan="3">${owner.phoneNumber}</td>
					<td rowspan="3">${owner.pesel}</td>
					<td rowspan="3">${owner.bankAccount}</td>
					<td bgcolor="#FFFACD" width="150px">
						<a href="${updateOwnerLink}">Update Owner</a> 
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFACD"><a href="${deleteOwnerLink}"
						onclick="if(!(confirm('Are you sure you want to delete this house owner?'))) return false;">Delete Owner</a></td>
				</tr>
				<tr>
					<td bgcolor="#FFFACD"><a href="${addApartmentLink}">Add Apartment</a></td>
				</tr>
			</table>
		</div>
	</div>
	
	
	<div id="container">
		<div id="content">
				<c:url var="updateMailingAddressLink" value="/apartment/updateMailingAddress">
					<c:param name="ownerId" value="${owner.id}" />
				</c:url>	 				
				<table width="575px">
					<tr>
						<th width="500px" colspan="2">Owner Mailing Address</th>
						<th width="50px">Action</th>
					</tr>
					<tr>
						<th width="275px" align="right">Postal Code/City</th>
						<td width="225px">${owner.ownerMailingAddress.postalCode}
							${owner.ownerMailingAddress.city}</td>
						<td rowspan="2" width="75px" bgcolor="#FFFACD">
							<a href="${updateMailingAddressLink}">Add/Update</a>		
						</td>
					</tr>
					<tr>
						<th width="275px" align="right">Street/Apartment Number</th>
						<td width="225px">ul. ${owner.ownerMailingAddress.street}
								${owner.ownerMailingAddress.apartmentNumber}</td>
					</tr>
				</table>
				<br>
		</div>
	</div>

	<div id="section">
		<h3><u>Apartments info</u></h3>
	</div>

	<div id="container">
		<div id="content">
			<c:forEach var="tempApartment" items="${apartments}" varStatus="status">
				<c:url var="updateApartmentDetailsLink" value="/apartment/updateApartmentDetails">
					<c:param name="apartmentId" value="${tempApartment.id}" />
				</c:url>
				<c:url var="updateApartmentAddressLink" value="/apartment/updateApartmentAddress">
					<c:param name="apartmentId" value="${tempApartment.id}" />
				</c:url>
				<c:url var="deleteApartmentLink" value="/apartment/deleteApartment">
					<c:param name="apartmentId" value="${tempApartment.id}" />
					<c:param name="ownerId" value="${tempApartment.owner.id}" />
				</c:url>
						
				<table width="575px">
					<tr>
						<th width="500px" colspan="2">Apartment #${status.count} Address</th>
						<th width="50px">Action</th>
					</tr>
					<tr>
						<th width="275px" align="right">Postal Code/City</th>
						<td width="225px">${tempApartment.apartmentAddress.postalCode}
							${tempApartment.apartmentAddress.city}</td>
						<td rowspan="2" width="75px" bgcolor="#FFFACD">
							<a href="${updateApartmentAddressLink}">Update</a>
							<a href="${deleteApartmentLink}"
								onclick="if(!(confirm('Are you sure you want to delete this apartment (Address & Details sections)?'))) return false;">Delete</a>				
						</td>
					</tr>
					<tr>
						<th width="275px" align="right">Street/Apartment Number</th>
						<td width="225px">ul. ${tempApartment.apartmentAddress.street}
								${tempApartment.apartmentAddress.apartmentNumber}</td>
					</tr>

				</table>
				<br>
				<table width="975px">
					<tr>
						<th width="900px" colspan="6">Apartment #${status.count} Details</th>
						<th>Action</th>
					</tr>
					<tr>
						<th width="100px">Area</th>
						<td width="100px">${tempApartment.area}</td>
						<th width="200px">Number of Rooms</th>
						<td width="100px">${tempApartment.numberOfRooms}</td>
						<th width="100px" rowspan="3">Notes</th>
						<td width="300px" rowspan="3" >${tempApartment.notes}</td>
						<td width="75px" rowspan="3" bgcolor="#FFFACD">
							<a href="${updateApartmentDetailsLink}">Update</a>
							<a href="${deleteApartmentLink}"
								onclick="if(!(confirm('Are you sure you want to delete this apartment (Address & Details sections)?'))) return false;">Delete</a>				

						</td>
					</tr>
					<tr>
						<th width="100px">Rent</th>
						<td width="100px">${tempApartment.rent}</td>
						<th width="200px">Liabilities</th>
						<td width="100px">${tempApartment.liabilities}</td>
					</tr>
					<tr>
						<td width="100px" colspan="2" bgcolor="#FFFACD">
						<!-- TODO link: copied from other place -->
							<a href="${updateApartmentLink}">Show Rent Details</a> 
						</td>
						<td width="200px" colspan="2" bgcolor="#FFFACD">
						<!-- TODO link: copied from other place -->
							<a href="${updateApartmentLink}">Show Liabilities Details</a> 
						</td>
					</tr>
					
				</table>
				<br><br><br>
			</c:forEach>
		</div>
	</div>
	<p>
		<a href="${pageContext.request.contextPath}/residence/list">Back to List</a>
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