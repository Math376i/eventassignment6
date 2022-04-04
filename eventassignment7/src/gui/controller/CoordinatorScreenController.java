package gui.controller;

import be.Coordinator;
import be.Event;
import be.User;
import dal.db.EventDao;
import gui.model.CoordinatorModel;
import gui.model.EventModel;
import gui.model.UserModel;
import gui.util.SceneSwapper;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.*;
import java.net.URL;;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CoordinatorScreenController implements Initializable {

    ObservableList<Event> allEvents = FXCollections.observableArrayList();

    @FXML
    private TableView<User> tvGuest;
    @FXML
    private TableColumn<User, String> tcUserName;
    @FXML
    private TableColumn< User, String> tcEmail;
    @FXML
    private TableColumn<User, String > tcNumber;
    @FXML
    private TableColumn<User, String> tcTicketName;


    // for event table view
    @FXML
    private TableColumn<Event, String> tcEvent;
    @FXML
    private TableColumn<Event, String> tcDate;
    @FXML
    private TableColumn<Event, String> tcLocation;
    @FXML
    private TableView<Event> tvEvents;

    private CoordinatorModel coordinatorModel;
    private UserModel userModel;
    private Coordinator currentCoordinator;
    private SceneSwapper sceneSwapper;
    private EventModel eventModel;
    private ObservableList<Event> allEventsFromCoordinator;

    private ObservableList<User> userList;
    private Event event;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        allUsersFromEvents = FXCollections.observableArrayList();
        allEventsFromCoordinator = FXCollections.observableArrayList();
        sceneSwapper = new SceneSwapper();
        coordinatorModel = new CoordinatorModel();
        eventModel = new EventModel();
        userModel = new UserModel();
        try {
            getCurrentCoordinator();
        } catch (IOException e) {
            e.printStackTrace();
        }
        fillTableView();

        eventModel.getEventFromCoordinator(currentCoordinator).addListener((ListChangeListener) change -> fillTableView());

    }


    public Coordinator getCurrentCoordinator() throws IOException {
        File file = new File("DATA/Coordinator");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        return currentCoordinator = coordinatorModel.getSpecificCoordinator(br.readLine(), br.readLine());
    }

    public void fillTableView(){
        tcEvent.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        tcDate.setCellValueFactory(cellData -> cellData.getValue().startTimeProperty());
        tcLocation.setCellValueFactory(cellData -> cellData.getValue().addressProperty());
        tvEvents.setItems(getEventFromCoordinator());

        tcUserName.setCellValueFactory(new PropertyValueFactory<User, String>("name"));
        tcEmail.setCellValueFactory(new PropertyValueFactory<User, String>("email"));
        tcNumber.setCellValueFactory(new PropertyValueFactory<User, String>("phoneNumber"));
        tcTicketName.setCellValueFactory(new PropertyValueFactory<User, String>("ticketName"));

        allUsersFromEvents.clear();

        for (Event event : getEventFromCoordinator()){
             allUsersFromEvents.addAll(userModel.getUsersFromEvent(event));
        }
        tvGuest.setItems(allUsersFromEvents);
    }

    public ObservableList<Event> getEventFromCoordinator(){
       allEventsFromCoordinator.clear();
        allEventsFromCoordinator.addAll(eventModel.getEventFromCoordinator(currentCoordinator));
        return allEventsFromCoordinator;
    }

    public Event updateEvent(Event event){

        tcEvent.getCellObservableValue(Event.getName(), Event.getAddress(), Event.getStartTime());
        tcEvent.setCellValueFactory(?, ?, ?);
        return event;
    }


    /**
     * creates a guest for the program and database
     */

    public void onCreateGuest(ActionEvent actionEvent) throws IOException {
        sceneSwapper.sceneSwitch(new Stage(), "CoordinatorAddUserScreen.fxml");
    }

    public void onCreateEvent(ActionEvent actionEvent) throws IOException {
        sceneSwapper.sceneSwitch(new Stage(), "CoordinatorAddEventScreen.fxml");
    }

    public void onManageGuest(ActionEvent actionEvent) {

    }

    public void onRemoveGuest(ActionEvent actionEvent) {
        Alert a = new Alert(Alert.AlertType.CONFIRMATION, "You want to remove this Event");
        a.showAndWait().filter(ButtonType.OK::equals).ifPresent(b -> {
            userModel.deleteUser(tvGuest.getSelectionModel().getSelectedItem());
        });
        fillTableView();
    }

    public void onRemoveEventBtn(ActionEvent actionEvent) {
        Alert a = new Alert(Alert.AlertType.CONFIRMATION, "You want to remove this Event");
        a.showAndWait().filter(ButtonType.OK::equals).ifPresent(b -> {
            eventModel.removeEvent(tvEvents.getSelectionModel().getSelectedItem());
        });
        fillTableView();
    }

    /**
     * closes the screen and returns back to the login screen
     */
    public void OnLogoutBtn(ActionEvent actionEvent) throws IOException {
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            SceneSwapper sceneSwapper = new SceneSwapper();
            sceneSwapper.sceneSwitch(new Stage(), "Login.fxml");
            stage.close();

    }

    public void onBtnManageEvent(ActionEvent actionEvent) throws IOException {
        sceneSwapper.sceneSwitch(new Stage(), "CoordinatorUpdateEventScreen.fxml");
    }

    public ObservableList<Event> getEvents() throws SQLException {
        allEvents.clear();
        allEvents.addAll(EventModel.updateEvent());
        asignCategoriesIntoMovies();
        return allEvents;
    }

}

