package gui.controller;

import gui.model.CoordinatorModel;
import gui.util.SceneSwapper;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.*;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;


public class LoginController implements Initializable {



    @FXML
    private TextField lblUsername;
    @FXML
    private TextField lblPassword;
    @FXML
    private CoordinatorModel coordinatorModel;


    /**
     * Logins in the user/coordinator/admin to the rightfull scene.
     */
    public void onLoginBtn(ActionEvent actionEvent) throws IOException {
            //checks for admin login
        if (lblUsername.getText().toLowerCase(Locale.ROOT).equals("admin") && lblPassword.getText().toLowerCase(Locale.ROOT).equals("admin")) {
            SceneSwapper sceneSwapper = new SceneSwapper();
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setResizable(false);
            sceneSwapper.sceneSwitch(new Stage(), "AdminScreen.fxml");
            stage.close();
        }
            //checks for Coordinator login
        if(coordinatorModel.getSpecificCoordinator(lblUsername.getText(), lblPassword.getText()) != null){
            saveCoordinator(lblUsername.getText(),lblPassword.getText());

            SceneSwapper sceneSwapper = new SceneSwapper();
            sceneSwapper.coordinatorMainScreen(new Stage());

            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.close();

        }

        // checks for user login
        if(lblUsername.getText().toLowerCase(Locale.ROOT).equals("user") && lblPassword.getText().toLowerCase(Locale.ROOT).equals("user")){

            SceneSwapper sceneSwapper = new SceneSwapper();
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setResizable(false);
            sceneSwapper.sceneSwitch(stage, "UserScreen.fxml");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        coordinatorModel = new CoordinatorModel();
    }

    /**
     * saves the coordinator that logged in on the program in a file.
     */
    private void saveCoordinator(String username , String password) throws IOException {
        File file = new File("DATA/Coordinator");
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);

        bw.write(username);
        bw.newLine();
        bw.write(password);
        bw.flush();

    }

}
