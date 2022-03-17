package gui.controller;

import gui.util.SceneSwapper;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminScreenController {


    public void onAddCoordinatorBtn(ActionEvent actionEvent) throws IOException {
        SceneSwapper sceneSwapper = new SceneSwapper();
        sceneSwapper.sceneSwitch(new Stage(), "AdminAddEventManagerScreen.fxml");
    }

}
