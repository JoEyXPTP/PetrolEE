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
		<form action="petrol" method="post">
			<h2 class="text-center text-primary">Adding Petrol</h2>

			<input type="hidden" name="mode" value="CREATE">

			<div class="mb-3">
				<label for="petrol_type" class="form-label">Petrol Type</label> <input
					type="text" id="petrol_type" name="petrol_type" placeholder="Enter Petrol Type"
					class="form-control" required="required" autofocus>
			</div>

			<div class="mb-3">
				<label for="quantity" class="form-label">Quantity</label> <input
					type="text" id="quantity" name="quantity" placeholder="Enter Quantity"
					class="form-control" required="required" autofocus>
			</div>

			<div class="mb-3">
				<label for="unit_price" class="form-label">Unit Price</label> <input
					type="text" id="unit_price" name="unit_price" placeholder="Enter Unit Price"
					class="form-control" required="required" autofocus>
			</div>

			<div class="mb-3 form-check">
				<input type="checkbox" class="form-check-input" id="instock"
					name="instock" value="true"> <label
					class="form-check-label" for="instock">Instock</label>
			</div>

			<button type="submit" class="btn btn-primary">Submit</button>
			<button type="reset" class="btn btn-danger">Reset</button>
		</form>
		<!-- /form -->
	</div>



	<!-- footer section -->
	<c:import url="layout/footer.jsp"></c:import>
</body>
</html>