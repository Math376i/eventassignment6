package gui.controller;

import gui.util.SceneSwapper;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;


public class LoginController implements Initializable {

    public TextField lblUsername;
    public TextField lblPassword;


    public void onLoginBtn(ActionEvent actionEvent) throws IOException {

        if (lblUsername.getText().toLowerCase(Locale.ROOT).equals("admin") && lblPassword.getText().toLowerCase(Locale.ROOT).equals("admin")) {

            SceneSwapper sceneSwapper = new SceneSwapper();
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setResizable(false);
            sceneSwapper.sceneSwitch(stage, "AdminScreen.fxml");
        }

        if(lblUsername.getText().toLowerCase(Locale.ROOT).equals("Coordinator") && lblPassword.getText().toLowerCase(Locale.ROOT).equals("Coordinator")){

            SceneSwapper sceneSwapper = new SceneSwapper();
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setResizable(false);
            sceneSwapper.sceneSwitch(stage, "CoordinatorScreen.fxml");
        }

        if(lblUsername.getText().toLowerCase(Locale.ROOT).equals("User") && lblPassword.getText().toLowerCase(Locale.ROOT).equals("User")){

            SceneSwapper sceneSwapper = new SceneSwapper();
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setResizable(false);
            sceneSwapper.sceneSwitch(stage, "UserScreen.fxml");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

}
