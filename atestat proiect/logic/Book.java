package logic;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Book {
    private int numberOfpages;
    private int currentPage;
    private Pane frame;
    public Button prevButton = new ButtonCreator().createButton("file:grafica//arrow.png", 80, 40, 380, 800, null, 0, null);
    public Button nextButton = new ButtonCreator().createButton("file:grafica//arrow.png", 80, 40, 480, 800, null, 0, null);
    private Image bookImage = new Image("file:grafica//paper.png");
    private ImageView bookImageView = new ImageView(bookImage);
    private Label label = new Label();

    public Book(int numberOfpages, Pane frame) {
        this.numberOfpages = numberOfpages;
        this.currentPage = 1;
        this.frame = frame;
        label.setText("Pagină: 1/" + this.numberOfpages);
    }


    public int getCurrentPage() {
        return this.currentPage;
    }

    public int getNumberOfpages() {
        return numberOfpages;
    }

    public void nextPage() {
        if (currentPage < numberOfpages) {
            currentPage++;
            nextButton.setDisable(false);
        }
        else{
            nextButton.setDisable(true);
        }
    }

    public void previousPage() {
        if (currentPage > 1) {
            currentPage--;
            prevButton.setDisable(false);
        } else {
            prevButton.setDisable(true);
        }
    }

    public void appearBook(){
        bookImageView.setX(75);
        bookImageView.setY(-150);
        bookImageView.setFitWidth(500);
        bookImageView.setPreserveRatio(true);
        frame.getChildren().add(bookImageView); 
        frame.getChildren().add(prevButton);
        nextButton.setRotate(180);
        frame.getChildren().add(nextButton);
        label.setLayoutX(150);
        label.setLayoutY(850);
        label.fontProperty().setValue(javafx.scene.text.Font.font("Arial", 20));
        frame.getChildren().add(label);
    }

    public void changePage(int pageNumber) {
        label.setText("Pagină: " + pageNumber + "/" + this.numberOfpages);
    }

}
