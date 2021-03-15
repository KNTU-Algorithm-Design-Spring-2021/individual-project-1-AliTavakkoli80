package ir.ac.kntu;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    private static final int Size = 800;
    private static final int numCells = 100;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Voronoi voronoi = new Voronoi(Size,numCells);
        stage.setTitle(" Voronoi Diagram ");
        stage.setScene(voronoi.getVoronoiScene());
        stage.show();
    }
}
