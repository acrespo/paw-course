package ar.edu.itba.it.paw.horoscope.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
public class ErrorPage extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String sign = request.getParameter("sign");
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Horoscopo OnLine</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>" + name + ", el signo " + sign + " es invalido: </h2> <br>"); 
		String url = request.getContextPath();
		out.println("<h2><A href=\"" + url + "/welcome\" >Volver</a></h2>");
		out.println("</body>");
		out.println("</html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
