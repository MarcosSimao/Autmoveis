<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="<%=request.getContextPath()%>/hello">
		nome:<input type="text" name="nome"> sobrenome:<input
			type="text" name="sobrenome"> <input type="submit"
			name="enviar">

	</form>
</body>
</html>