package gui.controller;

import gui.util.SceneSwapper;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

import java.io.IOException;

public class UserScreenController {


    /**
     * closes the state and return to login screen again.
     */
    public void onBtnLogOut(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        SceneSwapper sceneSwapper = new SceneSwapper();
        sceneSwapper.sceneSwitch(new Stage(), "Login.fxml");
        stage.close();
    }
    
}
