package ar.edu.itba.paw.webapp.user;

public interface UserManager {

    User getUser();

    void resetUser(String name);

    boolean existsUser();

    void setUser(String name, String sign);

}