package com.tca.customer;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CustomerInfo")
public class CustomerInfo extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		int cn = Integer.parseInt(request.getParameter("cn"));
		out.println("Customer Number : " +cn);
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try
		{
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost/servletdb", "vaishnavi", "vai");
			ps = con.prepareStatement("select * from customer where cno=?");
			
			ps.setInt(1, cn);
			rs = ps.executeQuery();
			
			if(rs.next())
			{
				out.println("<h3>Information of Customer Number : " +rs.getInt(1)+ "</h3>");
				out.println("Customer Name : " +rs.getString("cname")+ "<br>");
				out.println("Address : " +rs.getString("address")+ "<br>");
			}
			else
			{
				out.println("<h3>Information for Customer Number : " +cn+ ": NOT FOUND</h3>");
			}
			con.close();
		}
		
		catch(Exception e)
		{
			out.println(e); //You will see exception in browser
			e.printStackTrace(); //You will see exception in console
		}
	}
}
