package gui.controller;

import gui.util.SceneSwapper;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;

import java.io.IOException;

public class CoordinatorCreateTicketController {
    public TableColumn tcEventName;
    private SceneSwapper sceneSwapper;

    public void onBack(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        SceneSwapper sceneSwapper = new SceneSwapper();
        sceneSwapper.sceneSwitch(new Stage(), "CoordinatorScreen.fxml");
        stage.close();
    }

}
