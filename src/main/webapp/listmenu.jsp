<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Admin Dashboard</title>

<!-- CSS link or other link -->
<link rel="stylesheet" type="text/css" href="listmenu.css">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">

</head>
<body>

	<!-- Sidebar Start-->
	<%@ page import="org.apache.tomcat.util.codec.binary.Base64" %>
	<div class="sidebar">
		<ul>
			<!-- Logo -->
			<li class="logo"><a href="#"> <span class="icon"><ion-icon
							name="ice-cream-outline"></ion-icon></span> <span class="text">MerLemon</span>
			</a></li>

			<li><a href="home.html"> <span class="icon"><ion-icon
							name="home-outline"></ion-icon></span> <span class="text">Dashboard</span>
			</a></li>

			<li><a href="AddMenuController"> <span class="icon"><ion-icon
							name="list-circle-outline"></ion-icon></span> <span class="text">List
						Menu</span>
			</a></li>

			<li><a href="sales.jsp"> <span class="icon"><ion-icon
							name="card-outline"></ion-icon></span> <span class="text">Sales</span>
			</a></li>

			<li><a href="staff.jsp"> <span class="icon"><ion-icon
							name="people-outline"></ion-icon></span> <span class="text">Staff</span>
			</a></li>

			<li><a href="profile.jsp"> <span class="icon"><ion-icon
							name="person-add-outline"></ion-icon></span> <span class="text">Profile</span>
			</a></li>

			<!-- logout -->
			<div class="logout">
				<li><a href="LogoutController"> <span class="icon"><ion-icon
								name="log-out-outline"></ion-icon></span> <span class="text">Logout</span>
				</a></li>
			</div>
		</ul>
	</div>
	<!-- Sidebar End-->

	<!-- Header start -->
	<div class="header-content">
		<header>
			<h1>
				<label>List Menu</label>
			</h1>

			<div class="user-wrapper">
				<span class="icon"><ion-icon name="person-circle-outline"></ion-icon></span>
			</div>
		</header>
	</div>
	<!-- Header end -->

	<!-- Main Content start-->

	<!-- Add Menu-->
	<div class="add-menu">
		<div class="add-menu-header">
			<h3>Add Menu</h3>
		</div>
		<form action="AddMenuController" method="POST"  enctype='multipart/form-data'>
			<div class="form-group">
				<label>Name:</label> <input type="text" id="menuName"
					name="menuName" required> <label>Price (RM):</label> <input
					type="text" id="menuPrice" name="menuPrice" required>
					<label>Image:</label>
					<input type="file" id="imageS" name="imageS" required>
				</select>
				<button type="submit">Add Menu</button>
			</div>
		</form>
	</div>
	<!-- Add Menu-->

	<!-- Table Menu -->
	<div class="table-container">
		<table>
			<thead>
				<tr>
					<th>Menu ID</th>
					<th>Name</th>
					<th>Price (RM)</th>
					<th>Image</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${menus}" var="m" varStatus="menus">
					<tr>
						<td><c:out value="${m.menuId}" /></td>
						<td><c:out value="${m.menuName}" /></td>
						<td><c:out value="${m.menuPrice}" /></td>
						<td><img src="data:image/png;base64,${m.encodedImage}" width="50px"/></td>
						<td><a class="btn btn-primary"
							href="AddMenuController?menuId=<c:out value="${m.menuId}"/>">Update</a></td>
						<td><button class="btn btn-danger"
								id="<c:out value="${m.menuId}"/>"
								onclick="confirmation(${m.menuId})">Delete</button></td>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<!-- Table Menu -->

	<!-- Main Content end-->

	<!-- Script link -->
	<script type="module"
		src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>

	<script nomodule
		src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>

	<script>
		function confirmation(id){					  		 
			  console.log(id);
			  var r = confirm("Are you sure you want to delete?");
			  if (r == true) {				 		  
				  location.href = 'DeletemenuController?id=' + id;
				  alert("Menu successfully deleted");			
			  } else {				  
			      return false;	
			  }
		}
		</script>

</body>
</html>