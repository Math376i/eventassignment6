package gui.controller;

import be.Coordinator;
import be.Event;
import gui.model.CoordinatorModel;
import gui.model.EventModel;
import gui.model.UserModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CoordinatorAddUserController implements Initializable {
    @FXML
    private ComboBox comboboxEvents;
    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfPhoneNumber;
    @FXML
    private TextField tfName;

    private UserModel userModel;
    private CoordinatorModel coordinatorModel;
    private Coordinator currentCoordinator;
    private EventModel eventModel;
    private ObservableList<Event> allEventsFromCoordinator;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        userModel = new UserModel();
        eventModel = new EventModel();
        coordinatorModel = new CoordinatorModel();
        allEventsFromCoordinator = FXCollections.observableArrayList();
        try {
            getCurrentCoordinator();
        } catch (IOException e) {
            e.printStackTrace();
        }
        getEventFromCoordinator();

        for (Event event: allEventsFromCoordinator){
            comboboxEvents.getItems().add(event.getName());
        }
    }

    public Coordinator getCurrentCoordinator() throws IOException {
        File file = new File("DATA/Coordinator");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        return currentCoordinator = coordinatorModel.getSpecificCoordinator(br.readLine(), br.readLine());
    }
    
    public ObservableList<Event> getEventFromCoordinator(){
        allEventsFromCoordinator.clear();
        allEventsFromCoordinator.addAll(eventModel.getEventFromCoordinator(currentCoordinator));
        return allEventsFromCoordinator;
    }


    public void onAddUser(ActionEvent actionEvent) {
        try {
            if (comboboxEvents.getSelectionModel().isEmpty()){
                userModel.createUser(tfName.getText(),tfEmail.getText(), Integer.parseInt(tfPhoneNumber.getText()));
            }else{

                for (Event event: allEventsFromCoordinator){
                    if (event.getName().equals(comboboxEvents.getSelectionModel().getSelectedItem())){
                        userModel.createUser(tfName.getText(),tfEmail.getText(), Integer.parseInt(tfPhoneNumber.getText(), event.getId()));
                    }
                }
            }

        }catch (Exception exp){
            exp.fillInStackTrace();
        }
    }

    public void onClose(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }
}
