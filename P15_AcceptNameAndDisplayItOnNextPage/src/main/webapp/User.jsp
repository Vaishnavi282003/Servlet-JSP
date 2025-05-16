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
	String un = request.getParameter("un");
	
 	if(un == "")
 	{
 		out.println("Sorry, No Name Sent!");
 	}
 	else
 	{
 		out.println("Hello " + un);
 	}
%>
</body>
</html>