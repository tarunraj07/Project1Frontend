<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html>
<head>
<title>Thank you</title>
<%@ include
	file="header.jsp"%>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<!-- //for-mobile-apps -->
<link href="<c:url value='/resources/payment/css/style.css'/>" rel="stylesheet"
	type="text/css" media="all" />
<link href='http://fonts.googleapis.com/css?family=Fugaz+One'
	rel='stylesheet' type='text/css'>
<link
	href='http://fonts.googleapis.com/css?family=Alegreya+Sans:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,800,800italic,900,900italic'
	rel='stylesheet' type='text/css'>
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic'
	rel='stylesheet' type='text/css'>
<script type="text/javascript" src="<c:url value='/resources/payment/js/jquery.min.js'/>"></script>
</head>
<body>
	<div class="main">
		<h1>Payment Mode</h1>
		<div class="content">

			<script src="<c:url value='/resources/payment/js/easyResponsiveTabs.js'/>"
				type="text/javascript"></script>
			<script type="text/javascript">
				$(document).ready(function() {
					$('#horizontalTab').easyResponsiveTabs({
						type : 'default', //Types: default, vertical, accordion           
						width : 'auto', //auto or any width like 600px
						fit : true
					// 100% fit in a container
					});
				});
			</script>
			<div class="sap_tabs">
			<span style="color:red;">${error }</span>
				<div id="horizontalTab"
					style="display: block; width: 100%; margin: 0px;">
					<div class="pay-tabs">
						<h2>Select Payment Method</h2>
						<ul class="resp-tabs-list">
							<!-- <li class="resp-tab-item" aria-controls="tab_item-3" role="tab"><span><label
									class="pic2"></label>Debit Card</span></li>-->
							<li class="resp-tab-item"><a href="<c:url value='/cart/placeOrder/${totalPrice}'/>"><span><label
										class="pic4"></label>Cash On Delivery</span></a></li>
							<div class="clear"></div>
						</ul>
					</div>
					<div class="resp-tabs-container">



						<!-- <div class="tab-1 resp-tab-content" aria-labelledby="tab_item-3">
							<div class="payment-info">
<c:url value="/paymentModeDebitCard" var="url"/>
								<h3 class="pay-title">Dedit Card Details</h3>
								<form:form action="${url}" modelAttribute="paymentMode">
									<div class="tab-for">										
										<h5>CARD NUMBER</h5>
										<form:input class="pay-logo" path="digi16" maxlength="16" value="" required=""/>
									</div>	
									<div class="tab-form-right user-form-rt">
											<h5>CVV NUMBER</h5>
											<form:input path="cvv" value="" required=""/>
										</div>
									<div class="transaction">
										<div class="tab-form-left user-form">
											<h5>EXPIRATION</h5>
											<ul>
												<li><form:input path="month" class="text_box" value="01"
													min="1" max="12" required=""/></li>
												<li><form:input path="year" class="text_box" value="2020" min="1" required=""/></li>

											</ul>
										</div>
										
										<div class="clear"></div>
									</div>
									<div class="tab-for">
										<h5>NAME OF THE CARD HOLDER</h5>
										<form:input path="bankHolderName"/>										
									</div>							<input type="hidden" name="totalPrice" value="${totalPrice}">		
									<input type="submit" value="Pay">
								</form:form>
							</div>
						</div>-->
					</div>
				</div>
			</div>

		</div>
		<p class="footer">
			Copyright @ 2019 All Rights Reserved | BAGS by
			<a href="#" target="_blank">BAGS SHOPPING</a>
		</p>
	</div>
</body>
</html>