<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><%@ include file="header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bag Shopping</title>
</head>
<body>
	<c:url value="/admin/UpdateForm" var="url" />
	<form:form action="${url}" method="post" modelAttribute="product"
		enctype="multipart/form-data">
		<br>
ID:<br>
		<form:input path="id" value="${prodList.id}" />
		<br>
Name:<br>
		<form:input path="productname" value="${prodList.productname}" />
		<br>
		<form:errors path="productname" cssStyle="color:red"></form:errors>
		<br>
Description:<br>
		<form:input path="description" value="${prodList.description}" />
		<br>
		<form:errors path="description" cssStyle="color:red"></form:errors>
		<br>
Quantity:<br>
		<form:input path="quantity" value="${prodList.quantity}" />
		<br>
		<form:errors path="quantity" cssStyle="color:red"></form:errors>
		<br>
Price:<br>
		<form:input path="price" value="${prodList.price}" />
		<br>
		<form:errors path="price" cssStyle="color:red"></form:errors>
		<br>

		Upload image <br>
		<form:input path="image" type="file"></form:input>
		<form:select path="category.cid">
			<c:forEach items="${categories}" var="c">
				<!-- c refers to an Object of type Category -->
				<form:option value="${c.cid }">${c.categoryname }</form:option>
			</c:forEach>
		</form:select>
		<input type="submit" value="Update Product" />
		<br>
	</form:form>
</body>
</html>