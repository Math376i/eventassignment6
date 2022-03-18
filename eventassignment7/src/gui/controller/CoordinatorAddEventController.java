package gui.controller;

import be.Coordinator;
import gui.model.EventModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class CoordinatorAddEventController implements Initializable {
    @FXML
    private TextField tfEventName;
    @FXML
    private TextField tfStartTime;
    @FXML
    private TextField tfAddress;

    private Coordinator currentCoordinator;
    private EventModel eventModel;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        eventModel = new EventModel();
    }

    public void onAddEvent(ActionEvent actionEvent) {
        try {
            eventModel.createEvent(tfEventName.getText(), tfAddress.getText(), tfStartTime.getText(), currentCoordinator);
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.close();

        }catch (Exception ex){
            ex.fillInStackTrace();
        }
    }

    public void setCurrentCoordinator(Coordinator currentCoordinator) {
        this.currentCoordinator = currentCoordinator;
    }

}
