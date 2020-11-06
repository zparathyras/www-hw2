<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" href="style/style.css">
</head>
<body>
	<%
		if (session.getAttribute("barcode")==null)
		{
			response.sendRedirect("index.jsp");
		}
		else {
			session.getAttribute("pname");
			session.getAttribute("pcolor");
			session.getAttribute("pdesc");
		}
	%>
	<div class="container">
		<h1>My Product Page</h1>
	</div>
	
	<div class="mytext">
		Product added Successfully with data:<br><br>
		Barcode: ${barcode} <br>
		Name: ${pname} <br>
		Color: ${pcolor}<br>
		Description: ${pdesc}<br>
	</div>
	
	<form action="redirect_to">
		<div class="mytext">
			<br><br>Do you want to add another product?<br><br>
			<input type="submit" value="yes">
		</div>
	</form>
</body>
</html>