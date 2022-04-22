package gui.controller;

import be.Coordinator;
import gui.model.CoordinatorModel;
import gui.util.SceneSwapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
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

    private SceneSwapper sceneSwapper;
    private CoordinatorModel coordinatorModel;

    private ObservableList<Coordinator> allCoordinators;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sceneSwapper = new SceneSwapper();
        coordinatorModel = new CoordinatorModel();
        allCoordinators = FXCollections.observableArrayList();
        fillTableVew();

    }

    /**
     *
     */
    public void onAddCoordinatorBtn(ActionEvent actionEvent) throws IOException {
        sceneSwapper.sceneSwitch(new Stage(), "AdminAddEventManagerScreen.fxml");
        fillTableVew();
    }

    /**
     * fills tableview with all coordinators
     */
    private void fillTableVew() {
        tcName.setCellValueFactory(new PropertyValueFactory<Coordinator, String>("Name"));
        tcUsername.setCellValueFactory(new PropertyValueFactory<Coordinator, String>("username"));
        tcPassword.setCellValueFactory(new PropertyValueFactory<Coordinator, String>("password"));
        tvCoordinators.setItems(getAllCoordinators());
    }

    /**
     * returns all coordinators
     *
     * @return
     */
    private ObservableList<Coordinator> getAllCoordinators() {
        allCoordinators.clear();
        allCoordinators.addAll(coordinatorModel.getAllCoordinators());
        return allCoordinators;

    }

    /**
     * removes a coordinator
     *
     * @param actionEvent
     */
    public void onRemoveCoordinatorBtn(ActionEvent actionEvent) {
        Alert a = new Alert(Alert.AlertType.CONFIRMATION, "You want to remove this Coordinator");
        a.showAndWait().filter(ButtonType.OK::equals).ifPresent(b -> {
            coordinatorModel.removeCoordinator(tvCoordinators.getSelectionModel().getSelectedItem());
        });
        fillTableVew();
    }

    /**
     * closes the screen and return back to the login screen
     */
    public void onLogoutBtn(ActionEvent actionEvent) throws IOException {

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        sceneSwapper.sceneSwitch(new Stage(), "Login.fxml");
        stage.close();
    }
}
