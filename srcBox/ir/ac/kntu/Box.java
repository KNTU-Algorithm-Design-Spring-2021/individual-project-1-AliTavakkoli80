package ir.ac.kntu;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;

import java.util.Arrays;

import static javafx.scene.paint.Color.*;

public class Box {
    private Scene BoxScene;
    private int[] px;
    private int[] py;
    private int[][] pRect;

    /**
     * @param sceneSize size of the window
     */
    public Box(int sceneSize, int numPoints, int[] px, int[] py) {
        Pane pane = new Pane();
        this.px = px;
        this.py = py;
        double[] pxy = new double[2 * numPoints];
        for (int i = 0; i < 2 * numPoints; i += 2) {
            pxy[i] = (double) px[i / 2];
            pxy[i + 1] = (double) py[i / 2];
        }
        Polygon polygon = new Polygon(pxy);
        pane.getChildren().add(polygon);
        this.pRect = new int[4][2];
        //Placing random points on pane
        for (int i = 0; i < numPoints; i++) {
            Circle circle = new Circle(px[i], py[i], 3, BLACK);
            pane.getChildren().add(circle);
        }

        Arrays.sort(px);
        Arrays.sort(py);

        System.out.println("y " + Arrays.toString(py));
        System.out.println("x " + Arrays.toString(px));

        this.pRect[0][0] = px[0];
        this.pRect[0][1] = py[0];

        Circle circleRectA = new Circle(pRect[0][0], pRect[0][1], 3, RED);
        pane.getChildren().add(circleRectA);

        this.pRect[1][0] = px[0];
        this.pRect[1][1] = py[numPoints - 1];

        Circle circleRectB = new Circle(pRect[1][0], pRect[1][1], 3, RED);
        pane.getChildren().add(circleRectB);

        this.pRect[2][0] = px[numPoints - 1];
        this.pRect[2][1] = py[numPoints - 1];

        Circle circleRectC = new Circle(pRect[2][0], pRect[2][1], 3, RED);
        pane.getChildren().add(circleRectC);

        this.pRect[3][0] = px[numPoints - 1];
        this.pRect[3][1] = py[0];


        Circle circleRectD = new Circle(pRect[3][0], pRect[3][1], 3, RED);
        pane.getChildren().add(circleRectD);

        Line RectAB = new Line(pRect[0][0], pRect[0][1], pRect[1][0], pRect[1][1]);
        pane.getChildren().add(RectAB);

        Line RectBC = new Line(pRect[1][0], pRect[1][1], pRect[2][0], pRect[2][1]);
        pane.getChildren().add(RectBC);

        Line RectCD = new Line(pRect[2][0], pRect[2][1], pRect[3][0], pRect[3][1]);
        pane.getChildren().add(RectCD);

        Line RectDA = new Line(pRect[3][0], pRect[3][1], pRect[0][0], pRect[0][1]);
        pane.getChildren().add(RectDA);

        this.BoxScene = new Scene(pane, sceneSize, sceneSize, WHITE);

        for (int i = 0; i < 4; i++) {
            System.out.print("[" + (pRect[i][0] - sceneSize / 2) + " , ");
            System.out.println((-pRect[i][1] + sceneSize / 2) + "]");
        }
    }


    public Scene getBoxScene() {
        return BoxScene;
    }
}
