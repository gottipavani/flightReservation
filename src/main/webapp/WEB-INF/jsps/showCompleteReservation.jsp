<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Complete Reservation</title>
</head>
<body>
	<h2>Flight Details</h2>
	flightNumber: ${flight.flightNumber }
	<br> operatingAirlines: ${flight.operatingAirlines }
	<br> departureCity: ${flight.departureCity }
	<br> arrivalCity: ${flight.arrivalCity }
	<br> estimatedDepartureTime: ${flight.estimatedDepartureTime }
	<br>

	<h2>Enter Passenger Details</h2>
	<form action="confirmReservation" method="post">
		<pre>
First Name : <input type="text" name="firstName" /> 
last Name  : <input type="text" name="lastName" />
Middle Name: <input type="text" name="middleName" />
Email      : <input type="text" name="email" /> 
Phone      : <input type="text" name="phone" /> 
<input type="hidden" name="flightId" value="${flight.id }">


 <h2>Enter the payment details</h2>
 Name       : <input type="text" name="name" />
 Card Number: <input type="text" name="cardNumber" /><br />
 CVV code   : <input type="text" name="cvvCode" /><br />
 ExpiryDate : <input type="text" name="expiryDate" /><br />
 Amount     : <input type="text" name="amount" /><br />
 

<input type="Submit" value="Save">
</pre>
	</form>
</body>
</html>