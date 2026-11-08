package Food;

import logic.Transition;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.FontWeight;
import logic.Book;

public class Cereal {
    private Book cerealBook;
    private Pane frame;
    private Label label;

    public Cereal(Pane frame) {
        this.frame = frame;
        cerealBook = new Book(1, frame);
        label = new Label();
    }

    public void startRecipe() {
        cerealBook.appearBook();
        label.fontProperty().setValue(javafx.scene.text.Font.font("Arial", FontWeight.BOLD, 18));
        label.setLayoutX(150);
        label.setLayoutY(180);
        label.setWrapText(true);
        label.setLineSpacing(35);
        updateLabelText(cerealBook.getCurrentPage());
        frame.getChildren().add(label);

        cerealBook.closeButton.setOnAction(e -> {
            cerealBook.disappearBook();
            frame.getChildren().remove(label);
        });

        cerealBook.nextButton.setOnAction(e -> {
            cerealBook.nextPage();
            cerealBook.changePage(cerealBook.getCurrentPage());
            updateLabelText(cerealBook.getCurrentPage());

        });

        cerealBook.prevButton.setOnAction(e -> {
            cerealBook.previousPage();
            cerealBook.changePage(cerealBook.getCurrentPage());
            updateLabelText(cerealBook.getCurrentPage());
        });

    }

    private void updateLabelText(int pageNumber) {
        switch (pageNumber) {
            case 1:
                label.setText("                         INGREDIENTE\r\n" + //
                        "\r\n" + //
                        "* 800 grame de lapte\r\n" + //
                        "* 125 grame de cereale (la alegere)\r\n" + //
                        "\r\n" + //
                        "\t     \t                 PAȘI\r\n" + //
                        "Se pun inițial cerealele în bol.\r\n" + //
                        "Apoi se pune laptele în bol.\r\n" + //
                        "(Opțional) Încălziți bolul la un minut la cuptorul \r\n" + //
                        "cu microunde.\r\n" + //
                        "SFÂRȘIT");
                break;
        }
    }

    public void minigameOne() {
        Image image = new Image("file:grafica//bowl.png");
        ImageView bowl = new ImageView(image);
        bowl.setFitWidth(200);
        bowl.setX(225);
        bowl.preserveRatioProperty().set(true);
        bowl.setY(450);

        Image image2 = new Image("file:grafica//cereal ball.png");
        ImageView cerealBall = new ImageView(image2);
        cerealBall.setX(125);
        cerealBall.setY(50);

        Transition transition = new Transition(frame);
        transition.transitionTo(40, "file:grafica//green tile.png", false);

        AnimationTimer loopTimer = new AnimationTimer() {
            private boolean gameStarted;
            private double speed;
            private boolean falling;
            private double speedAux;

            @Override
            public void handle(long now) {
                if (transition.OK && !gameStarted) {
                    frame.getChildren().add(bowl);
                    frame.getChildren().add(cerealBall);
                    gameStarted = true;
                    transition.OK = false;
                    speedAux = 2;
                }

                if (gameStarted) {

                    if (!falling) {
                        speed = speedAux;
                        cerealBall.setX(cerealBall.getX() + speed);
                        if (cerealBall.getX() >= 610 || cerealBall.getX() <= 0) {
                            speedAux = -speedAux;
                        }
                    }

                    if(falling) {
                        speed = 0;
                        cerealBall.setY(cerealBall.getY() + 10);
                        
                        if(cerealBall.getBoundsInParent().intersects(bowl.getBoundsInParent())){
                            cerealBall.setY(50);
                            falling = false;
                        }

                        if(cerealBall.getY()>960){
                            cerealBall.setY(50);
                            falling = false;
                        }
                    }

                    frame.setOnMousePressed(event -> {
                        if(!falling){
                            speedAux = speed;
                            falling = true;
                        }
                    });
                }

            }

        };
        loopTimer.start();
    }
}
