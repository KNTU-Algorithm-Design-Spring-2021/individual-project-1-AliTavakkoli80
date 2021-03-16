package ir.ac.kntu;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Scanner;

public class MainBox extends Application {
    private static final int SIZE = 20;
    Scanner scanner = new Scanner(System.in);
    private static final int SCENESIZE = 800;
    private final MenuBox menuBox = new MenuBox(SCENESIZE,scanner,SIZE);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Box box = new Box(SCENESIZE, menuBox.getNumPoints(), menuBox.getPx(), menuBox.getPy(),SIZE);
        stage.setTitle(" Box Diagram ");
        stage.setScene(box.getBoxScene());
        stage.show();
    }
}