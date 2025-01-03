import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;

class LOGGING3 {

    public static void main(String[] args) {
        int n = ni();
        long[] dp = new long[n];
        long[] ways = new long[n];
        long mod = 1000000007;
        long number = 0;

        for (int i = 0; i < n; i++) {

            number = nl();
            if (i == 0) {
                if (number >= 0) {
                    dp[i] = number;
                }
                ways[i] = 1;
            } else if (i == 1) {
                dp[i] = Math.max(dp[i - 1], number);
                if (dp[i] == number) {
                    ways[i] = 1;
                }
                if (dp[i] == dp[i - 1]) {
                    ways[i] = (ways[i] + ways[i - 1]) % mod;
                }
            } else {
                if (dp[i - 1] > dp[i - 2] + number) {
                    dp[i] = dp[i - 1];
                    ways[i] = ways[i - 1];
                } else if (dp[i - 1] < dp[i - 2] + number) {
                    dp[i] = dp[i - 2] + number;
                    ways[i] = ways[i - 2];
                } else {
                    dp[i] = dp[i - 1];
                    ways[i] = (ways[i - 1] + ways[i - 2]) % mod;
                }
            }

        }

        System.out.println(dp[n - 1] + " " + ways[n - 1]);
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
