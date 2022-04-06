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
    private final IntegerProperty coordinatorcreator = new SimpleIntegerProperty();

    public Coordinator (int id, String name, String username, String password, int coordinatorCreator){
        setId(id);
        setName(name);
        setUsername(username);
        setPassword(password);
        setCoordinatorcreator(coordinatorCreator);
    }

    private void setCoordinatorcreator(int coordinatorCreator) {
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
}
