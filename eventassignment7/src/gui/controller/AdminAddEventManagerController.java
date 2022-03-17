package gui.controller;

import bll.CoordinatorManager;
import gui.model.CoordinatorModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminAddEventManagerController implements Initializable {
    @FXML
    private TextField tfName;
    @FXML
    private TextField txPassword;
    @FXML
    private TextField tfUsername;

    private CoordinatorModel coordinatorModel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        coordinatorModel = new CoordinatorModel();
    }

    public void onAddCoordinator(ActionEvent actionEvent) {

        try {
            coordinatorModel.createKoordinator(tfName.getText(), tfUsername.getText(), txPassword.getText());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.close();
        }catch (Exception exp){
            exp.fillInStackTrace();
        }


    }

}
