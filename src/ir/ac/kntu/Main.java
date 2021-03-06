package ir.ac.kntu;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import static javafx.scene.paint.Color.LIGHTSTEELBLUE;

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
        Circle circle1 = new Circle(300, 300, 300, Color.GREEN);
        Circle circle2 = new Circle(300,300,200,Color.WHITE);
        Circle circle3 = new Circle(300,300,100,Color.RED);
        pane.getChildren().add(circle1);
        pane.getChildren().add(circle2);
        pane.getChildren().add(circle3);
//         scene to be shown on stage
        Scene scene = new Scene(pane,600,600, LIGHTSTEELBLUE);

        // set a cool name for stage
        stage.setTitle("Javafx Starter");

        // now give the scene to the stage for show
        stage.setScene(scene);

        // and now ... put up a SHOW
        stage.show();
    }
}
