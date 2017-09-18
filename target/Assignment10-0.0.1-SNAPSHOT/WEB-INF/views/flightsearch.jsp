<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<style>
div#flighthead h1 {
	position: relative;
	text-align: centre;
	left: 40%;
}

div#main {
	position: relative;
	left: 200px;
}

div#main label {
	font-weight: bold;
	font-size: 20px;
	color: #0579cf
}

div.mainContainer {
	margin-left: 500px;
	margin-top: 50px;
	margin-right:300px;
}
</style>
<link rel="stylesheet" href="/Assignment10/styles/jquery-ui.css" />
<link rel="stylesheet"
	href="/Assignment10/scripts/FooTable-2/css/footable.core.css">
<link rel="stylesheet"
	href="/Assignment10/scripts/FooTable-2/css/footable.metro.css">
<body>
	<div id="flighthead">
		<h1>Search Flights</h1>
	</div>

	<div id="main">

		<form:form action="processFlightSearch"
			modelAttribute="flightSearchForm">

			<table class="table" cellspacing="0" cellpadding="0">
				<col width="100">
				<col width="100">
				<col width="100">
				<col width="100">
				<col width="100">
				<col width="100">
				<col width="100">
				<col width="100">
				<col width="100">
				<tr>
					<td><FONT color="red"><form:errors path="departureLoc" /></FONT>
						<label><br>Departure Location:</label></td>
					<td></td>
					<td><FONT color="red"><form:errors path="arrivalLoc" /></FONT><label><br>Arrival
							Location:</label></td>
					<td></td>
					<td><label>Flight Class:</label></td>
					<td></td>
					<td><FONT color="red"><form:errors path="flightDate" /><label><br>Date
								of Journey:</label></td>
					<td></td>
					<td><label>Sort Result By:</label></td>


				</tr>
				<tr>
					<td><form:input path="departureLoc"
							placeholder="Departure Location" /></td>
					<td></td>
					<td><form:input path="arrivalLoc"
							placeholder="Arrival Location" /></td>
					<td></td>
					<td><form:select path="flightClass">
							<form:option value="E">Economy</form:option>
							<form:option value="B">Business</form:option>
						</form:select></td>
					<td></td>
					<td><form:input path="flightDate" class="date" id="validDate"
							placeholder="Date of Journey" /></td>
					<td></td>
					<td><form:select path="preference">
							<form:option value="fare">Fare</form:option>
							<form:option value="flightDur">Duration</form:option>
						</form:select></td>
				</tr>

			</table>
			<input type="submit" value="Submit" />
		</form:form>
	</div>
	<div class="mainContainer">
		<c:if test="${isSearch}">
			<c:if test="${not empty matchedFlight}">
				<table class="footable" border="1px" cellpadding="8px"
					data-page-size="6">
					<col width=200px>
					<col width=200px>
					<col width=200px>
					<col width=200px>
					<col width=200px>
					<col width=200px>
					<col width=200px>
					<col width=200px>
					<thead>
						<tr>
							<th>FLIGHT NO</th>
							<th>DEPARTURE LOC</th>
							<th>ARRIVAL LOC</th>
							<th>VALID TILL</th>
							<th>FLIGHT TIME</th>
							<th>FARE</th>
							<th>FLIGHT DUR</th>
							<th>CLASS AVAILABLE</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="flight" items="${matchedFlight}">
							<tr>
								<td>${flight.flightNo}</td>
								<td>${flight.depLoc}</td>
								<td>${flight.arrLoc }</td>
								<td><fmt:formatDate pattern="dd-MM-yyyy"
										value="${flight.validTill }" /></td>
								<td>${flight.flightTime}</td>
								<td>${flight.fare}</td>
								<td>${flight.flightDur }</td>
								<td>${flight.flightClass}</td>
							</tr>
						</c:forEach>
					</tbody>
					<tfoot class="hide-if-no-paging">
						<td colspan="8">
							<div class="pagination"></div>
						</td>
					</tfoot>
				</table>
			</c:if>
			<c:if test="${empty matchedFlight}">
				<div id="mainsecond">
					<h1>Sorry, no flight matched your search criteria, Please try
						again..</h1>
				</div>
			</c:if>
		</c:if>
	</div>

</body>
<script type="text/javascript" src="/Assignment10/scripts/jquery.js"></script>
<script type="text/javascript" src="/Assignment10/scripts/jquery-ui.js"></script>
<script src="/Assignment10/scripts/FooTable-2/js/footable.js"></script>
<script src="/Assignment10/scripts/FooTable-2/js/footable.paginate.js"></script>
<script>
	$(function() {
		$("#validDate").datepicker({
			dateFormat : 'dd-mm-yy'
		});
		$('.footable').footable();

	});
</script>
</html>