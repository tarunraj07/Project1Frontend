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
<c:url value="/admin/saveSupplier" var="uri"/>
<form:form action="${uri}">
Supplier Name:<form:input path="supplierName"/><br>
Supplier Address:<form:input path="supplierAddr"/><br>
<input type="submit" value="Save Supplier"/>
</form:form>
</body>
</html>