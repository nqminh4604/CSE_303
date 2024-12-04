import java.util.Scanner;

class EIDIVIDE {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long left = sc.nextLong();
        long right = sc.nextLong();
        
        int maxLevel = log2(n);

        if (n < Math.pow(2, maxLevel)) {
            maxLevel--;
        }

        long count = 0;
        while (maxLevel >= 0) {
            if (n % 2 == 1) {
                count += countK(maxLevel, left, right);
            }
            n = n / 2;
            maxLevel--;
        }

        System.out.println(count);
        sc.close();
    }

    public static int log2(long n) {
        int result = (int) Math.floor((Math.log(n) / Math.log(2)));
        return result;
    }

    public static long countK(int level, long L, long R) {
        long left = 1L << level;
        long right = 1L << (level + 1);
        double kLeft = Math.ceil((L - left) * 1.0 / right);
        double kRight = Math.floor((R - left) * 1.0 / right);
        if (kLeft > kRight) {
            return 0;
        }
        return (long) (kRight - kLeft + 1);
    }
}
