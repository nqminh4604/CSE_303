import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;

public class EIQUEENS {
    public static void main(String[] args) {
        int x = 8;
        int y = 8;
        boolean[][] board = new boolean[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                board[i][j] = nc() == '*' ? true : false;
            }
        }

        boolean flag = true;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (board[i][j] == true) {
                    flag = isValid(board, i, j);
                    if (!flag) {
                        break;
                    }
                }
            }
            if (!flag) {
                break;
            }
        }
        System.out.println(flag ? "valid" : "invalid");
    }

    public static boolean isValid(boolean[][] board, int x, int y) {
        int horizontal = board.length;
        int vertical = board[0].length;
        
        for (int i = 0; i < vertical; i++) {
            if (board[x][i] == true && i != y) {
                return false;
            }
        }

        for (int j = 0; j < horizontal; j++) {
            if (board[j][y] == true && j != x) {
                return false;
            }
        }

        int i = x;
        int j = y;
        while (i > 0 && j > 0) {
            i--;
            j--;
        }
        while (i < horizontal && j < vertical) {
            if (board[i][j] == true && (i != x || j != y)) {
                return false;
            }
            i++;
            j++;
        }

        i = x;
        j = y;
        while (i > 0 && j < vertical - 1) {
            i--;
            j++;
        }
        while (i < horizontal && j > 0) {
            if (board[i][j] == true && (i != x || j != y)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
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
