package gui.controller;

import be.Coordinator;
import gui.model.CoordinatorModel;
import gui.model.UserModel;
import gui.util.SceneSwapper;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CoordinatorScreenController implements Initializable {

    private UserModel userModel;
    private CoordinatorModel coordinatorModel;
    private Coordinator currentCoordinator;
    private SceneSwapper sceneSwapper;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        userModel = new UserModel();
        sceneSwapper = new SceneSwapper();
        coordinatorModel = new CoordinatorModel();
    }

    public void setCurrentCoordinator(Coordinator currentCoordinator) {
        this.currentCoordinator = currentCoordinator;
        System.out.println(currentCoordinator);
    }

    public void onCreateGuest(ActionEvent actionEvent) throws IOException {
        sceneSwapper.sceneSwitch(new Stage(), "CoordinatorAddUserScreen.fxml");

        CoordinatorAddUserController controller = new CoordinatorAddUserController();
        controller.setCurrentCoordinator(currentCoordinator);
    }


    public void onCreateEvent(ActionEvent actionEvent) throws IOException {
        sceneSwapper.sceneSwitch(new Stage(), "CoordinatorAddEventScreen.fxml");

        CoordinatorAddEventController controller = new CoordinatorAddEventController();
        controller.setCurrentCoordinator(currentCoordinator);

    }
}
