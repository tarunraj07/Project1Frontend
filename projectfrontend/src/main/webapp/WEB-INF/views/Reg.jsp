<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="header.jsp" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bag Shopping</title>
</head>
<body>
<form:form action="register" method="post">
FullName:<form:input path="name"/><br>
UserName:<form:input path="username"/><br>
Email-Id:<form:input path="emailid"/><br>
Password:<form:input type="password" path="password"/><br>
Mobile Number:<form:input path="number"/><br>
<input type="submit" value="save">
</form:form>
</body>
</html>