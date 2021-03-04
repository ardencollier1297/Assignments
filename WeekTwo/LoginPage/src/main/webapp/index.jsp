<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Dynamic Project</title>
</head>
<body>
	<h1>Sign In Here</h1>
	
	<form action="Dynamic" method="post">
		<label for="username">Username:</label>
		<br/>
		<input name="username" type="text" id="username"></input>
		<br/>
		<label for="password">Password:</label>
		<br/>
		<input name="password" type="password" id="password"></input>
		<br/>
		<button type="submit">Submit</button>
	</form>
</body>
</html>