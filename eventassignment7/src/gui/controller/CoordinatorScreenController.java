package gui.controller;

import be.Coordinator;
import be.Event;
import be.User;
import gui.model.CoordinatorModel;
import gui.model.EventModel;
import gui.model.UserModel;
import gui.util.SceneSwapper;
import javafx.beans.property.SimpleIntegerProperty;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;;
import java.util.List;
import java.util.ResourceBundle;

public class CoordinatorScreenController implements Initializable {


    @FXML
    private TableView<User> tvGuest;
    @FXML
    private TableColumn<User, String> tcUserName;
    @FXML
    private TableColumn<User, String> tcEmail;
    @FXML
    private TableColumn<User, String> tcNumber;
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        userList = FXCollections.observableArrayList();
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
        prepareTableview();


        eventModel.getEventFromCoordinator(currentCoordinator).addListener((ListChangeListener) change -> prepareTableview());

    }


    /**
     * gets a coordinator that is logged in in the system
     */
    public Coordinator getCurrentCoordinator() throws IOException {
        File file = new File("DATA/Coordinator");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        return currentCoordinator = coordinatorModel.getSpecificCoordinator(br.readLine(), br.readLine());
    }

    /**
     * fills the tableviews with data
     */
    public void prepareTableview() {
        // setup for the tableview event
        tcEvent.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        tcDate.setCellValueFactory(cellData -> cellData.getValue().startTimeProperty());
        tcLocation.setCellValueFactory(cellData -> cellData.getValue().addressProperty());

        // setup for the tableview users

        tcUserName.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        tcEmail.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
        tcNumber.setCellValueFactory(cellData -> cellData.getValue().phoneNumberPropertyasStringProperty());

        setTableviewForUser();
        setTableviewForEvents();
    }

    public void setTableviewForEvents() {
        tvEvents.setItems(getEventFromCoordinator());
    }

    public void setTableviewForUser() {

        // Clear the list
        userList.clear();
        //checks if there is an event selected
        if (tvEvents.getSelectionModel().isEmpty()) {
            userList.addAll(getAllUsers()); //add all users if no event selected
        } else {
            //adds all users signed on that event
            userList.addAll(userModel.getUsersFromEvent(tvEvents.getSelectionModel().getSelectedItem()));
        }
        // sets the users on the tableview
        tvGuest.setItems(userList);
    }


    /**
     * @return list of all users
     */
    public List<User> getAllUsers() {
        return userModel.getAllUsers();
    }



    public User getSelectedUser(){
        return tvGuest.getSelectionModel().getSelectedItem();
    }


    /**
     * gets all events from one coordinator
     */
    public ObservableList<Event> getEventFromCoordinator() {
        allEventsFromCoordinator.clear();
        allEventsFromCoordinator.addAll(eventModel.getEventFromCoordinator(currentCoordinator));
        return allEventsFromCoordinator;
    }


    /**
     * creates a guest for the program and database
     */
    public void onCreateGuest(ActionEvent actionEvent) throws IOException {
        sceneSwapper.sceneSwitch(new Stage(), "CoordinatorAddUserScreen.fxml");
    }

    /**
     * creates an event for the program and database
     */
    public void onCreateEvent(ActionEvent actionEvent) throws IOException {
        sceneSwapper.sceneSwitch(new Stage(), "CoordinatorAddEventScreen.fxml");
    }


    /**
     * removes a guest/user from the program and database
     */
    public void onRemoveGuest(ActionEvent actionEvent) {
        Alert a = new Alert(Alert.AlertType.CONFIRMATION, "You want to remove this Event");
        a.showAndWait().filter(ButtonType.OK::equals).ifPresent(b -> {
            userModel.deleteUser(tvGuest.getSelectionModel().getSelectedItem());
        });
        prepareTableview();
    }

    /**
     * removes an event from the program and database
     */
    public void onRemoveEventBtn(ActionEvent actionEvent) {
        Alert a = new Alert(Alert.AlertType.CONFIRMATION, "You want to remove this Event");
        a.showAndWait().filter(ButtonType.OK::equals).ifPresent(b -> {
            eventModel.removeEvent(tvEvents.getSelectionModel().getSelectedItem());
        });
        prepareTableview();
        setTableviewForUser();
        setTableviewForEvents();
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


    public void updateGuestList(MouseEvent mouseEvent) {
        setTableviewForUser();
    }

    public void onShowAllGuestBtn(ActionEvent actionEvent) {
        tvEvents.getSelectionModel().clearSelection();
        setTableviewForUser();
    }

    public void onTicketsBtn(ActionEvent actionEvent) throws IOException {
        sceneSwapper.sceneSwitch(new Stage(), "CoordinatorTicketScreen.fxml");
    }

    public void onEditGuest(ActionEvent actionEvent) throws IOException {
        sceneSwapper.sceneSwitch(new Stage(),"CoordinatorEditUserScreen.fxml");
    }

    public void onEditEvent(ActionEvent actionEvent) throws IOException {
        sceneSwapper.sceneSwitch(new Stage(), "CoordinatorEditEventScreen.fxml");
    }
}

