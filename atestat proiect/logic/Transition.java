package logic;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Transition {
    private Pane frame;

    public Transition(Pane frame) {
        this.frame = frame;
    }

    public void transitionTo() {
        Image spike = new Image("file:grafica//spike.png");
        Image square = new Image("file:grafica//black square.png");
        final int ROWS = 21;
        final int COLS = 30;
        final double SPEED = 6;
        ImageView[][] views = new ImageView[ROWS][COLS];
        int totalWidth = 640;

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (i == ROWS - 1) {
                    views[i][j] = new ImageView(spike);
                } else {
                    views[i][j] = new ImageView(square);
                }
                views[i][j].setX(i * 32 - totalWidth - 32);
                views[i][j].setY(j * 32);
                frame.getChildren().add(views[i][j]);
            }
        }
        Scrolling_Logic scrollingLogic = new Scrolling_Logic(frame);

        AnimationTimer loopTimer = new AnimationTimer() {

            boolean reachEdgeScreen = false;

            public void handle(long now) {
                double newX;

                for (int i = 0; i < ROWS; i++) {
                    for (int j = 0; j < COLS; j++) {
                        if (!reachEdgeScreen) {
                            newX = views[i][j].getX() + SPEED;
                            views[i][j].setX(newX);
                        } else {
                            newX = views[i][j].getX() - SPEED;
                            views[i][j].setX(newX);
                        }
                    }
                }

                if (views[20][29].getX() >= totalWidth) {
                    reachEdgeScreen = true;
                    scrollingLogic.scrollImage("file:grafica//blue tile.png");
                    
                    for (int i = 0; i < ROWS; i++) {
                        for (int j = 0; j < COLS; j++) {
                            if (i == ROWS - 1) {
                                views[i][j] = new ImageView(spike);
                            } else {
                                views[i][j] = new ImageView(square);
                            }

                            views[i][j].setX(i * 32);
                            views[i][j].setY(j * 32);
                            frame.getChildren().add(views[i][j]);
                        }
                    }
                }
            }
        };
        loopTimer.start();

    }
}
