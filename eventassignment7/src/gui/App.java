package gui;

import gui.controller.CoordinatorScreenController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args){
        launch(args);
    }
    private static FXMLLoader fxmlLoaderMain;
    @Override
    public void start(Stage primaryStage) throws Exception {
        fxmlLoaderMain = new FXMLLoader(getClass().getResource("view/Login.fxml"));
        primaryStage.centerOnScreen();
        Scene scene = new Scene(fxmlLoaderMain.load());
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Event Manager");
        primaryStage.show();
    }
    public CoordinatorScreenController getController() {
        return fxmlLoaderMain.getController();
    }
}