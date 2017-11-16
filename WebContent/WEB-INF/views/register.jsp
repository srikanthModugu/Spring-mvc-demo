<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Register</title>
<style type="text/css">
.error {
	color: red
}
</style>
</head>
<body>


	<div align="center">
		<br> <br>

		<h1>Register Please</h1>
			<p align="center" class="error ">${error}</p>
		<s:form action="regProcess" method="post" modelAttribute="person">
		<table>
				<tr>
				<td>	Enter name:</td>
				<td>	<s:input path="name" /></td>
                 <td>   <s:errors path="name" cssClass="error" /></td>
				
				</tr>
				<tr>
				<td>	Enter Email:</td>
				<td>	<s:input path="email" /></td>
			    <td>	<s:errors path="email" cssClass="error" /></td>
				</tr>
				<tr>
				    <td> Enter passWord:</td>
					<td><s:password path="passWord" /></td>
					<td><s:errors path="passWord" cssClass="error" /></td>
				</tr>
				
                <tr>
					<td>Select</td>
					<td><s:select path="gender">
							<br>
							<s:option value="male" />
							<s:option value="female" />
						</s:select></td>
					</tr>
					</table>
				<br>
				<br>
				<input type="submit" value="Register">
	
			
		</s:form>
		
		<a href="">If you already Registered</a>
	</div>
        
		
</body>
</html>