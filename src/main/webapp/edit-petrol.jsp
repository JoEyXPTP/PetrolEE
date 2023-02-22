<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<c:import url="layout/header.jsp"></c:import>
<title>Edit And Update</title>
</head>
<body>
	<!-- Responsive Nav -->
	<c:import url="layout/nav.jsp"></c:import>

	<div class="container">
		<form action="petrol" method="post">
			<h2 class="text-center">Petrol Instock Edit</h2>

			<input type="hidden" name="mode" value="UPDATE"> <input
				type="hidden" name="id" value="${petrol.id }">
			<h3>
				<c:out value="ID : ${petrol.id}"></c:out>
			</h3>

			<div class="mb-3">
				<label for="petrol_type" class="form-label">Petrol Type</label> <input
					type="text" id="petrol_type" name="petrol_type"
					value="${petrol.petrol_type }" placeholder="Enter Type"
					class="form-control bg-warning" required="required" autofocus>
			</div>

			<div class="mb-3">
				<label for="quantity" class="form-label">Quantity</label> <input
					type="text" id="quantity" name="quantity"
					value="${petrol.quantity }" placeholder="Enter Quantity"
					class="form-control bg-warning" required="required" autofocus>
			</div>

			<div class="mb-3">
				<label for="unit_price" class="form-label">Unit Price</label> <input
					type="text" id="unit_price" name="unit_price"
					value="${petrol.unit_price }" placeholder="Enter Unit Price"
					class="form-control bg-warning" required="required" autofocus>
			</div>

			<div class="mb-3 form-check">
				<c:choose>
					<c:when test="${petrol.instock }">
						<input type="checkbox" class="form-check-input" id="instock"
							name="instock" value="true" checked="checked">
					</c:when>
					<c:otherwise>
						<input type="checkbox" class="form-check-input" id="instock"
							name="instock" value="true">
					</c:otherwise>
				</c:choose>
				<label class="form-check-label" for="qualify">Instock</label>
			</div>

			<button type="submit" class="btn btn-primary">Update</button>
			<button type="reset" class="btn btn-danger">Reset</button>
		</form>
	</div>


	<c:import url="layout/footer.jsp"></c:import>
</body>
</html>