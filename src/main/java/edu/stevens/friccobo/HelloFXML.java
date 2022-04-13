package edu.stevens.friccobo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class HelloFXML extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        URL resource = getClass().getResource("/hello.fxml");
        Parent root = FXMLLoader.load(resource);
        Scene scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();
    }
}
