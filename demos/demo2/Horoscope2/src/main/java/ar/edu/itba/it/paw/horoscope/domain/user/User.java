package ar.edu.itba.it.paw.horoscope.domain.user;

public class User {

	private String name;
	private String sign;
	
	public User() {
	}
	public User(String name, String sign) {
		this.name = name;
		this.sign = sign;
	}
	
	public String getName() {
		return name;
	}
	
	public String getSign() {
		return sign;
	}
	
	@Override
	public String toString() {
		return "User[" + name + "," + sign + "]";
	}
}
