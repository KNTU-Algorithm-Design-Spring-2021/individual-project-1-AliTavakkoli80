package ir.ac.kntu;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;

import java.util.ArrayList;
import java.util.Arrays;

import static javafx.scene.paint.Color.*;

public class Shapes {
    private int numPointsPolygon;
    private int[] px;
    private int[] py;
    private ArrayList<Circle> pointsOfRect;
    private int[][] pRect;
    private ArrayList<Line> lRect;
    private Polygon polygon;
    private ArrayList<Circle> polygonPoints;

    /**
     * @param sceneSize size of the window
     */
    public Shapes(int sceneSize, int numPoints, int[] px, int[] py, int SIZE) {
        this.numPointsPolygon = numPoints;
        this.px = px;
        this.py = py;
        this.pointsOfRect = new ArrayList<Circle>(4);
        this.lRect = new ArrayList<Line>(4);
        double[] pxy = new double[2 * numPoints];
        for (int i = 0; i < 2 * numPoints; i += 2) {
            pxy[i] = (double) px[i / 2];
            pxy[i + 1] = (double) py[i / 2];
        }

        this.polygonPoints = new ArrayList<Circle>();
        this.polygon = new Polygon(pxy);
        polygon.setFill(BLUEVIOLET);
        polygon.setFill(BLUE);


        this.pRect = new int[4][2];
        //Placing random points on pane
        for (int i = 0; i < numPoints; i++) {
            this.polygonPoints.add(new Circle(px[i], py[i], 3, BLACK));
        }

        Arrays.sort(px);
        Arrays.sort(py);

        this.pRect[0][0] = px[0];
        this.pRect[0][1] = py[0];

        Circle circleRectA = new Circle(pRect[0][0], pRect[0][1], 3, RED);
        this.pointsOfRect.add(circleRectA);

        this.pRect[1][0] = px[0];
        this.pRect[1][1] = py[numPoints - 1];

        Circle circleRectB = new Circle(pRect[1][0], pRect[1][1], 3, RED);
        this.pointsOfRect.add(circleRectB);

        this.pRect[2][0] = px[numPoints - 1];
        this.pRect[2][1] = py[numPoints - 1];

        Circle circleRectC = new Circle(pRect[2][0], pRect[2][1], 3, RED);
        this.pointsOfRect.add(circleRectC);

        this.pRect[3][0] = px[numPoints - 1];
        this.pRect[3][1] = py[0];

        Circle circleRectD = new Circle(pRect[3][0], pRect[3][1], 3, RED);
        this.pointsOfRect.add(circleRectD);

        Line rectAB = new Line(pRect[0][0], pRect[0][1], pRect[1][0], pRect[1][1]);
        rectAB.setStroke(GREEN);
        this.lRect.add(rectAB);

        Line rectBC = new Line(pRect[1][0], pRect[1][1], pRect[2][0], pRect[2][1]);
        rectBC.setStroke(GREEN);
        this.lRect.add(rectBC);

        Line rectCD = new Line(pRect[2][0], pRect[2][1], pRect[3][0], pRect[3][1]);
        rectCD.setStroke(GREEN);
        this.lRect.add(rectCD);

        Line rectDA = new Line(pRect[3][0], pRect[3][1], pRect[0][0], pRect[0][1]);
        rectDA.setStroke(GREEN);
        this.lRect.add(rectDA);


        System.out.println("+< Rectangle Points Are : >+");

        for (int i = 0; i < 4; i++) {
            System.out.print("[" + (pRect[i][0] - sceneSize / 2) / SIZE + " , ");
            System.out.println((-pRect[i][1] + sceneSize / 2) / SIZE + "]");
        }
    }

    public ArrayList<Circle> getPointsOfRect() {
        return pointsOfRect;
    }

    public ArrayList<Line> getLRect() {
        return lRect;
    }

    public Polygon getPolygon() {
        return polygon;
    }

    public ArrayList<Circle> getPolygonPoints() {
        return polygonPoints;
    }

    public int[][] getPRect(){
        return pRect;
    }

    public int getNumPointsPolygon() {
        return numPointsPolygon;
    }
}
