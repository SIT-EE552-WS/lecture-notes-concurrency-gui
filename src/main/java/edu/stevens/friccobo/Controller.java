package edu.stevens.friccobo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class Controller {
    int count = 0;

    @FXML
    Label resultLabel;

    public void increment(ActionEvent actionEvent) {
        count++;
        resultLabel.setText("Clicked " + count + " times");
    }
}
