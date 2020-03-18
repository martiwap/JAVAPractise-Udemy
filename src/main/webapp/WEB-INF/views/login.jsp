<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tahooo!!!! from JSP</title>
</head>

<%
		/*  the follwing is an example of how you can have java code in a view jsp file 
			thought remember that logic does not belong to view files!
		*/
	System.out.println(request.getParameter("name"));
	Date myDate = new Date();
%>

<body>
	<!-- 
		<div>
			Current date is <%=myDate%>
		</div>
		<br />
		<div>
			Hey! this is my first JSP! <br />
			And your name is "${name}"! and your password is ${password}			
		</div>
	 -->
	<div>
		<form action="/login.do" method="post">			
			<label>
				Enter your name:
			</label>
			<input type="text" name="name" /><br>
			
			<label>
				Password: 
			</label>
			<input type="password" name="password"><br>
			
			<input type="submit" value="Sign in"/>
		</form>		
	</div>	
	<p style="color:red;">${errorMessage}</p>
	<!-- Valid User -> welcome.jsp  -->
	<!-- Invalid User -> login.jsp  -->

</body>
</html>