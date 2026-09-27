package logic;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class ButtonCreator {
    public static javafx.scene.control.Button createButton(String image, double width, double height, double xPos, double yPos, String text, int fontSize, Color textColor) {
        javafx.scene.control.Button button = new javafx.scene.control.Button();
        Image buttonIcon = new Image(image);
        ImageView imageView = new ImageView(buttonIcon);
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);
        button.setLayoutX(xPos);
        button.setLayoutY(yPos);
        Text buttonText = new Text(text);
        buttonText.setFont(javafx.scene.text.Font.font(fontSize));
        buttonText.setFill(textColor);
        StackPane graphicStack = new StackPane(imageView, buttonText);
        button.setGraphic(graphicStack);
        button.setBackground(Background.EMPTY);
        return button;
    }
}
