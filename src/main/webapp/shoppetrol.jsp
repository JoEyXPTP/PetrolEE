<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<c:import url="layout/header.jsp"></c:import>
</head>
<body>
	<!-- Responsive Nav -->
	<c:import url="layout/nav.jsp"></c:import>

	<div class="container">
		<form action="invoice" method="post">
			<h2 class="text-center text-primary">Shop Petrol</h2>

			<input type="hidden" name="mode" value="CREATE">

			<div>
				<select name="petrol_type" class="custom-select">
					<option selected>Choose Petrol Type</option>
					<c:forEach var="petrol" items="${petrolList }">
						<option value=${petrol.id }>${petrol.petrol_type }</option>
					</c:forEach>
				</select>
			</div>

			<div class="mb-3">
			<label for="amount" class="form-label">Amount</label> 
				<div class="input-group">
					<input type="text" id="amount" name="amount" placeholder="Enter Amount"
						class="form-control" required="required" autofocus>
					<div class="input-group-append">
						<span class="input-group-text">Litre</span>
					</div>
				</div>
			</div>

			<button type="submit" class="btn btn-primary">Buy</button>
			<button type="reset" class="btn btn-danger">Reset</button>
		</form>
		<!-- /form -->
	</div>

</body>
</html>