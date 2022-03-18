package gui.controller;

import be.Coordinator;
import be.Event;
import gui.model.CoordinatorModel;
import gui.model.EventModel;
import gui.model.UserModel;
import gui.util.SceneSwapper;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;
import java.io.*;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class CoordinatorScreenController implements Initializable {


    @FXML
    private TableColumn<Event, String> tcEvent;
    @FXML
    private TableColumn<Event, String> tcDate;
    @FXML
    private TableColumn<Event, String> tcLocation;
    @FXML
    private TableView<Event> tvEvents;

    private CoordinatorModel coordinatorModel;
    private Coordinator currentCoordinator;
    private SceneSwapper sceneSwapper;
    private EventModel eventModel;
    private ObservableList<Event> allEventsFromCoordinator;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        allEventsFromCoordinator = FXCollections.observableArrayList();
        sceneSwapper = new SceneSwapper();
        coordinatorModel = new CoordinatorModel();
        eventModel = new EventModel();
        try {
            getCurrentCoordinator();
        } catch (IOException e) {
            e.printStackTrace();
        }
        fillTableView();

    }

    public Coordinator getCurrentCoordinator() throws IOException {
        File file = new File("DATA/Coordinator");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        return currentCoordinator = coordinatorModel.getSpecificCoordinator(br.readLine(), br.readLine());

    }

    public void fillTableView(){
        tcEvent.setCellValueFactory(new PropertyValueFactory<Event,String>("name"));
        tcDate.setCellValueFactory(new PropertyValueFactory<Event,String>("address"));
        tcLocation.setCellValueFactory(new PropertyValueFactory<Event,String>("startTime"));
        tvEvents.setItems(getEventFromCoordinator());
    }

    public ObservableList<Event> getEventFromCoordinator(){
       allEventsFromCoordinator.clear();
        allEventsFromCoordinator.addAll(eventModel.getEventFromCoordinator(currentCoordinator));
        return allEventsFromCoordinator;
    }

    public void onCreateGuest(ActionEvent actionEvent) throws IOException {
        sceneSwapper.sceneSwitch(new Stage(), "CoordinatorAddUserScreen.fxml");

        CoordinatorAddUserController controller = new CoordinatorAddUserController();
        controller.setCurrentCoordinator(currentCoordinator);
    }


    public void onCreateEvent(ActionEvent actionEvent) throws IOException {
        sceneSwapper.sceneSwitch(new Stage(), "CoordinatorAddEventScreen.fxml");

    }

    public void momo(ActionEvent actionEvent) {

        System.out.println(currentCoordinator.getName());
    }
}

