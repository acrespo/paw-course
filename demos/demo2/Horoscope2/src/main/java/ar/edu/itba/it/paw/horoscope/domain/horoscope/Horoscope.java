package ar.edu.itba.it.paw.horoscope.domain.horoscope;

public class Horoscope {

	private String sign;
	private String description;
	
	public Horoscope() {
	}
	
	public Horoscope(String sign, String description) {
		this.sign = sign;
		this.description = description;
	}

	public String getSign() {
		return sign;
	}

	public String getDescription() {
		return description;
	}
}
