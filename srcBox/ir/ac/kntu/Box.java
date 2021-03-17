package ir.ac.kntu;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
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

        }

        printRectCoordinates(shapes, sceneSize, SIZE);

        WritableImage image = pane.snapshot(new SnapshotParameters(), null);

        File file = new File("photosBox\\Your photo\\Box.png");

        try {
            ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
        } catch (IOException e) {
            // TODO: handle exception here
        }

        this.BoxScene = new Scene(pane, sceneSize, sceneSize, WHITE);


    }

    private boolean printRectCoordinates(ArrayList<Shapes> shapes, int sceneSize, int SIZE) {

        for (int i = 0; i < shapes.size() - 1; i++) {
            System.out.println("+< Rectangle Points Are : >+");
            Shapes shape = shapes.get(i);
            int[][] pRect = shape.getPRect();
            for (int j = 0; j < 4; j++) {
                System.out.print("[" + (pRect[j][0] - sceneSize / 2) / SIZE + " , ");
                System.out.println((-pRect[j][1] + sceneSize / 2) / SIZE + "]");
            }
        }
        return true;
    }


    public Scene getBoxScene() {
        return BoxScene;
    }
}
