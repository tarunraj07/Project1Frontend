<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bag Shopping</title>
<%@ include file="header.jsp" %>
</head>
<body>
<table border="1" align="center">
<tr><th>Id</th><th>Name</th><th>Address</th><th>edit</th></tr>
<c:forEach items="${supList}" var="sup">
<tr>
<td>${sup.getSupplierId()}</td>
<td>${sup.getSupplierName()}</td>
<td>${sup.getSupplierAddr()}</td>
<c:url value="/all/getSupplier/${sup.supplierId}" var="display"/>
<c:url value="/admin/deleteSupplier/${sup.supplierId}" var="delete"/>
<c:url value="/admin/updateSupplier/${sup.supplierId}" var="info"/>
<td><a href="${display}">view</a> | <a href="${delete}">Delete</a> | <a href="${info}">Edit</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>