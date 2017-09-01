<html>

<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="css/login.css" />
</head>
<body>
	<h2>Welcome to the University Student System</h2>
	<div class="subheading"><h3>Login</h3></div>
	<div id="login">
		<p>Login</p>
		<form action="LoginController" method="post">
			<div class="information">
				<input type="text" name="username" placeholder="Username"/> <br>
				<input type="password" name="password" placeholder="Password"/> <br>
			</div>
			<input type="submit" value="Login" />
		</form>
	</div>
</body>
</html>
