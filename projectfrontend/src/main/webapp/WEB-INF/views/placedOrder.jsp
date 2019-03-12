<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ include file="header.jsp" %>
</head>
<body>
<div class="panel">
<div class="panel panel-heading">Order Successfully Placed! <br>It Will Reach You with in 7 working days</div>
<div class="panel panel-body"><table class="table table-striped">
<thead id="thead">
<tr><th>Name</th><th>Quantity</th><th>Total Price</th>
</tr>
</thead>
<c:set var="totalPrice" value="0"></c:set>
<tbody id="tbody"><!-- cartItems is List<CartItem>, cartItem is CartItem obj -->

<c:forEach items="${cartItems }" var="cartItem">
<tr>
<td>${cartItem.product.productname }</td>
<td>${cartItem.quantity }</td>
<td>${cartItem.totalPrice }</td>
<c:set var="totalPrice" value="${totalPrice + cartItem.totalPrice }"></c:set>
<tr></c:forEach></tr>
<tr><td colspan=2>Total Price </td><td> ${totalPrice }</td></tr></tbody></table>
<div class="panel panel-info">
	<b>Billing Address:</b>
	<br>${user.getCustomer().getFirstname()} &nbsp; ${user.getCustomer().getLastname()}
	<br>${user.getCustomer().getBillingaddress().getApartmentnumber()}
	<br>${user.getCustomer().getBillingaddress().getStreetname()}
	<br>${user.getCustomer().getBillingaddress().getCity()}
	<br>${user.getCustomer().getBillingaddress().getState()}
	<br>${user.getCustomer().getBillingaddress().getCountry()}
	<br>${user.getCustomer().getBillingaddress().getZipcode()}
</div>
<span style="color:green; float:center; font-size:25">Thank You! Visit Again!</span>
</div>
</div>
</body>
</html>