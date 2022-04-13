package edu.stevens.friccobo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicInteger;

public class HelloFX extends Application {
    final AtomicInteger count = new AtomicInteger();

    @Override
    public void start(Stage stage) throws Exception {
        String message = "Hello World";

        VBox vBox = new VBox();
        Label label = new Label(message);
        Label label2 = new Label("I am happy to see you");
        Label label3 = new Label("Some third message");
        Button button = new Button();
        button.setText("Click Me!");
        button.setOnAction(
                actionEvent -> {
                    int i = count.incrementAndGet();
                    label3.setText("Clicked " + i + " times");
                }
        );
        vBox.getChildren().add(label);
        vBox.getChildren().add(label2);
        vBox.getChildren().add(label3);
        vBox.getChildren().add(button);
        Scene scene = new Scene(
                new StackPane(vBox),
                640,
                480
        );
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
