<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><%@ include file="header.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bag Shopping</title>
</head>
<body>
<c:url value="/admin/saveCategory" var="url"/>
<form:form action="${url}">
	Category Name:<form:input path="categoryname"/><br>
	<input type="submit" value="Add Category"/>
</form:form>
</body>
</html>