package ir.ac.kntu;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
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

    /**
     * @param sceneSize size of the window
     * @param cells number of random points
     */
    public Voronoi(int sceneSize, int cells) {
        this.cells = cells;
        this.size = sceneSize;
        Pane pane = new Pane();
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
        //Coloring the scene by placing circles on each pixels
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                n = 0;
                for (int i = 0; i < cells; i++) {
                    if (distance(px[i], x, py[i], y) < distance(px[n], x, py[n], y)) {
                        n = i;
                    }
                }
                Circle circle = new Circle(x, y, 1, randColor[n]);
                pane.getChildren().add(circle);
            }
        }
        //Placing random points on pane
        for (int i = 0; i < cells; i++) {
            Circle circle1 = new Circle(px[i], py[i], 3, BLACK);
            pane.getChildren().add(circle1);
        }
        WritableImage image = pane.snapshot(new SnapshotParameters(), null);

        File file = new File("photos\\Your photo\\Voronoi.png");

        try {
            ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
        } catch (IOException e) {
            // TODO: handle exception here
        }
        this.voronoiScene = new Scene(pane, size, size, LIGHTSTEELBLUE);
    }

    /**
     * @param x1 x of the first point
     * @param x2 x of the second point
     * @param y1 y of the first point
     * @param y2 y of the second point
     * @return distance between two points
     */
    private double distance(int x1, int x2, int y1, int y2) {
        double d;
        d = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
        return d;
    }

    public Scene getVoronoiScene() {
        return voronoiScene;
    }
}
