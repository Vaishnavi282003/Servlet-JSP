package com.tca.book;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Page3")
public class Page3 extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
		
		String values[] = request.getParameterValues("sjbook");
		
		int sjtotal = 0;
		if(values!=null)
		{
			for(int i=0; i<values.length; i++)
			{
				sjtotal = sjtotal + Integer.parseInt(values[i]);
			}
		}
		
		HttpSession s = request.getSession(true);
		s.getAttribute("p1total");
		
		int ltotal = Integer.parseInt(s.getAttribute("p1total").toString());
		int bill = ltotal + sjtotal;
		
		out.println("<br> Page1 Total : " +ltotal);
		out.println("<br> Page2 Total : " +sjtotal);
		out.println("<br> Total Bill : " +bill);
		s.invalidate();
	}
}
