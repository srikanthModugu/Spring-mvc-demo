<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">sucess...</h1>
	<br>
	<p align="center">
		welcome
		<%=session.getAttribute("email")%></p>
	<br>
	<p align="center">This email is got by model... ${email}</p>
	<br>
	<p align="center">
		<input type="button" value="Logout" onclick="location.href='logout'">
	</p>

</body>
</html>