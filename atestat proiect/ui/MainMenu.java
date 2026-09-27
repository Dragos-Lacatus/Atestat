package ui;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import logic.ButtonCreator;

public class MainMenu {
    private Pane frame;

    public MainMenu(Pane frame) {
        this.frame = frame;
    }

    public void showMainMenu() {
        Image rectangle = new Image("file:grafica//rectangle.png");

        final int MAXSIZE = 5;
        ImageView[] rectangleArmy = new ImageView[MAXSIZE];

        for (int i = 0; i < MAXSIZE; i++) {
            ImageView rectangleView = new ImageView(rectangle);
            rectangleView.setX(70);
            rectangleView.setFitWidth(512);
            rectangleView.setFitHeight(200);
            rectangleView.setY(i * 225 + 50);
            rectangleArmy[i] = rectangleView;
            frame.getChildren().add(rectangleView);
        }

        Image cereal = new Image("file:grafica//cereal.png");
        ImageView cerealView = new ImageView(cereal);
        cerealView.setX(70);
        cerealView.setY(50);
        frame.getChildren().add(cerealView);

        Label cerealLabel = new Label("Lapte cu cereale");
        cerealLabel.setLayoutX(cerealView.getX() + 96);
        cerealLabel.setLayoutY(cerealView.getY());
        cerealLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        frame.getChildren().add(cerealLabel);

        final int ROWS = 4;
        final int COLS = 2;
        Button[][] buttonMatrix = new Button[ROWS][COLS];
        GridPane gridPane = new GridPane();

        gridPane.setVgap(190);
        gridPane.setHgap(10);
        gridPane.setLayoutX(385);
        gridPane.setLayoutY(165);

        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                Button button = new Button();
                if(col==0){
                    button = ButtonCreator.createButton("file:grafica//recipe button.png", 80, 30, 0, 0, "Rețetă", 20, Color.BLACK);
                } else{
                    button = ButtonCreator.createButton("file:grafica//minigame button.png", 80, 30, 0, 0, "Joc", 20, Color.BLACK);
                }

                final int r = row;
                final int c = col;

                button.setOnAction(e -> {
                    System.out.println("Clicked button at row " + r + ", column " + c);
                });

                buttonMatrix[row][col] = button;
                gridPane.add(button, col, row);
            }
        }

        frame.getChildren().add(gridPane);
    }
}
