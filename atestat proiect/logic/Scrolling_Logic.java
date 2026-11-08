
package logic;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import java.util.ArrayList;
import java.util.List;

public class Scrolling_Logic {
    private static final String ACTIVE_SCROLLING_KEY = Scrolling_Logic.class.getName() + ".activeScrolling";
    private Pane frame;

    public Scrolling_Logic(Pane frame) {
        this.frame = frame;
    }

    public void scrollImage(String tile){
        Object previous = frame.getProperties().remove(ACTIVE_SCROLLING_KEY);
        if (previous instanceof ScrollingAnimation) {
            ((ScrollingAnimation) previous).stop(frame);
        }

        Image imageFile = new Image(tile);
        final int ROWS = 21;
        final int COLS = 31;
        final double SPEED = 0.3;
        ImageView[][] views = new ImageView[ROWS][COLS];
        List<ImageView> backgroundTiles = new ArrayList<>(ROWS * COLS);

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                ImageView imageView = new ImageView(imageFile);
                imageView.setX(i * 32 + 32);
                imageView.setY(j * 32 - 32); 

                views[i][j] = imageView;
                backgroundTiles.add(imageView);
                frame.getChildren().add(0, imageView);
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
        frame.getProperties().put(ACTIVE_SCROLLING_KEY, new ScrollingAnimation(loopTimer, backgroundTiles));
    }

    private static class ScrollingAnimation {
        private final AnimationTimer timer;
        private final List<ImageView> tiles;

        private ScrollingAnimation(AnimationTimer timer, List<ImageView> tiles) {
            this.timer = timer;
            this.tiles = tiles;
        }

        private void stop(Pane frame) {
            timer.stop();
            frame.getChildren().removeAll(tiles);
        }
    }
}
