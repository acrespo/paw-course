package ar.edu.itba.paw.webapp.horoscope;

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

    public void setSign(String sign) {
        this.sign = sign;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
