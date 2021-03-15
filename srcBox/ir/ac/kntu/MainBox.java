package ir.ac.kntu;

import java.util.Arrays;
import java.util.Scanner;

public class MainBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numPoints = scanner.nextInt();
        int[] px = new int[numPoints];
        int[] py = new int[numPoints];
        int[] pRectX = new int[4];
        int[] pRectY = new int[4];
        for (int i = 0; i < numPoints; i++) {
            px[i] = scanner.nextInt();
            py[i] = scanner.nextInt();
        }
        Arrays.sort(px);
        Arrays.sort(py);

        pRectX[0] = px[0];
        pRectY[0] = py[0];

        pRectX[1] = px[0];
        pRectY[1] = py[numPoints-1];

        pRectX[2] = px[numPoints-1];
        pRectY[2] = py[0];

        pRectX[3] = px[numPoints-1];
        pRectY[3] = py[numPoints-1];

        System.out.println(Arrays.toString(pRectX));
        System.out.println(Arrays.toString(pRectY));
        scanner.close();
    }
}
