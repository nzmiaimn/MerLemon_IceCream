<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
				<li class="home"><a href="ViewMenuController"> <span class="icon"><ion-icon
								name="home-outline"></ion-icon></span> <span class="text">Home</span>
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

			<h2>ORDER HISTORY</h2>

			<div class="table-container">
			
				<table>
					<thead>
						<tr>
							<th>Order ID</th>
							<th>Order List</th>
							<th>Total Price(RM)</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${orders}" var="o" varStatus="orders">
						<tr>
							<td><c:out value="${o.orderId}" /></td>
							<td><c:if test="${m.menuId eq c.menuId}">
								<h2>
									<c:out value="${m.menuName}" />
								</h2>
							</c:if></td>
							<td><c:out value="${totalPrice}" /></td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			
		</div>

		<!-- Order Section end -->

		<div class="cart"></div>

	</div>

	<!-- Script Link -->
	<script src="script.js"></script>

	<script type="module"
		src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>

	<script nomodule
		src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>

</body>
</html>