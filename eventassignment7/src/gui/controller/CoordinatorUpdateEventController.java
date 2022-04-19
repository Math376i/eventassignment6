package gui.controller;

import be.Event;
import bll.EventManager;
import gui.App;
import javafx.event.ActionEvent;

import java.sql.SQLException;


public class CoordinatorUpdateEventController {

    CoordinatorScreenController coordinatorScreenController = new App().getController();
        coordinatorScreenController.getEvents();
        coordinatorScreenController.fillTableview();
}



