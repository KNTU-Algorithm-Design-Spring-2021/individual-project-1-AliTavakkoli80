package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuBox {
    private ArrayList<Shapes> shapes;

    public MenuBox(int SCENESIZE, Scanner scanner, int SIZE) {
        System.out.println("+< Please Enter Number Of Shapes : >+");
        int numShapes = scanner.nextInt();
        shapes =new ArrayList<Shapes>(numShapes);
        for (int i = 0; i < numShapes; i++) {
            System.out.println("+< Shape " + (i+1) + " : >+");
            System.out.println("+< Please Enter Number Of points : >+");
            int numPoints = scanner.nextInt();
            int[] px = new int[numPoints];
            int[] py = new int[numPoints];

            for (int j = 0; j < numPoints; j++) {
                System.out.println("+< Enter Point " + (j+1) + " Coordinates : >+");
                System.out.print("x" + (j+1) + " = ");
                px[j] = scanner.nextInt();
                System.out.print("y" + (j+1) + " = ");
                py[j] = -(scanner.nextInt());
                System.out.println();
                px[j] *= SIZE;
                py[j] *= SIZE;
                px[j] += SCENESIZE / 2;
                py[j] += SCENESIZE / 2;
            }
            Shapes shape = new Shapes(SCENESIZE, numPoints, px, py, SIZE);
            shapes.add(shape);
        }
    }

    public ArrayList<Shapes> getShapes() {
        return shapes;
    }
}
