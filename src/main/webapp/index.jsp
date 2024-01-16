<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="org.apache.tomcat.util.codec.binary.Base64"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>MerLemon Ice Cream</title>

<!-- CSS link or other link -->
<link rel="stylesheet" type="text/css" href="Index.css">
</head>
<body>

	<div class="container">

		<!-- Menu Section start -->
		<div class="menu">

			<!-- Logo -->
			<div class="logo">MerLemon</div>

			<!-- Menu Section start -->
			<ul>
				<li class="home"><a href="ViewMenuController"> <span
						class="icon"><ion-icon name="home-outline"></ion-icon></span> <span
						class="text">Home</span>
				</a></li>

				<li><a href="order.jsp"> <span class="text">Order</span>
				</a></li>

				<!--logout -->
				<div class="logout">
					<li><a href="LogoutController"> <span class="icon"><ion-icon
									name="log-out-outline"></ion-icon></span> <span class="text">Logout</span>
					</a></li>
				</div>

			</ul>
		</div>
		<!-- Menu Section end -->

		<!-- Order Section start -->
		<div class="center">
			<div class="order"></div>

			<h2>HOME</h2>


			<div class="menu">
				<c:forEach items="${menus}" var="m" varStatus="menus">
					<form action="CartController" method="post">
						<div class="item">
							<img src="data:image/png;base64,${m.encodedImage}" width="50px" />
							<h2>
								<c:out value="${m.menuName}" />
							</h2>
							<input type="hidden" name="menuId" value="${m.menuId}" />
							<!-- Other details you want to display -->
							<button type="submit" class="addCart">Add to Cart</button>

						</div>
					</form>
				</c:forEach>
			</div>

		</div>

		<!-- Order Section end -->

		<div class="cart">
			<div class="title">CART</div>
			<div class="listCart">
			<form action="OrderController" method="post">
				<c:forEach items="${carts}" var="c" varStatus="carts">
					<c:forEach items="${menus}" var="m" varStatus="menus">
					
						<div class="item">
							<c:if test="${m.menuId eq c.menuId}">
								<h2>
									<c:out value="${m.menuName}" />
								</h2>
							</c:if>
							<div class="total">
								RM
								<c:if test="${m.menuId eq c.menuId}">
								<p><c:out value="${m.menuPrice}" /></p>
								</c:if>
							</div>
							<div class="quantity">
									<label>Quantity: </label>
									<input type="text" id="quantity" name="quantity">
							</div>
							<div class="delete">
								<button class="x" onclick="deleteItem('${c.cartId}')">X</button>
							</div>
						</div>
						
					</c:forEach>
				</c:forEach>
				

				<div class="payment">
					<!--  <h3>
						Total Price: RM
						<--<c:out value="${totalPrice}" />
					</h3>-->
					<button type="submit" class="addOrder" >Check
						Out</button>
				</div>
				</form>
			</div>
		</div>

	</div>
	
	
	<!-- Script Link -->
	
	<!-- Add this to include jQuery -->
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
	
	<script src="script.js"></script>
	
	

	<script type="module"
		src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>

	<script nomodule
		src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>

</body>
</html>