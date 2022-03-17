package gui.controller;

import gui.model.UserModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        userModel = new UserModel();
    }

    public void onAddUser(ActionEvent actionEvent) {
        try {
            userModel.createUser(tfName.getText(),tfEmail.getText(), Integer.parseInt(tfPhoneNumber.getText()));
        }catch (Exception exp){
            exp.fillInStackTrace();
        }
    }

    public void onClose(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }
}
