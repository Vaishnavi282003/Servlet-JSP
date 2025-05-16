import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Add extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		Cookie ck1 = new Cookie("Sachin", "Dhane");
		ck1.setPath("/");
		Cookie ck2 = new Cookie("Sourabh", "Deo");
		ck2.setPath("/");
		
		response.addCookie(ck1);
		response.addCookie(ck2);
		
		out.println("Cookies are Saved!");
	}
}
