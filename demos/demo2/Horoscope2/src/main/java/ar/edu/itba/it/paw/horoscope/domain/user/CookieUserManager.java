package ar.edu.itba.it.paw.horoscope.domain.user;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUserManager implements UserManager {
	private static String NAME_ID = "name";
	private static String SIGN_ID = "sign";
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public CookieUserManager ( HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}
	
	@Override
	public boolean existsUser() {
		if (getCookie(NAME_ID) != null && getCookie(SIGN_ID) != null) {
			return true;
		} else {
			String name = request.getParameter(NAME_ID);
			String sign = request.getParameter(SIGN_ID);
			return name != null && sign != null;
		}
	}
	
	@Override
	public User getUser() {
		return new User(getByID(NAME_ID), getByID(SIGN_ID));
	}
	
	@Override
	public void setUser(String name, String sign) {
		setCookie(NAME_ID, name, false);
		setCookie(SIGN_ID, sign, false);
	}
	
	@Override
	public void resetUser(String name) {
		setCookie(NAME_ID, name, true);
		setCookie(SIGN_ID, "", true);
	}
	
	private void setCookie(String name, String value, boolean delete) {
		Cookie cookie = new Cookie(name, value);
		if (delete) {
			cookie.setMaxAge(0);
		}
		response.addCookie(cookie);
	}
	
	private Cookie getCookie(String name) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for( Cookie c: cookies) {
				if (c.getName().equals(name)) {
					return c;
				}
			}
		}
		return null;
	}
	
	private String getByID(String id) {
		Cookie c = getCookie(id);
		if (c != null) {
			return c.getValue();
		} else {
			return request.getParameter(id);
		}
	}
}
