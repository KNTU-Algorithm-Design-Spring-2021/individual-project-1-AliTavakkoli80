package ir.ac.kntu;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;

import java.util.ArrayList;

import static javafx.scene.paint.Color.*;

public class Box {
    private Scene BoxScene;
    private int[] px;
    private int[] py;
    private int[][] pRect;


    /**
     * @param sceneSize size of the window
     */
    public Box(int sceneSize, ArrayList<Shapes> shapes, int SIZE) {
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
        for (int i = 0; i < shapes.size(); i++) {
            Shapes shape = shapes.get(i);
            for (int j = 0; j < 4; j++) {
                pane.getChildren().add(shape.getLRect().get(j));
                pane.getChildren().add(shape.getPointsOfRect().get(j));
            }
            for (int j = 0; j < shape.getNumPointsPolygon(); j++) {
                pane.getChildren().add(shape.getPolygonPoints().get(j));
            }
            pane.getChildren().addAll(shape.getPolygon());

            System.out.println("+< Rectangle Points Are : >+");

            int[][] pRect = shape.getPRect();

            for (int j = 0; j < 4; j++) {
                System.out.print("[" + (pRect[j][0] - sceneSize / 2)/SIZE + " , ");
                System.out.println((-pRect[j][1] + sceneSize / 2)/SIZE + "]");
            }
        }
        this.BoxScene = new Scene(pane, sceneSize, sceneSize, WHITE);


    }


    public Scene getBoxScene() {
        return BoxScene;
    }
}
