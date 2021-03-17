package ir.ac.kntu;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;

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

        for (int i = 0; i < sceneSize; i += SIZE) {
            Line ys = new Line(i, 0, i, sceneSize);
            ys.setStroke(GRAY);
            Line xs = new Line(0, i, sceneSize, i);
            xs.setStroke(GRAY);
            pane.getChildren().addAll(xs, ys);
        }

        Line yAsix = new Line(sceneSize / 2, 0, sceneSize / 2, sceneSize);
        yAsix.setStroke(BLACK);
        Line xAsix = new Line(0, sceneSize / 2, sceneSize, sceneSize / 2);
        xAsix.setStroke(BLACK);
        pane.getChildren().addAll(xAsix, yAsix);

        Shapes shape = new Shapes(sceneSize, numPoints, px, py, SIZE);
        for (int i = 0; i < 4; i++) {
            pane.getChildren().add(shape.getLRect().get(i));
            pane.getChildren().add(shape.getPointsOfRect().get(i));
        }
        for (int i = 0; i < numPoints; i++) {
            pane.getChildren().add(shape.getPolygonPoints().get(i));
        }
        pane.getChildren().addAll(shape.getPolygon());

        this.BoxScene = new Scene(pane, sceneSize, sceneSize, WHITE);

        System.out.println("+< Rectangle Points Are : >+");

        int[][] pRect = shape.getPRect();

        for (int i = 0; i < 4; i++) {
            System.out.print("[" + (pRect[i][0] - sceneSize / 2)/SIZE + " , ");
            System.out.println((-pRect[i][1] + sceneSize / 2)/SIZE + "]");
        }
    }


    public Scene getBoxScene() {
        return BoxScene;
    }
}
