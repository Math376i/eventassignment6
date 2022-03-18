package gui.controller;

import be.Coordinator;
import gui.model.CoordinatorModel;
import gui.model.EventModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
    private CoordinatorModel coordinatorModel;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        eventModel = new EventModel();
        coordinatorModel = new CoordinatorModel();
        try {
            getCurrentCoordinator();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onAddEvent(ActionEvent actionEvent) {
        try {
            eventModel.createEvent(tfEventName.getText(), tfAddress.getText(), tfStartTime.getText(), currentCoordinator);
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.close();

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public Coordinator getCurrentCoordinator() throws IOException {
        File file = new File("DATA/Coordinator");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        return currentCoordinator = coordinatorModel.getSpecificCoordinator(br.readLine(), br.readLine());

    }
}
