package ar.edu.itba.it.paw.horoscope.domain.user;

public interface UserManager {

	public User getUser();
	
	public void resetUser(String name);
	
	public boolean existsUser();
	
	public void setUser(String name, String sign);

}