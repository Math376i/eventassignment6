package gui.controller;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class CoordinatorAddTicketController {

    public TextField lblEventName;
    public PasswordField lblAddress;

    public void OnCreateTicket(ActionEvent actionEvent) {

    }



    /**
     * Closes the stage
     */
    public void onClose(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }
}
