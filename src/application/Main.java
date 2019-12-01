package application;

import application.Utilities.Load;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;


    /**
     * Constructs a window
     * @param primaryStage Stage for window
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception{
        stage.setTitle("Space Game");
        stage.setResizable(false);
        stage.getIcons().add(new Image("file:Resources/Default/Player.png"));
        //background size
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        //JavaFX Timeline = free form animation defined by KeyFrames and their duration
        Timeline tl = new Timeline(new KeyFrame(Duration.millis(10), e -> run(gc)));
        //number of cycles in animation INDEFINITE = repeat indefinitely
        tl.setCycleCount(Timeline.INDEFINITE);

        Load.loadGsm();

        stage.setScene(new Scene(new StackPane(canvas)));
        stage.show();
        //mouse control (move and click)
        canvas.requestFocus();
        canvas.setOnKeyPressed(e -> Load.gsm.keyPressed(e.getCode().getCode()));
        canvas.setOnKeyReleased(e -> Load.gsm.keyReleased(e.getCode().getCode()));
        tl.play();
    }


    private void run(GraphicsContext gc) {
        Load.gsm.update();
        Load.gsm.draw(gc);
    }
    /**
     *  Launches the program
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
