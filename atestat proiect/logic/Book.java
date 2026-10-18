package logic;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Book {
    private int numberOfPages;
    private int currentPage;
    private Pane frame;
    public Button prevButton = new ButtonCreator().createButton("file:grafica//arrow.png", 80, 40, 380, 800, null, 0, null);
    public Button nextButton = new ButtonCreator().createButton("file:grafica//arrow.png", 80, 40, 480, 800, null, 0, null);
    private Image bookImage = new Image("file:grafica//paper.png");
    private ImageView bookImageView = new ImageView(bookImage);
    private Label label = new Label();
    public Button closeButton = new ButtonCreator().createButton("file:grafica//close button.png", 40, 40, 120, 120, null, 0, null);

    public Book(int numberOfPages, Pane frame) {
        this.numberOfPages = numberOfPages;
        this.currentPage = 1;
        this.frame = frame;
        label.setText("Pagină: 1/" + this.numberOfPages);
        prevButton.setDisable(true);

        if(this.numberOfPages == 1){
            nextButton.setDisable(true);
        }
    }


    public int getCurrentPage() {
        return this.currentPage;
    }

    public int getNumberOPages() {
        return numberOfPages;
    }

    public void nextPage() {
        currentPage++;
        if (currentPage < numberOfPages) {
            nextButton.setDisable(false);
            prevButton.setDisable(false);
        }
        else{
            nextButton.setDisable(true);
        }
    }

    public void previousPage() {
        currentPage--;
        if (currentPage > 1) {
            nextButton.setDisable(false);
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
        frame.getChildren().add(closeButton);
        frame.getChildren().add(label);
    }

    public void changePage(int pageNumber) {
        label.setText("Pagină: " + pageNumber + "/" + this.numberOfPages);
    }

    public void disappearBook(){
        frame.getChildren().remove(bookImageView);
        frame.getChildren().remove(prevButton);
        frame.getChildren().remove(nextButton);
        frame.getChildren().remove(label);
        frame.getChildren().remove(closeButton);
    }

}
