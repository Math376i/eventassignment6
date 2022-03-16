package be;

public class Coordinator {

    private String name;
    private String username;
    private String password;

    public Coordinator(int insertedId, String name, String username, String password) {
    this.name = name;
    this.username = username;
    this.password = password;
    }


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
