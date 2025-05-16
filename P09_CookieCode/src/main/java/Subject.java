import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Subject")
public class Subject extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String sub = request.getParameter("sub");
		
		Cookie c[] = request.getCookies();
		
		int cnt=0;
		if(c==null)
		{
			cnt = 1;
		}
		else
		{
			cnt = c.length + 1;
		}
		
		String key = "ID" + cnt;
		Cookie ck = new Cookie(key, sub);
		ck.setPath("/");
		response.addCookie(ck);
		out.println(sub + " is added in a Cookie!<br>");
		
		if(c!=null)
		{
			out.println("Old Cookies saved on Client Side!<br>");
			
			for(int i=0; i<c.length; i++)
			{
				String cname = c[i].getName();
				String cvalue = c[i].getValue();
				out.println(cname + ":" + cvalue + "<br>");
			}
		}
	}
}
