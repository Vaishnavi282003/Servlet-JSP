package com.tca.ass02;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/info")
public class Information extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<h1> Request Information </h1>");
		
		out.println("<br>Request Method : " +request.getMethod());
		out.println("<br>Request URL : " +request.getRequestURI());
		out.println("<br>Protocol : " +request.getProtocol());
		out.println("<br>Remote Address : " +request.getRemoteAddr());
		out.println("<br>Server Name : " +request.getServerName());
		out.println("<br>Port Number : " +request.getServerPort());
		
		ServletContext c = this.getServletContext();
		
		out.println("<br>Server Software : " +c.getServerInfo());
	}
}
