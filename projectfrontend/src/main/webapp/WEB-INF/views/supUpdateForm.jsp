<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="header.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bag Shopping</title>
</head>
<body>
<c:url value="/admin/supUpdateForm" var="url"/>
<form:form action="${url}">
Id:<form:input type="text" path="supplierId" value="${command.supplierId}"/><br>
Name:<form:input type="text" path="supplierName" value="${command.supplierName}"/><br>
<%-- <form:textarea path="supplierAddr" row="30" col="25">${command.supplierAddr}</form:textarea> --%>
Address:<form:input type="text" path="supplierAddr" value="${command.supplierAddr}"/><br>
<input type="submit" value="Update Supplier"/>
</form:form>
</body>
</html>