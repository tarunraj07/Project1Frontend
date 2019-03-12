<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Bag Shopping</title>
<%@ include file="header.jsp" %>
</head>
<body>
<div class="container">
  <h2>Bags Shopping</h2>
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>
    <!-- Wrapper for slides -->
    <div class="carousel-inner">

      <div class="item active">
        <img src="resources/images/1.jpg" alt="bag1.jpg" style="width:1000px;height:490px;margin: 0 auto;">
        <div class="carousel-caption">
          <h3> Shopping Cart </h3>
          <p>Enjoy with your new style</p>
        </div>
      </div>

      <div class="item">
        <img src="resources/images/2.jpg" alt="bag2.jpeg" style="width:960px;height:450px;margin: 0 auto;">
      </div>
    
      <div class="item">
        <img src="resources/images/3..jpg" alt="bag3.jpg" style="width:960px;height:450px;margin: 0 auto;">
             </div>
   
        
    </div>
  </div>
</div>
<div>

${register}
</div>
</body>
</html>