<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>My Product Page</title>
	<link rel="stylesheet" href="style/style.css">
</head>
<body>
	<div class="container">
		<h1>My Product Page</h1>
	</div>

	<form action="EnterProductData">
		<div class="data_insert">
			<br><br>To add a new product please type product data in the fields below.<br><br>
			Enter product barcode:<br> <input type="text" name="pbarcode"><br><br>
			Enter product name: <br><input type="text" name="pname"><br><br>
			Enter product color: <br><input type="text" name="pcolor"><br><br>
			Enter product description:<br> <input type="text" name="pdescription"><br><br>
			<input type="submit">
		</div>
	</form>
</body>
</html>