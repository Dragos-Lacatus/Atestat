package ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import logic.Scrolling_Logic;
import logic.Transition;
import logic.ButtonCreator;

public class TitleScreen extends Application {
    @Override
    public void start(Stage stage) {

        Pane frame = new Pane();
        frame.setPrefSize(640, 960);
        stage.setScene(new Scene(frame));
        stage.setTitle("Atestat proiect");
        stage.setResizable(false);

        Scrolling_Logic scrollingLogic = new Scrolling_Logic(frame);
        scrollingLogic.scrollImage("file:grafica//red tile.png");

        Button startButton = ButtonCreator.createButton("file:grafica//button.png", 100, 50, 270, 320, "Start", 40, Color.WHITE);
        frame.getChildren().add(startButton);

        startButton.setOnAction(e -> {
            startButton.setVisible(false);
            Transition transition = new Transition(frame);
            transition.transitionTo();
        });

        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}