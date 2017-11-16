<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Login</title>
<style type="text/css">
.error {
	color: red
}
.sucess{
color: green
}
</style>

</head>
<body>

	<p align="center">Please login</p>
	<table align = "center">
	<tr><td><p align="center" class="sucess ">${mesg}</p></td></tr>
	<tr><td><p align="center" class="error ">${error}</p></td></tr>
	</table>
	<div align="center">
	
		<s:form action="loginProcess" method="post" modelAttribute="login" >
			<table>
				
				<tr>
					<td>Enter userEmail:</td>
					<td><s:input path="email"/></td>
					<td><s:errors path="email" cssClass="error"/></td>
					</tr>
				
				<tr>
					<td>Enter password:</td>
					<td><s:input path="password"/></td>
					<td><s:errors path="password" cssClass="error"/></td>
					</tr>
				
				</table>
				<input type="submit" value="Login">			    <br>
			    <br>
             
		</s:form>
		<a href="register">NewUser</a> <a href="forgot">Forget Password?</a>
	</div>
</body>
</html>