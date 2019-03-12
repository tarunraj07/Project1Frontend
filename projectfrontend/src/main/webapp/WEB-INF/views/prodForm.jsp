<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="header.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bag Shopping</title>
</head>
<body>
<c:url value="/admin/InsertProd" var="url"/>
<form:form action="${url}" method="post" modelAttribute="product"  enctype="multipart/form-data">
<table>
			<tr>
				<td><form:hidden path="id" /></td>
			</tr>
			<tr>
				<td><form:label path="productname">Product Name</form:label>
				</td>
				<td><form:input path="productname" />
				<form:errors path="productname" cssStyle="color:red"></form:errors>
				</td>
				
			<tr>
			<tr>
				<td><form:label path="description">Product Desription</form:label>
				</td>
				<td><form:textarea path="description" />
				<form:errors path="description" cssStyle="color:red"></form:errors>
				</td>
			<tr>
			<tr>
				<td><form:label path="price">price</form:label></td>
				<td><form:input path="price" />
				<form:errors path="price" cssStyle="color:red"></form:errors>
				</td>
			</tr>
			<tr>
				<td><form:label path="quantity">Quantity</form:label></td>
				<td><form:input path="quantity" />
				<form:errors path="quantity" cssStyle="color:red"></form:errors></td>
			</tr>
			<tr>
			<td>Select Category</td>
			<td>
		
			 <form:select path="category.cid">
			 <c:forEach items="${categories}" var="c" ><!-- c refers to an Object of type Category -->
			 <form:option value="${c.cid }">${c.categoryname }</form:option>
			 </c:forEach>
			 </form:select>
			</td>
			</tr>
			<tr>
			<td>Upload image </td>
			<td><form:input path="image" type="file"></form:input></td>
			</tr>
			<tr>
				<td><input type="submit" value="Add Product"></td>
			</tr>
		</table>
</form:form>
<%@ include file="allProdDisIn.jsp" %>
</body>
</html>