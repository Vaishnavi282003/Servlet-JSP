package com.tca.customer;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AddInfo")
public class AddInfo extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String cid = request.getParameter("cid");
		String cname = request.getParameter("cname");
		String caddr = request.getParameter("caddr");
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try
		{
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost/servletdb", "vaishnavi", "vai");
			ps = con.prepareStatement("insert into customer values(?,?,?)");
			
			ps.setInt(1, Integer.parseInt(cid));
			ps.setString(2, cname);
			ps.setString(3, caddr);
			
			int status = -1;
			try
			{
				status = ps.executeUpdate();
			}
			catch(Exception e)
			{
				out.println("You are already Registered!");
			}
			
			if(status==1)
			{
				out.println("Successfully you have been Registered!");
			}
			
			con.close();
			out.println("<h1>CLOSED</h1>");
		}
		
		catch(Exception e)
		{
			out.println("Problem in Registration! -> " +e);
			e.printStackTrace();
		}
	}
}
