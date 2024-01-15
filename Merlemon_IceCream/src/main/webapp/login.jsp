<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <link rel ="stylesheet" href="login.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Lobster&display=swap">
</head>
<body>

<div class="container">
    <div class="logo">
        Mer<span>Lemon</span>
	</div>
	<form action="LoginController" method="POST">
<div class="login-form">
            <h2>Login</h2>
            <form>
                <input type="text" id="username" name="username">
                <input type="password" id="password" name="password">
                <button>Login</button>
            </form>
        </div>
        </form>
    </div>
    
    <!-- Additional content if needed -->
</div>

</body>
</html>