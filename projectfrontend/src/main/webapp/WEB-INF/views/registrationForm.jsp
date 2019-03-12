<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="header.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bag Shopping</title>
<link rel="stylesheet" href="<c:url value='/resources/css/registration.css'></c:url>">
</head>
<body>
<div class="container">
<c:url value="/all/register" var="url"></c:url>
<form:form modelAttribute="customer" action="${url }" id="form">

<form:hidden path="id"/>

<form:label path="firstname">Firstname</form:label>
<form:input path="firstname" id="firstname"/>


<form:label path="lastname">Lastname</form:label>
<form:input path="lastname" id="lastname"/>


<form:label path="phonenumber">Phonenumber</form:label>
<form:input path="phonenumber" id="phonenumber"/>

<hr>
<b>Login Details</b><br>
<form:label path="user.email">Email</form:label>
<form:input path="user.email" id="user.email" type="text"/>

<form:label path="user.password">password</form:label>
<form:input path="user.password" id="user.password" type="password"/>

<hr>
<b>Billing Address</b><br>

<form:label path="billingaddress.apartmentnumber">  Apartmentnumber</form:label>
<form:input path="billingaddress.apartmentnumber" id="billingaddress.apartmentnumber"/>

<form:label path="billingaddress.streetname">  streetname</form:label>
<form:input path="billingaddress.streetname" id="billingaddress.streetname"/>

<form:label path="billingaddress.city">  city</form:label>
<form:input path="billingaddress.city" id="billingaddress.city"/>

<form:label path="billingaddress.state">  state</form:label>
<form:input path="billingaddress.state" id="billingaddress.state"/>

<form:label path="billingaddress.country">  country</form:label>
<form:input path="billingaddress.country" id="billingaddress.country"/>

<form:label path="billingaddress.zipcode">  Zipcode</form:label>
<form:input path="billingaddress.zipcode" id="billingaddress.zipcode"/>
<hr>
<b>Shipping address</b><br>

<form:label path="shippingaddress.apartmentnumber">  Apartmentnumber</form:label>
<form:input path="shippingaddress.apartmentnumber" id="shippingaddress.apartmentnumber"/>

<form:label path="shippingaddress.streetname">  streetname</form:label>
<form:input path="shippingaddress.streetname" id="streetname"/>

<form:label path="shippingaddress.city">  city</form:label>
<form:input path="shippingaddress.city" id="shippingaddress.city"/>

<form:label path="shippingaddress.state">  state</form:label>
<form:input path="shippingaddress.state" id="shippingaddress.state"/>

<form:label path="shippingaddress.country">  country</form:label>
<form:input path="shippingaddress.country" id="shippingaddress.country"/>

<form:label path="shippingaddress.zipcode">  zipcode</form:label>
<form:input path="shippingaddress.zipcode" id="shippingaddress.zipcode"/>
<br>
<input type="submit" value="Register">

</form:form>
</div>
</body>
</html>