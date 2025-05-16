import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Show extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		Cookie c[] = request.getCookies();
		
		if(c == null)
		{
			out.println("No Cookies are Saved yet!");
		}
		else
		{
			out.println("Cookies Saved on Client Side <br>");
			
			for(int i=0; i<c.length; i++)
			{
				String cname = c[i].getName();
				String cvalue = c[i].getValue();
				
				out.println(cname + ":" + cvalue + "<br>");
			}
		}
	}
}
