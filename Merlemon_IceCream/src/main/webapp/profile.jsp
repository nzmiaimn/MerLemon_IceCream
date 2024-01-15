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
	<link rel="stylesheet" type="text/css" href="profile.css">

	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

</head>
<body>

	<!-- Sidebar Start-->
	<div class="sidebar">
		<ul>
			<!-- Logo -->
			<li class="logo">
				<a href="#">
					<span class="icon"><ion-icon name="ice-cream-outline"></ion-icon></span>
					<span class="text">MerLemon</span>
				</a>
			</li>

			<li>
				<a href="home.html">
					<span class="icon"><ion-icon name="home-outline"></ion-icon></span>
					<span class="text">Dashboard</span>
				</a>
			</li>

			<li>
				<a href="AddMenuController">
					<span class="icon"><ion-icon name="list-circle-outline"></ion-icon></span>
					<span class="text">List Menu</span>
				</a>
			</li>

			<li>
				<a href="sales.jsp">
					<span class="icon"><ion-icon name="card-outline"></ion-icon></span>
					<span class="text">Sales</span>
				</a>
			</li>

			<li>
				<a href="StaffController">
					<span class="icon"><ion-icon name="people-outline"></ion-icon></span>
					<span class="text">Staff</span>
				</a>
			</li>

			<li>
				<a href="ProfileController">
					<span class="icon"><ion-icon name="person-add-outline"></ion-icon></span>
					<span class="text">Profile</span>
				</a>
			</li>

			<!-- logout -->
			<div class="logout">
				<li>
					<a href="LogoutController">
						<span class="icon"><ion-icon name="log-out-outline"></ion-icon></span>
						<span class="text">Logout</span>
					</a>
				</li>
			</div>
		</ul>
	</div>
	<!-- Sidebar End-->

	<!-- Header start -->
	<div class="header-content">
	    <header>
			<h1>
				<label>Update Staff Profile</label>
	        </h1>

	        <div class="user-wrapper">
	            <span class="icon"><ion-icon name="person-circle-outline"></ion-icon></span>
	        </div>
	    </header>
	</div>
	<!-- Header end -->

	<!-- Main Content start-->

	<!-- Edit Profile-->
	<div class="edit-profile">
	 	<div class="edit-profile-header">
	 		<h3>Edit Staff</h3>
        </div>
        <form action="ProfileController" method="POST">
            <div class="form-group">
                <label>Username</label>
                <input type="text" id="username" name="username" value="<c:out value="${s.username}"/>"/>
                <label>Password:</label>
                <input type="text" id="password" name="password" value="<c:out value="${s.password}"/>"/>
                <button type="submit">Submit</button>
            </div>
        </form>
    </div>
    <!-- Edit Profile-->

	<!-- Main Content end-->

<!-- Script link -->
<script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>

<script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>

</body>
</html>