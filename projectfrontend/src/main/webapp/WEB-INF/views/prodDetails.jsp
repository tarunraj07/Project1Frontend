<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><%@ include file="header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bag Shopping</title>

    <!-- Custom styles for this template -->
    <link href="<c:url value="/resources/product/css/portfolio-item.css"/>" rel="stylesheet">
    <script src="<c:url value="/resources/product/vendor/jquery/jquery.min.js"/>"></script>
    <script src="<c:url value="/resources/product/vendor/bootstrap/js/bootstrap.bundle.min.js"/>"></script>
</head>
<body>
	<c:url value="/cart/addtocart" var="url" />
	<form action="${url}">
		<h1 class="my-4">
			Product Details <small></small>
		</h1>
		<input type="hidden" value="${prodlist.id}" name="productId">

		<!-- Portfolio Item Row -->
		<div class="row">

			<div class="col-md-8">
				<img class="img-fluid"
					src="<c:url value='/resources/images/${prodlist.id}.png'></c:url>"
					style="height: 500px; width: 750px" alt="">
			</div>
			<div class="col-md-4">
				<h3 class="my-3">${prodlist.productname}</h3>
				<p>Description: ${prodlist.description}</p>
				<h3 class="my-3">Quantity:${prodlist.quantity}</h3>
				<h3 class="my-3">Price:${prodlist.price}</h3>
				
Quantity:<input type="number" min=1 max=${prodlist.quantity} name="requestedQuantity" value="1" required>
										<input type="submit" value="Add To Cart" />
				
			</div>

		</div>

	</form>
</body>
</html>