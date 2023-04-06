<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
	<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<form role="form" action="/Enchère/ServletUtilisateur">
			<div class="form-group">
				<label for="pseudo">Pseudo</label> <input
					type="text" class="form-control" id="pseudo"
					name="pseudo" placeholder="Pseudo">
			</div>
			<div class="form-group">
				<label for="password">Password</label> <input
					type="password" class="form-control" id="password"
					name="password" placeholder="Password">
			</div>
			<button type="submit" class="mt-2">Submit</button>
		</form>
	</div>
</body>
</html>
