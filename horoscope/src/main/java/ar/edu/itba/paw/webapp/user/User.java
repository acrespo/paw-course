package ar.edu.itba.paw.webapp.user;

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

    public void setName(String name) {
        this.name = name;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    @Override
    public String toString() {
        return "User[" + name + "," + sign + "]";
    }
}

