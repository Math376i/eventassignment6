package gui.controller;

import gui.util.SceneSwapper;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class CoordinatorTicketController {

    public Label startTimeID;
    public Label addressID;
    public TableView tvTickets;
    public TableColumn tcEventName;
    public TableColumn tcGuestName;
    public TableColumn tcAddress;
    public TableColumn tcStartTime;
    public TableColumn tcGuestId;
    public TableColumn tcEventId;
    public Label eventID;
    public Label guestNameID;

    public void onBack(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        SceneSwapper sceneSwapper = new SceneSwapper();
        sceneSwapper.sceneSwitch(new Stage(), "CoordinatorScreen.fxml");
        stage.close();
    }
}
