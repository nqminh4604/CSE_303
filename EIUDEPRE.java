import java.util.Scanner;

public class EIUDEPRE {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long initial = sc.nextLong();
        long after = sc.nextLong();

        double start = 0;
        double end = 2;
        double mid = (start + end) / 2;
        double result = calcDepreciation(initial, mid, n);

        while (end - start > 0.00000001) {

            if (result > after) {
                start = mid;
            } else if (result < after) {
                end = mid;
            } 

            mid = (start + end) / 2;
            result = calcDepreciation(initial, mid, n);
        }

        System.out.println(mid);
    }

    public static double calcRate(double rate, double part, double n) {
        return rate - (rate * part / n);
    }

    public static double calcDepreciation(long initial, double rate, int time) {
        double value = initial - (initial * rate);
        if (value <= 0) {
            return -1;
        }
        for (int i = 1; i < time; i++) {
            double newRate = calcRate(rate, i, time);
            value = value - (value * newRate);
        }

        return value;
    }
}
