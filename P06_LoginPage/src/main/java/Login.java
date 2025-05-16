import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class Login extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String un = request.getParameter("un");
		String upwd = request.getParameter("upwd");
		
		//Version 1 :
//		if(un.equals("bsc") && upwd.equals("cs"))
//			{
//				out.println("<h1> Login Successful! </h1>");
//			}
//			else
//			{
//				out.println("<h1> Login Failed! </h1>");
//			}
		
		//Version 2 :
//		if(un.equals("bsc") && upwd.equals("cs"))
//		{
//			out.println("<script> alert('Login Successful!') </script>");
//		}
//		else
//		{
//			out.println("<script> alert('Login Failed!') </script>");
//		}
		
		//Version 3:
		if(un.equals("bsc") && upwd.equals("cs"))
		{
			response.sendRedirect("https://www.technocompacademy.com");
		}
		else
		{
			out.println("<script> alert('Login Failed!') </script>");
			
			out.println("<form method=POST action=./Login>");
			out.println("Username : <input type=text name=un><br>");
			out.println("Password : <input type=password name=upwd><br>");
			out.println("<input type=submit value=Login><input type=reset value=Clear>");
			out.println("</form>");
		}
	}
}
