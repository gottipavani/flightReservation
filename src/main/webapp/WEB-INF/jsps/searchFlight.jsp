<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Flight</title>
</head>
<body>
<h2>Search Flight</h2>
<form action="findFlights" method="post"> 
from:<input type="text" name="from"> 
to:<input type="text" name="to">
 departure date<input type="text" name="departureDate">
 <input type="Submit" value="Search">
 </form>
</body>
</html>