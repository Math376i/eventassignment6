package be;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Event {


    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty name = new SimpleStringProperty();
    private final StringProperty address = new SimpleStringProperty();
    private final StringProperty startTime = new SimpleStringProperty();
    private final IntegerProperty coordinatorcreator = new SimpleIntegerProperty();

    public Event(int id, String name, String address, String startTime, int coordinatorCreator){
        setId(id);
        setName(name);
        setAddress(address);
        setStartTime(startTime);
        setCoordinatorcreator(coordinatorCreator);
    }

    public final void setId(int id){
        this.id.set(id);
    }
    public int getId() {
        return id.get();
    }
    public IntegerProperty idProperty(){
        return id;
    }

    public final void setName(String name){
        this.name.set(name);
    }
    public String getName() {
        return name.get();
    }
    public StringProperty nameProperty(){
        return name;
    }
    public final void setAddress(String address){
        this.address.set(address);
    }
    public String getAddress() {
        return address.get();
    }
    public StringProperty addressProperty(){
        return address;
    }

    public final void setStartTime(String startTime){
        this.startTime.set(startTime);
    }
    public String getStartTime() {
        return startTime.get();
    }
    public StringProperty startTimeProperty(){
        return startTime;
    }
    public final void setCoordinatorcreator(int coordinatorcreator){
        this.coordinatorcreator.set(coordinatorcreator);
    }
    public IntegerProperty coordinatorCreatorProperty(){
        return coordinatorcreator;
    }
    public int getCoordinatorcreator() {
        return coordinatorcreator.get();
    }
}
