
package logic;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Scrolling_Logic {
    private Pane frame;

    public Scrolling_Logic(Pane frame) {
        this.frame = frame;
    }

    public void scrollImage(String tile){
        Image imageFile = new Image(tile);
        final int ROWS = 21;
        final int COLS = 31;
        final double SPEED = 0.3;
        ImageView[][] views = new ImageView[ROWS][COLS];

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                ImageView imageView = new ImageView(imageFile);
                imageView.setX(i * 32 + 32);
                imageView.setY(j * 32 - 32); 

                views[i][j] = imageView;
                frame.getChildren().add(imageView);
            }
        }

       
        int totalHeight = COLS * 32;
        int totalWidth = ROWS * 32;
        AnimationTimer loopTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                for (int i = 0; i < ROWS; i++) {
                    for (int j = 0; j < COLS; j++) {
                        ImageView tile = views[i][j];
                        
                        double newY = tile.getY() + SPEED;
                        double newX = tile.getX() + SPEED;

                        if (newY >= totalHeight -32) { 
                            newY -= totalHeight; 
                        }
                        if (newX >= totalWidth -32) { 
                            newX -= totalWidth; 
                        }

                        tile.setY(newY);
                        tile.setX(newX);
                        
                    }
                }
            }
        };
        loopTimer.start();
    }
}
