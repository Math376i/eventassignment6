package gui.util;

import gui.controller.CoordinatorScreenController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class SceneSwapper {

    private static FXMLLoader fxmlLoaderCoordinatorScreen;

        /**
         * switches the stage to a certain fxml file.
         * @param stage of stage wanted to be shown.
         * @param fxmlClassName the file that wanted to be shown
         */
        public void sceneSwitch(Stage stage, String fxmlClassName) throws IOException {

            URL url = new File("eventassignment7/src/gui/view/" + fxmlClassName).toURI().toURL();
            Parent scene = FXMLLoader.load(url);

            Scene ViewScene = new Scene(scene);
            stage.setTitle("Ticket Master");
            //Image image = new Image("/gui/Images/icon.png");
            //stage.getIcons().add(image);
            stage.setScene(ViewScene);
            stage.show();

        }

        public void coordinatorMainScreen(Stage primaryStage) throws IOException {
            fxmlLoaderCoordinatorScreen = new FXMLLoader(getClass().getResource("../view/CoordinatorScreen.fxml"));
            Scene scene = new Scene(fxmlLoaderCoordinatorScreen.load());
            primaryStage.centerOnScreen();
            primaryStage.setResizable(false);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Event Manager");
            primaryStage.show();
        }

        public CoordinatorScreenController getCoordinatorController() {
            return fxmlLoaderCoordinatorScreen.getController();
        }

}

