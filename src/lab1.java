import java.util.Random;

public class lab1 {
    public static void main(String[] args) {
        long[] c = new long[17];
        for (int i = 0; i < 17; i++) {
            c[i] = i + 2;
        }
        double[] x = new double[12];
        Random rand = new Random();
        for (int i = 0; i < 12; i++) {
            x[i] = rand.nextDouble(-7, 7);
        }
        double[][] arr = new double[17][12];
        for (int i = 0; i < 17; i++) {
            for (int j = 0; j < 12; j++) {
                if (c[i] == 8) {
                    arr[i][j] = Math.cbrt(Math.atan((x[j] - 0.5) /13));
                }
                if (c[i] == 2 || c[i] == 3   || c[i] == 5 || c[i] == 7 || c[i] == 12 || c[i] == 13 || c[i] == 14 || c[i] == 16) {
                    arr[i][j] = Math.pow(Math.log(Math.pow(Math.tan(x[j]), 2)), Math.pow(Math.pow(x[j] / 2, 3), 2/(Math.cbrt(x[j])))/4);
                }
                if (c[i] == 4 || c[i] == 6 || c[i] == 9 || c[i] == 10 || c[i] == 11 || c[i] == 15 || c[i] == 17 || c[i] == 18) {
                    arr[i][j] = Math.pow(3 / 4 / Math.asin((x[j] - 0.5) / 104), 3);
                }
            }
        }
        for (int i = 0; i < 17; i++) {
            for (int j = 0; j < 12; j++) {
                System.out.printf("%.2f\t", arr[i][j]);
            }
            System.out.println();
        }
    }
}