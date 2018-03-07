package ar.edu.itba.it.paw.horoscope.web;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.edu.itba.it.paw.horoscope.domain.user.CookieUserManager;
import ar.edu.itba.it.paw.horoscope.domain.user.UserManager;

@SuppressWarnings("serial")
public class WelcomePage extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		UserManager manager = new CookieUserManager(request, response); 
		if (manager.existsUser()) {
			request.getRequestDispatcher("horoscope").forward(request, response);
		} else {
			request.getRequestDispatcher("/WEB-INF/jsp/welcome.jsp").forward(request, response);
		}
	}
}
