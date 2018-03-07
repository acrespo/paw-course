package ar.edu.itba.it.paw.horoscope.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.edu.itba.it.paw.horoscope.domain.horoscope.FileHoroscopeManager;
import ar.edu.itba.it.paw.horoscope.domain.horoscope.Horoscope;
import ar.edu.itba.it.paw.horoscope.domain.horoscope.HoroscopeManager;
import ar.edu.itba.it.paw.horoscope.domain.user.CookieUserManager;
import ar.edu.itba.it.paw.horoscope.domain.user.User;
import ar.edu.itba.it.paw.horoscope.domain.user.UserManager;


@SuppressWarnings("serial")
public class ViewHoroscopePage extends HttpServlet {
	
	private HoroscopeManager horoscopeManager;
	
	@Override
	public void init() throws ServletException {
		super.init();
		String fileName = getServletContext().getRealPath(getInitParameter("data"));
		horoscopeManager = new FileHoroscopeManager(fileName);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		UserManager userManager = new CookieUserManager(request, response);
		User user = userManager.getUser();
		
		Horoscope horoscope = horoscopeManager.getHoroscope(user.getSign());
		
		if (horoscope == null) {
			response.sendRedirect(response.encodeRedirectURL("errorPage") + "?name=" + user.getName() + "&sign=" + user.getSign());
			return;
		}
		
		userManager.setUser(user.getName(), user.getSign());
		
		request.setAttribute("horoscope", horoscope);
		request.setAttribute("user", user);
		request.getRequestDispatcher("/WEB-INF/jsp/viewHoroscope2.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
