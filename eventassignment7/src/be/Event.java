package be;

public class Event {

    private int id;
    private String name;
    private String address;
    private String startTime;
    private int coordinatorcreator;

    public Event(int id, String name, String address, String startTime, int coordinatorCreator){
        this.id = id;
        this.name = name;
        this.address = address;
        this.startTime = startTime;
        this.coordinatorcreator = coordinatorCreator;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCoordinatorcreator() {
        return coordinatorcreator;
    }

    public String getAddress() {
        return address;
    }

    public String getStartTime() {
        return startTime;
    }
}
