package ar.edu.itba.paw.webapp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class SessionUserManager implements UserManager {
    private static String NAME_ID = "name";
    private static String SIGN_ID = "sign";

    @Autowired
    HttpServletRequest request;

    public boolean existsUser() {
        HttpSession session = request.getSession();
        return ((session.getAttribute(NAME_ID) != null && session.getAttribute(SIGN_ID) != null) ||
                (request.getParameter(NAME_ID) != null && request.getParameter(SIGN_ID) != null));
    }

    public User getUser() {
        return new User(getByID(NAME_ID), getByID(SIGN_ID));
    }

    public void setUser(String name, String sign) {
        HttpSession session = request.getSession();
        session.setAttribute(NAME_ID, name);
        session.setAttribute(SIGN_ID, sign);
    }

    public void resetUser(String name) {
        HttpSession session = request.getSession();
        session.setAttribute(NAME_ID, null);
        session.setAttribute(SIGN_ID, null);
    }

    private String getByID(String id) {
        HttpSession session = request.getSession();
        String value = (String) session.getAttribute(id);
        if (value != null) {
            return value;
        } else {
            return request.getParameter(id);
        }
    }

}
