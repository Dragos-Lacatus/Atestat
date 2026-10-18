package Food;

import logic.Transition;
import javafx.scene.control.Label;
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

        cerealBook.closeButton.setOnAction(e ->{
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

    public void minigame(){
        Transition transition = new Transition(frame);
        transition.transitionTo(20, "file:grafica//green tile.png", false);
        System.out.println("yaysggdcvb");
    }
}
