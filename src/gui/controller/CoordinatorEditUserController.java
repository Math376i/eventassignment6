package gui.controller;

import be.Event;
import be.User;
import gui.model.TicketModel;
import gui.model.UserModel;
import gui.util.SceneSwapper;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CoordinatorEditUserController implements Initializable {

    @FXML
    private TextField tfName;
    @FXML
    private TextField tfPhoneNumber;
    @FXML
    private TextField tfEmail;
    @FXML
    private ComboBox comboboxEvents;

    private CoordinatorScreenController controller = new SceneSwapper().getCoordinatorController();
    private UserModel userModel = new UserModel();

    private User selectedUser;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        selectedUser = controller.getSelectedUser();

        tfName.setText(selectedUser.getName());
        tfEmail.setText(selectedUser.getEmail());
        tfPhoneNumber.setText(String.valueOf(selectedUser.getPhoneNumber()));

        int eventsNum = 0;
        // adds all events coordinators is part off for registration
        for (Event event: controller.getEventFromCoordinator()){
            comboboxEvents.getItems().add(event.getName());
            if (event.getId() == selectedUser.getEventID()){
                comboboxEvents.getSelectionModel().select(eventsNum);
            }
            eventsNum++;
        }

    }


    /**
     * edits the user by deleting the user and creating a new one plus the new ticket.
     */
    public void onEditUser(ActionEvent actionEvent) {
        try {
            // creates a new user/guest depending on is an event is selected.
            if (comboboxEvents.getSelectionModel().isEmpty()){
                userModel.createUser(tfName.getText(), tfEmail.getText(), Integer.parseInt(tfPhoneNumber.getText()), -1);
            }
            for (Event event: controller.getEventFromCoordinator()){
                if (event.getName().equals(comboboxEvents.getSelectionModel().getSelectedItem())){
                    User user = userModel.createUser(tfName.getText(), tfEmail.getText(), Integer.parseInt(tfPhoneNumber.getText()), event.getId());
                    userModel.deleteUser(selectedUser);
                    TicketModel ticketModel = new TicketModel();
                    ticketModel.createTicket(event, user);
                    break;
                }
            }

            // updates tableview users in our main Coordinator Screen
            CoordinatorScreenController controller = new SceneSwapper().getCoordinatorController();
            controller.setTableviewForUser();

        }catch (Exception exp){
            exp.printStackTrace();
        }

    }

    /**
     *closses the stage and updating the view for coordinator in main coordinator screen
     */
    public void onClose(ActionEvent actionEvent)  {

        // updates the tableview
        CoordinatorScreenController controller = new SceneSwapper().getCoordinatorController();
        controller.prepareTableview();

        // closses the stage.
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }

}
