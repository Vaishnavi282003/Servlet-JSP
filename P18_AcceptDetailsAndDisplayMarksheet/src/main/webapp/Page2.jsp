<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		
		session.setAttribute("fn", fname);
		session.setAttribute("ln", lname);
	%>
	
	<h2> Academic Details</h2>
	
	<form method="GET" action="Page3.jsp">
		Percentage : <input type="text" name="per"><br><br>
		Grade : <input type="text" name="grade"><br><br>
		<input type="submit" value="Submit">
	</form>
</body>
</html>