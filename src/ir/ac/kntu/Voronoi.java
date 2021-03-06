package ir.ac.kntu;

import javafx.geometry.Point2D;
import java.util.Random;

public class Voronoi {
    private static int cells = 100, size = 1000;
    Point2D randomPoints[];

    public Voronoi() {
        randomPoints = new Point2D[cells];
        Random rand = new Random();
        for (int i = 0; i < cells; i++) {
            this.randomPoints[i].add((double)rand.nextInt(size),(double)rand.nextInt(size));
        }
    }

}
