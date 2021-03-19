package ir.ac.kntu;

public class DacMaxMin {
    private int max;
    private int min;

    public DacMaxMin(int[] a, int size) {
        MaxMin(0, size - 1, a);
    }

    private void MaxMin(int i, int j, int[] a) {
        int max1, min1, mid;
        if (i == j) {
            max = a[i];
            min = a[i];
        } else {
            if (i == (j - 1)) {
                if (a[i] < a[j]) {
                    max = a[j];
                    min = a[i];
                } else {
                    max = a[i];
                    min = a[j];
                }
            } else {
                mid = (i + j) / 2;
                MaxMin(i, mid, a);

                max1 = max;
                min1 = min;
                MaxMin(mid + 1, j, a);
                if (max < max1) max = max1;//updating here
                if (min > min1) min = min1;
            }
        }
    }

    public int getMax() {
        return max;
    }

    public int getMin() {
        return min;
    }
}