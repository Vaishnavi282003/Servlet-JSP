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
		String per = request.getParameter("per");
		String grade = request.getParameter("grade");
		
		String fname = (String)session.getAttribute("fn");
		String lname = (String)session.getAttribute("ln");
		
		session.invalidate();
	%>
	
	<h1> MarkSheet </h1>
	<hr>
	
	First Name : <%= fname %><br>
	Last Name : <%= lname %><br>
	Percentage : <%= per %><br>
	Grade : <%= grade %><br>
	
	<a href="./Page1.html"> Go Home </a>
</body>
</html>