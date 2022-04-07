package gui.controller;

import be.Coordinator;
import be.Event;
import be.Ticket;
import gui.model.CoordinatorModel;
import gui.model.EventModel;
import gui.model.TicketModel;
import gui.util.SceneSwapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CoordinatorTicketController implements Initializable {

    public HBox ticketID;
    @FXML
    private ComboBox comboBoxEvent;
    @FXML
    private Label startTimeID;
    @FXML
    private Label addressID;
    @FXML
    private Label eventNameID;
    @FXML
    private Label guestNameID;

    @FXML
    private TableView<Ticket> tvTickets;
    @FXML
    private TableColumn<Ticket, String> tcEventName;
    @FXML
    private TableColumn<Ticket, String> tcGuestName;
    @FXML
    private TableColumn<Ticket, String> tcAddress;
    @FXML
    private TableColumn<Ticket, String> tcStartTime;
    @FXML
    private TableColumn<Ticket, String> tcGuestId;
    @FXML
    private TableColumn<Ticket, String> tcEventId;


    private ObservableList<Ticket> allTicketsFromEvent;
    private ObservableList<Event> allEventsFromCoordinator;
    private Coordinator currentCoordinator;
    private CoordinatorModel coordinatorModel;
    private EventModel eventModel;
    private TicketModel ticketModel;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        coordinatorModel = new CoordinatorModel();
        eventModel = new EventModel();
        ticketModel = new TicketModel();

        allTicketsFromEvent = FXCollections.observableArrayList();
        allEventsFromCoordinator = FXCollections.observableArrayList();

        try {
            getCurrentCoordinator();
            setComboBoxEvent();
        } catch (IOException e) {
            e.printStackTrace();
        }
        prepareTableview();
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
     * sets the ComboBox up with all events from Coordinator
     */
    public void setComboBoxEvent(){
        allEventsFromCoordinator.clear();
        allEventsFromCoordinator.addAll(eventModel.getEventFromCoordinator(currentCoordinator));

        for (Event event : allEventsFromCoordinator){
            comboBoxEvent.getItems().add(event.getName());
        }
    }


    /**
     * prepare tableview for tickets
     */
    public void prepareTableview(){
        tcEventName.setCellValueFactory(cellData -> cellData.getValue().eventNameProperty());
        tcGuestName.setCellValueFactory(cellData -> cellData.getValue().guestNameProperty());
        tcStartTime.setCellValueFactory(cellData -> cellData.getValue().startTimeProperty());
        tcAddress.setCellValueFactory(cellData -> cellData.getValue().addressProperty());
        tcEventId.setCellValueFactory(cellData -> cellData.getValue().teventidProperty());
        tcGuestId.setCellValueFactory(cellData -> cellData.getValue().tuseridProperty());
    }


    public void setTableviewForTickets(){
        allTicketsFromEvent.clear();

        for (Event event : allEventsFromCoordinator){
            if (event.getName().equals(comboBoxEvent.getSelectionModel().getSelectedItem())){
                allTicketsFromEvent.addAll(ticketModel.getTicketsFromEvent(event));
                break;
            }
        }
        tvTickets.setItems(allTicketsFromEvent);



    }


    public void onBack(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        SceneSwapper sceneSwapper = new SceneSwapper();
        sceneSwapper.sceneSwitch(new Stage(), "CoordinatorScreen.fxml");
        stage.close();
    }


    public void onComboBoxEvent(ActionEvent actionEvent) {
        if (!comboBoxEvent.getSelectionModel().isEmpty()){
            setTableviewForTickets();
        }
    }

    public void onTableViewTicket(MouseEvent mouseEvent) {
        if (!tvTickets.getSelectionModel().isEmpty()){
            eventNameID.setText(tvTickets.getSelectionModel().getSelectedItem().getEventName());
            guestNameID.setText(tvTickets.getSelectionModel().getSelectedItem().getGuestName());
            addressID.setText(tvTickets.getSelectionModel().getSelectedItem().getAddress());
            startTimeID.setText(tvTickets.getSelectionModel().getSelectedItem().getStartTime());
        }

    }
}
