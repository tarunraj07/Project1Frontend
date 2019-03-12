<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><%@ include file="header.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bag Shopping</title>
</head>
<body>
<table border="1" align="center">
<tr><th>Image</th><th>Name</th><th>Description</th><th>Quantity</th><th>Price</th><!-- <th>Category</th> --><th>Modification</th><!-- <th>Cart</th> --></tr>
<c:forEach items="${prodList}" var="product">
<%-- <form:hidden path="${product.getId()}"/> --%>
<tr>
<td><a target="_blank"  href="http://localhost:9080/projectfrontend/resources/images/${product.getId()}.png"><img src="<c:url value='/resources/images/${product.getId()}.png'></c:url>" style='height:100px ; width:100px'/></a></td>
<td>${product.getProductname()}</td>
<td>${product.getDescription()}</td>
<td>${product.getQuantity()}</td>
<td>${product.getPrice()}</td>
<%-- <td>${cat.getgetCategoryname()}</td> --%>
<td>
<c:url value="/all/getProducts/${product.id}" var="urldis"></c:url>
<c:url value="/admin/deleteProduct/${product.id}" var="urldel"></c:url>
<c:url value="/admin/udpateProduct/${product.id}" var="urlupdate"></c:url>
<c:url value="/cart/addtocart/${product.id}" var="urlcart"></c:url>
<a href="${urldis}">Product Display</a> | <a href="${urldel}">Delete</a> | <a href="${urlupdate}">Edit</a></td>
<%-- <td><a href="${urlcart}">Add To Cart</a></td> --%>
</tr>
</c:forEach></table>
</body>
</html>