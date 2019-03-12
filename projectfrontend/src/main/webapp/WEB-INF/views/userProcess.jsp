<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="header.jsp" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bag Shopping</title>
</head>
<body>
<table border="1" align="center">
<tr><th>Name</th><th>User Name</th><th>Email Id</th><th>Number</th></tr>
<c:forEach items="${up}" var="userProcess">
	<tr><td>${userProcess.getName()}</td>
	<td>${userProcess.getUsername()}</td>
	<td>${userProcess.getEmailid()}</td>
	<td>${userProcess.getNumber()}</td></tr>
</c:forEach>
</table></body>
</html>