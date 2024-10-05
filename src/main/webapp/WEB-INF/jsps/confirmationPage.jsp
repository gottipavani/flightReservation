<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ticket Details</title>
</head>
<body>
	<h2>Your ticket is confirmed</h2>
	Flight Details
	<table border=1>

		<tr>
			<td>Passenger FirstName</td>
			<td>${firstName}</td>
		</tr>

		<tr>
			<td>Passenger LastName</td>
			<td>${lastName}</td>
		</tr>

		<tr>
			<td>Passenger middleName</td>
			<td>${middleName}</td>
		</tr>

		<tr>
			<td>Email</td>
			<td>${email}</td>
		</tr>

		<tr>
			<td>MobileNumber</td>
			<td>${phone}</td>
		</tr>

		<tr>
			<td>Operating Airlines</td>
			<td>${operatingAirlines}</td>
		</tr>

		<tr>
			<td>DepartureCity</td>
			<td>${DepartureCity}</td>
		</tr>

		<tr>
			<td>Arrival City</td>
			<td>${arrivalCity}</td>
		</tr>

		<tr>
			<td>EstimatedDepartureTime</td>
			<td>${estimatedDepartureTime}</td>
		</tr>


	</table>
</body>
</html>