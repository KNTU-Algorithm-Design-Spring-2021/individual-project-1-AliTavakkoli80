package ir.ac.kntu;

import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.util.Random;

import static javafx.scene.paint.Color.*;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        // root node of scene graph
        Pane pane = new Pane();
//        Rectangle rectangle = ne
        // create and add a circle to the pane
        int px[], py[], cells = 50, size = 600;
        int n = 0;
        Color randColor[];
        Random rand = new Random();
        px = new int[cells];
        py = new int[cells];
        randColor = new Color[cells];
        for (int i = 0; i < cells; i++) {
            px[i] = rand.nextInt(size);
            py[i] = rand.nextInt(size);
            randColor[i] = Color.rgb(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255));
        }

        for (int x = 0; x < size; x++) {

            for (int y = 0; y < size; y++) {
                n = 0;
                for (byte i = 0; i < cells; i++) {
                    if (distance(px[i], x, py[i], y) < distance(px[n], x, py[n], y)) {
                        n = i;

                    }
                }
                Circle circle1 = new Circle(x, y, 1, randColor[n]);;
                pane.getChildren().add(circle1);

            }
        }

        for (int i = 0; i < cells; i++) {
            Circle circle1 = new Circle(px[i], py[i], 3, BLACK);;
            pane.getChildren().add(circle1);
        }

//         scene to be shown on stage
        Scene scene = new Scene(pane,size,size, LIGHTSTEELBLUE);

        // set a cool name for stage
        stage.setTitle("Javafx Starter");

        // now give the scene to the stage for show
        stage.setScene(scene);

        // and now ... put up a SHOW
        stage.show();
    }
    static double distance(int x1, int x2, int y1, int y2) {
        double d;
        d = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2)); // Euclidian
//          d = Math.abs(x1 - x2) + Math.abs(y1 - y2); // Manhattan
//          d = Math.pow(Math.pow(Math.abs(x1 - x2), p) + Math.pow(Math.abs(y1 - y2), p), (1 / p)); // Minkovski
        return d;
    }
}
