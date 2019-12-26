package shopLogic;

public class User {
    public static String email;
    public static String password;
    public static int accessLvl;

    public User(){

    }
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
