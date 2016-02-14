package test.java.core;

public class User {

    private String username;
    private String password;

    public static User getUser() {
        return new User().setUsername("taniasun-testuser")
                .setPassword("Password12#$");
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }
}
