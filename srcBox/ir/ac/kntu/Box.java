package ir.ac.kntu;

import javafx.css.Style;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
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
    public Box(int sceneSize, int numPoints, int[] px, int[] py, int SIZE) {
        Pane pane = new Pane();

        for (int i = 0; i < sceneSize; i+=SIZE) {
            Line ys = new Line(i,0,i,sceneSize);
            ys.setStroke(GRAY);
            Line xs = new Line(0,i,sceneSize,i);
            xs.setStroke(GRAY);
            pane.getChildren().addAll(xs,ys);
        }

        Line yAsix = new Line(sceneSize/2,0,sceneSize/2,sceneSize);
        yAsix.setStroke(BLACK);
        Line xAsix = new Line(0,sceneSize/2,sceneSize,sceneSize/2);
        xAsix.setStroke(BLACK);
        pane.getChildren().addAll(xAsix,yAsix);

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

        Line rectAB = new Line(pRect[0][0], pRect[0][1], pRect[1][0], pRect[1][1]);
        rectAB.setStroke(GREEN);
        pane.getChildren().add(rectAB);

        Line rectBC = new Line(pRect[1][0], pRect[1][1], pRect[2][0], pRect[2][1]);
        rectBC.setStroke(GREEN);
        pane.getChildren().add(rectBC);

        Line rectCD = new Line(pRect[2][0], pRect[2][1], pRect[3][0], pRect[3][1]);
        rectCD.setStroke(GREEN);
        pane.getChildren().add(rectCD);

        Line rectDA = new Line(pRect[3][0], pRect[3][1], pRect[0][0], pRect[0][1]);
        rectDA.setStroke(GREEN);
        pane.getChildren().add(rectDA);

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
