package gui.util;

import be.Coordinator;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class SceneSwapper {

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
    }

