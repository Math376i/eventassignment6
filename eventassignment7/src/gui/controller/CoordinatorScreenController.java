package gui.controller;

import gui.model.UserModel;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class CoordinatorScreenController implements Initializable {

    private UserModel userModel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        userModel = new UserModel();
    }


    public void onCreateGuest(ActionEvent actionEvent) {

    }


}
