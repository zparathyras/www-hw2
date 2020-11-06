<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" href="style/style.css">
</head>
<body>
	<div class="container">
		<h1>My Product Page</h1>
	</div>
	<%
		session.getAttribute("barcode_exists");
		session.getAttribute("numeric");
		session.getAttribute("submited_everything");

	%>
	<c:if test="${submited_everything=='no' }">
		<form action="redirect_to">
			<div class="mytext">
				ERROR: Not all data were given.<br><br>
				Please re-enter product's data.<br><br>
				<input type="submit" value="continue">
			</div>
		</form>
	</c:if>
	
	<c:if test="${barcode_exists=='yes' }">
		<form action="redirect_to">
			<div class="mytext">
				ERROR: Barcode already exists.<br><br>
				Please add new barcode.<br><br>
				<input type="submit" value="continue">
			</div>
		</form>
	</c:if>
	
	<c:if  test="${numeric=='no'}">
		<form action="redirect_to">
			<div class="mytext">
				ERROR: Barcode contains characters.<br><br>
				Please add a new barcode containing only numbers.<br><br>
				<input type="submit" value="continue">
			</div>
		</form>
	</c:if>

	
	
	
</body>
</html>