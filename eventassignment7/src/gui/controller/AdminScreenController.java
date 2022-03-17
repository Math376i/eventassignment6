package gui.controller;

import be.Coordinator;
import gui.model.CoordinatorModel;
import gui.util.SceneSwapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AdminScreenController implements Initializable {


    // table view
    @FXML
    private TableView<Coordinator> tvCoordinators;
    // all tablecolumn
    @FXML
    private TableColumn<Coordinator, String> tcName;
    @FXML
    private TableColumn<Coordinator, String> tcUsername;
    @FXML
    private TableColumn<Coordinator, String> tcPassword;
    @FXML
    private TableColumn<Coordinator, String> tcEvent;

    CoordinatorModel coordinatorModel;

    private ObservableList<Coordinator> allCoordinators;

    public void onAddCoordinatorBtn(ActionEvent actionEvent) throws IOException {
        SceneSwapper sceneSwapper = new SceneSwapper();
        sceneSwapper.sceneSwitch(new Stage(), "AdminAddEventManagerScreen.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        coordinatorModel = new CoordinatorModel();
        allCoordinators = FXCollections.observableArrayList();
        fillTableVew();

    }

    /**
     * fills tableview with all coordinators
     */
    private void fillTableVew(){
        tcName.setCellValueFactory(new PropertyValueFactory<Coordinator, String>("Name"));
        tcUsername.setCellValueFactory(new PropertyValueFactory<Coordinator, String>("username"));
        tcPassword.setCellValueFactory(new PropertyValueFactory<Coordinator, String>("password"));
        tcEvent.setCellValueFactory(new PropertyValueFactory<Coordinator, String>("event"));
        tvCoordinators.setItems(getAllCoordinators());
    }

    /**
     * returns all coordinators
     * @return
     */
    private ObservableList<Coordinator> getAllCoordinators(){
        allCoordinators.clear();
        allCoordinators.addAll(coordinatorModel.getAllCoordinators());
        return allCoordinators;

    }

    /**
     * removes a coordinator
     * @param actionEvent
     */
    public void onRemoveCoordinatorBtn(ActionEvent actionEvent) {
        Alert a = new Alert(Alert.AlertType.CONFIRMATION, "You want to remove this Coordinator");
        a.showAndWait().filter(ButtonType.OK::equals).ifPresent(b -> {
            coordinatorModel.removeCoordinator(tvCoordinators.getSelectionModel().getSelectedItem());
        });
        fillTableVew();
    }
}
