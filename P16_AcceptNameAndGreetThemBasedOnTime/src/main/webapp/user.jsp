<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>

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
			Date d = new Date();
			int hr = d.getHours();
			
			if(hr<=12)
			{
				out.println("Good Morning, " +un);
			}
			else if(hr<=17)
			{
				out.println("Good Afternoon, " +un);
			}
			else
			{
				out.println("Good Night, " +un);
			}
		}
	%>
</body>
</html>