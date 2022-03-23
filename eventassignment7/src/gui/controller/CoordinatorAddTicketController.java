package gui.controller;
import gui.model.CoordinatorModel;
import gui.model.TicketModel;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class CoordinatorAddTicketController {

    public TextField lblEventName;
    public PasswordField lblAddress;
private CoordinatorModel coordinatorModel;
    public void OnCreateTicket(ActionEvent actionEvent) {
        try {

            TicketModel.createTicket(lblEventName.getText(), lblAddress.getText());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.close();
        }catch (Exception exp){
            exp.fillInStackTrace();
        }
    }



    /**
     * Closes the stage
     */
    public void onClose(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }
}
