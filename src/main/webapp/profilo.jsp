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

	<!-- Show Unit Price Section -->
	<div class="product_section layout_padding">
		<div class="container">
			<h1 class="dailyfuelrate_text">Daily Fuel Rate</h1>
			<div class="product_section2">
				<div class="row">
					<div class="col-lg-4 col-sm-12">
						<h2 class="petrol_text">Octane 92</h2>
						<h1 class="internet_text">1300.0 MMK</h1>
						<div class="month_main clearfix text-center">
							<img src="images/petrol-pump.png">
						</div>
					</div>
					<div class="col-lg-4 col-sm-12">
						<h2 class="petrol_text">Octane 92</h2>
						<h1 class="internet_text">1300.0 MMK</h1>
						<div class="month_main clearfix text-center">
							<img src="images/petrol-pump.png">
						</div>
					</div>
					<div class="col-lg-4 col-sm-12 rounded-3">
						<h2 class="petrol_text">Premium Diesel</h2>
						<h1 class="internet_text">Fuel</h1>
						<div class="month_main clearfix text-center">
							<img src="images/petrol-pump.png">
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-4 col-sm-12"></div>
				<div class="col-lg-4 col-sm-12">
					<div class="seemore_main">
						<div class="see_more">
							<a href="petrol?mode=SHOP">Shop</a>
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-sm-12"></div>
			</div>
		</div>
	</div>
	<!-- Show Unit Price Section -->
	
</body>
</html>