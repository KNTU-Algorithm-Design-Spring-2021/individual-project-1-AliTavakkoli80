package ir.ac.kntu;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.Random;

import static javafx.scene.paint.Color.BLACK;
import static javafx.scene.paint.Color.LIGHTSTEELBLUE;

public class Voronoi {
    private Scene voronoiScene;
    private int[] px;
    private int[] py;
    private int cells;
    private int size;
    private Color[] randColor;

    public Voronoi(int sceneSize, int cells) {
        // root node of scene graph
        this.cells = cells;
        this.size = sceneSize;
        Pane pane = new Pane();
        // create and add a circle to the pane
        int n = 0;
        Random rand = new Random();
        this.px = new int[cells];
        this.py = new int[cells];
        this.randColor = new Color[cells];
        for (int i = 0; i < cells; i++) {
            this.px[i] = rand.nextInt(size);
            this.py[i] = rand.nextInt(size);
            this.randColor[i] = Color.rgb(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
        }

        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                n = 0;
                for (byte i = 0; i < cells; i++) {
                    if (distance(px[i], x, py[i], y) < distance(px[n], x, py[n], y)) {
                        n = i;

                    }
                }
//                Rectangle rectangle = new Rectangle(x,y,1,1);
//                rectangle.setFill(randColor[n]);
                Circle circle = new Circle(x, y, 1, randColor[n]);
                pane.getChildren().add(circle);
//                pane.getChildren().add(rectangle);

            }
        }

        for (int i = 0; i < cells; i++) {
            Circle circle1 = new Circle(px[i], py[i], 3, BLACK);
            pane.getChildren().add(circle1);
        }

//         scene to be shown on stage
        this.voronoiScene = new Scene(pane, size, size, LIGHTSTEELBLUE);
    }

    private double distance(int x1, int x2, int y1, int y2) {
        double d;
        d = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2)); // Euclidian
        return d;
    }

    public Scene getVoronoiScene() {
        return voronoiScene;
    }
}
