import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;

class EI2122Q1ADAM2 {

    public static void main(String[] args) {
        int n = ni();
        int m = ni();
        int x = ni();

        int[] a1 = new int[n];
        int[] a2 = new int[m];

        for (int i = 0; i < n; i++) {
            a1[i] = ni();
        }
        for (int i = 0; i < m; i++) {
            a2[i] = ni();
        }

        Arrays.sort(a1);
        Arrays.sort(a2);
        
        int start = 0;
        int limit1 = Math.abs(a1[n - 1] - a2[0]);
        int limit2 = Math.abs(a2[m - 1] - a1[0]);
        int end = Math.max(limit1, limit2);

        // binary search to find H
        while (end > start) {
            int mid = (end + start) / 2;
            // counting how many pairs
            if (canFormPairWithMaxH(n, m, a1, a2, start, end, mid, x)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(start);
    }

    private static boolean canFormPairWithMaxH(int n, int m, int[] a1, int[] a2, int start, int end, int maxH, int x) {
        int count = 0;
        int i = 0;
        int j = 0;
        while (i < n && j < m) {
            if (Math.abs(a1[i] - a2[j]) <= maxH) {
                count++;
                i++;
                j++;
            } else if (a1[i] < a2[j]) {
                i++;
            } else {
                j++;
            }

            if (count >= x) {
                return true;
            }
        }
        return count >= x;
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
