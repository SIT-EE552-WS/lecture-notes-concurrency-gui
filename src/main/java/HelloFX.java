import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;

import java.util.concurrent.atomic.AtomicInteger;

// Swing
// AWT = abstract window toolkit

public class HelloFX extends Application {
  @Override
  public void start(Stage stage) throws Exception {

    String javaVersion = System.getProperty("java.version");
    String javafxVersion = System.getProperty("javafx.version");
    final String string = String.format("Hello, JavaFX %s, running on Java %s.", javafxVersion, javaVersion);
    Button button = new Button(string);
    AtomicInteger count = new AtomicInteger(0);
    button.setOnAction(
        actionEvent -> {
          System.out.println(actionEvent.getEventType());
          button.setText("The button was clicked " + (count.getAndIncrement()) + " times");
        }
    );
    final GridPane gridPane = new GridPane();
    gridPane.setAlignment(Pos.CENTER);
    gridPane.setHgap(10);
    gridPane.setVgap(10);
    gridPane.setPadding(new Insets(25, 25, 25, 25));

//    gridPane.add(button, 0, 0, 2, 1);
    gridPane.add(new Label("Username"), 0, 1, 1, 1);
    gridPane.add(new Label("Password"), 0, 2, 1, 1);
    final TextField usernameInput = new TextField();
    gridPane.add(usernameInput, 1, 2, 1, 1);
    final TextField passwordInput = new TextField();
    usernameInput.setOnInputMethodTextChanged(event->{
      System.out.println(event.getCommitted());
    });
    gridPane.add(passwordInput, 1, 1, 1, 1);
    gridPane.add(new Button("Login"), 1, 3, 1, 1);

    Scene scene = new Scene(gridPane, 640, 480);

    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch();
  }
}
