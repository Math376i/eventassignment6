package be;

public class Coordinator(String username, String password) {

    private String username;
    private String password;


    public String getUsername() {
        return String.valueOf(username);
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
