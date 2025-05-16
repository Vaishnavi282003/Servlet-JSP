import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Page2")
public class Page2 extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String values[] = request.getParameterValues("lbook");
		
		int ltotal = 0;
		if(values!=null)
		{
			for(int i=0; i<values.length; i++)
			{
				ltotal = ltotal + Integer.parseInt(values[i]);
			}
		}
		
		HttpSession s = request.getSession(true);
		s.setAttribute("p1total", ltotal);
		
		out.println("<form method=GET action=./Page3");
		out.println("<h1>PAGE2</h1><br>");
		out.println("<b>Select Servlet and JSP Books : </b><br>");
		out.println("<input type=checkbox name=sjbook value=450> Name= Headfirst Servlet and JSP Price= 450<br>");
		out.println("<input type=checkbox name=sjbook value=300> Name= Java Servlet Programming Price= 300<br>");
		out.println("<input type=checkbox name=sjbook value=250> Name= Inside Servlet Price=250<br>");
		out.println("<input type='submit' value='Payment'>");
		out.println("</form>");
	}
}