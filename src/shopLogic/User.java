package shopLogic;

public class User {
    private String email;
    private String password;
    private int accessLvl;


    public User(String email, String password, int accessLvl) {
        this.email = email;
        this.password = password;
        this.accessLvl = accessLvl;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAccessLvl(int accessLvl) {
        this.accessLvl = accessLvl;
    }
}
