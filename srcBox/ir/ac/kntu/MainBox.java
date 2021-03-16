package ir.ac.kntu;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Scanner;

public class MainBox extends Application {
    Scanner scanner = new Scanner(System.in);
    private static final int Size = 800;
    private final MenuBox menuBox = new MenuBox(Size,scanner);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Box box = new Box(Size, menuBox.getNumPoints(), menuBox.getPx(), menuBox.getPy());
        stage.setTitle(" Box Diagram ");
        stage.setScene(box.getBoxScene());
        stage.show();
    }
}