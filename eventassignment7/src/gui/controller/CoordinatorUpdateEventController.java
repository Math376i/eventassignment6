package gui.controller;

import bll.EventManager;
import gui.App;
import javafx.event.ActionEvent;
<<<<<<< Updated upstream

public class CoordinatorUpdateEventController {

    CoordinatorScreenController coordinatorScreenController = new App().getController();
        coordinatorScreenController.();
        coordinatorScreenController.fillTableview();
}
=======
import javafx.event.Event;

import java.sql.SQLException;

public class CoordinatorUpdateEventController {


    public Event onUpdateEvent(ActionEvent actionEvent) throws SQLException {

        CoordinatorScreenController.updateEvent();
        CoordinatorScreenController.fillTableview();
    }

}
>>>>>>> Stashed changes
