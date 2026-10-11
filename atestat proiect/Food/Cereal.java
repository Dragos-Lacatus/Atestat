package Food;
import javafx.scene.layout.Pane;
import logic.Book;

public class Cereal {
    private Book cerealBook;
    private Pane frame;

    public Cereal(Pane frame){
        this.frame = frame;
        cerealBook = new Book(5, frame);
    }

    public void startRecipe(){
        cerealBook.appearBook();
        cerealBook.nextButton.setOnAction(e->{
            cerealBook.nextPage();
            cerealBook.changePage(cerealBook.getCurrentPage());
        });
    }
}
