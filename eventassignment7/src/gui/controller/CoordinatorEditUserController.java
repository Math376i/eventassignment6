package gui.controller;

import gui.util.SceneSwapper;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

import java.io.IOException;

public class CoordinatorEditUserController {
    public void onEditUser(ActionEvent actionEvent) {

    }

    public void onClose(ActionEvent actionEvent)  {
        CoordinatorScreenController controller = new SceneSwapper().getCoordinatorController();
        controller.prepareTableview();

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }
}
