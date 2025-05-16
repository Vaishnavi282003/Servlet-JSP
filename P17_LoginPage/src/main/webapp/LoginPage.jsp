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
		String uname = request.getParameter("uname");
		String upwd = request.getParameter("upwd");
		
		if(uname.equals("sachin") && upwd.equals("tca"))
		{
			response.sendRedirect("https://technocompacademy.com");
		}
		else
		{
			out.println("<h3> Login Failed! </h3>");
			out.println("<a href=./LoginPage.html> Home </a>");
		}
	%>
</body>
</html>