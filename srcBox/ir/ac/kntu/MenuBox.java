package ir.ac.kntu;

import java.util.Scanner;

public class MenuBox {
    private int numPoints ;
    private int px[] ;
    private int py[] ;
    public MenuBox(int Size,Scanner scanner){

        this.numPoints = scanner.nextInt();
        this.px = new int[numPoints];
        this.py = new int[numPoints];
        for (int i = 0; i < numPoints; i++) {
            this.px[i] = scanner.nextInt();
            this.py[i] = -(scanner.nextInt());
            this.px[i] *= 100;
            this.py[i] *= 100;
            this.px[i] += Size / 2;
            this.py[i] += Size / 2;
        }

    }

    public int[] getPx() {
        return px;
    }

    public int[] getPy() {
        return py;
    }

    public int getNumPoints() {
        return numPoints;
    }
}
