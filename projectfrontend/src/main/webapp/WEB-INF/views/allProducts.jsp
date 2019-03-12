<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bag Shopping</title>
<%@ include file="header.jsp" %>
<!-- Bootstrap core CSS -->
<%-- <link href="<c:url value="/resources/product/vendor/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet"> --%>

    <!-- Custom styles for this template -->
    <link href="<c:url value="/resources/product/css/portfolio-item.css"/>" rel="stylesheet">
    <script src="<c:url value="/resources/product/vendor/jquery/jquery.min.js"/>"></script>
    <script src="<c:url value="/resources/product/vendor/bootstrap/js/bootstrap.bundle.min.js"/>"></script>    
</head>
<body>
  <div class="container">

      

      <!-- Related Projects Row -->

      <div class="row">
<c:forEach items="${prodList}" var="product">
<div class="col-md-3 col-sm-6 mb-4 thumbnail">
<c:url value="/all/getProducts/${product.id}" var="urldis"></c:url>
          <a href="${urldis}">
            <img class="img-fluid" src="<c:url value='/resources/images/${product.getId()}.png'></c:url>" style='height:300px ; width:500px' alt="">
			<!-- <div class="caption"> -->
			<h5>${product.getProductname()}</h5>
			<p>${product.getQuantity()}</p>
			<p style="float:right;">INR: ${product.getPrice()}</p>
			
          </a>
        </div>
</c:forEach>
</div>
</div>
</body>
</html>