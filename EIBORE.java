import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.TreeMap;

public class EIBORE {

    public static void main(String[] args) {
        int n = ni();
        Map<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            int number = ni();
            map.put(number, map.getOrDefault(number, 0) + 1);
        }

        int[] dp = new int[map.size()];
        Integer[] arr = map.keySet().toArray(new Integer[map.size()]);

        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                dp[i] = arr[i] * map.get(arr[i]);
            } else if (i == 1) {
                dp[i] = arr[i - 1] * map.get(arr[i - 1]);
            } else {
                if (arr[i] - arr[i - 1] == 1) {
                    dp[i] = Math.max(dp[i - 2] + arr[i - 1] * map.get(arr[i - 1]) , dp[i - 1]);
                } else {
                    dp[i] = dp[i - 1] + arr[i] * map.get(arr[i]);
                }
            }
        }

        System.out.println("result: " + dp[map.size() - 1]);
    }

    static InputStream is = System.in;
    static byte[] inbuf = new byte[1 << 24];
    static int lenbuf = 0, ptrbuf = 0;

    static int readByte() {
        if (lenbuf == -1)
            throw new InputMismatchException();
        if (ptrbuf >= lenbuf) {
            ptrbuf = 0;
            try {
                lenbuf = is.read(inbuf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (lenbuf <= 0)
                return -1;
        }
        return inbuf[ptrbuf++];
    }

    static boolean isSpaceChar(int c) {
        return !(c >= 33 && c <= 126);
    }

    static int skip() {
        int b;
        while ((b = readByte()) != -1 && isSpaceChar(b))
            ;
        return b;
    }

    static double nd() {
        return Double.parseDouble(ns());
    }

    static char nc() {
        return (char) skip();
    }

    static String ns() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while (!(isSpaceChar(b))) {
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    static char[] ns(int n) {
        char[] buf = new char[n];
        int b = skip(), p = 0;
        while (p < n && !(isSpaceChar(b))) {
            buf[p++] = (char) b;
            b = readByte();
        }
        return n == p ? buf : Arrays.copyOf(buf, p);
    }

    static int ni() {
        int num = 0, b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
            ;
        if (b == '-') {
            minus = true;
            b = readByte();
        }
        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

    static long nl() {
        long num = 0;
        int b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
            ;
        if (b == '-') {
            minus = true;
            b = readByte();
        }
        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }
}
