<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ include file="header.jsp" %>
</head>
<body>
<c:forEach items="${poh}" var="p">
<table class="table table-striped">
<thead id="thead">
<tr><th>Name</th><th>Quantity</th><th>Total Price</th><th>Order Date</th>
</tr>
</thead>
<c:set var="totalPrice" value="0"></c:set>
<tbody id="tbody"><!-- cartItems is List<CartItem>, cartItem is CartItem obj -->
<tr>
<td>${p.product.productname }</td>
<td>${p.quantity }</td>
<td>${p.totalPrice }</td>
<td>${p.placedOnDate}</td>
</tr>
<%-- <tr><td colspan=2 align="center">Total Price</td><td>${p.totalPrice}</td>
</tr> --%>
<hr>
</tbody>
</table>
</c:forEach>
</body>
</html>