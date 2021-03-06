package ir.ac.kntu;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    private static int Size = 800;
    private static int numCells = 100;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Voronoi voronoi = new Voronoi(Size,numCells);
        // set a cool name for stage
        stage.setTitle(" Voronoi Diagram ");

        // now give the scene to the stage for show
        stage.setScene(voronoi.getVoronoiScene());

        // and now ... put up a SHOW
        stage.show();
    }
}
