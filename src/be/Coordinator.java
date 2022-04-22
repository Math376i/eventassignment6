package be;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Coordinator {

    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty name = new SimpleStringProperty();
    private final StringProperty username = new SimpleStringProperty();
    private final StringProperty password = new SimpleStringProperty();


    public Coordinator (int id, String name, String username, String password){
        setId(id);
        setName(name);
        setUsername(username);
        setPassword(password);
    }



    public int getId() {
        return id.get();
    }

    public final void setId(int id){
        this.id.set(id);
    }

    public final void setName(String name){
        this.name.set(name);
    }

    public String getName() {
        return name.get();
    }


    public String getUsername() {
        return (username).get();
    }

    public final void setUsername(String username){
        this.username.set(username);
    }

    public String getPassword() {
        return password.get();
    }

    public final void setPassword(String password){
        this.password.set(password);
    }

    public StringProperty usernameProperty() {
        return username;
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public StringProperty nameProperty() {
        return name;
    }

    public StringProperty passwordProperty() {
        return password;
    }
}
