package ar.edu.itba.it.paw.horoscope.domain.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUserManager implements UserManager {
	private static String NAME_ID = "name";
	private static String SIGN_ID = "sign";
	private HttpServletRequest request;
	
	public SessionUserManager(HttpServletRequest request) {
		this.request = request;
	}
	
	@Override
	public boolean existsUser() {
		HttpSession session = request.getSession();
		return ((session.getAttribute(NAME_ID) != null && session.getAttribute(SIGN_ID) != null) ||
				(request.getParameter(NAME_ID) != null && request.getParameter(SIGN_ID) != null));
	}
	
	@Override
	public User getUser() {
		return new User(getByID(NAME_ID), getByID(SIGN_ID));
	}
	
	@Override
	public void setUser(String name, String sign) {
		HttpSession session = request.getSession();
		session.setAttribute(NAME_ID, name);
		session.setAttribute(SIGN_ID, sign);
	}
	
	@Override
	public void resetUser(String name) {
		HttpSession session = request.getSession();
		session.setAttribute(NAME_ID, null);
		session.setAttribute(SIGN_ID, null);
	}
	
	private String getByID(String id) {
		HttpSession session = request.getSession();
		String value = (String)session.getAttribute(id);
		if (value != null) {
			return value;
		} else {
			return request.getParameter(id);
		}
	}

}
