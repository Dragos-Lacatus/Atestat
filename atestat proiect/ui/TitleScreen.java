package ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import logic.Scrolling_Logic;
import logic.Transition;

public class TitleScreen extends Application {
    @Override
    public void start(Stage stage) {

        Pane frame = new Pane();
        frame.setPrefSize(640, 960);
        stage.setScene(new Scene(frame));
        stage.setTitle("Atestat proiect");
        stage.setResizable(false);
        Button startButton = new Button("Start");
        Scrolling_Logic scrollingLogic = new Scrolling_Logic(frame);
        scrollingLogic.scrollImage("file:grafica//red tile.png");
        startButton.setLayoutX(270);
        startButton.setLayoutY(450);
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