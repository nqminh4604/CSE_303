import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;

public class EIFLIP {

    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        int tc = ni();
        for (int i = 0; i < tc; i++) {
            boolean[][] board = getBoard();
            int count = 0;
            for (int position = 0; position < 9; position++) {
                boolean[][] newBoard = click(board, position);
                if (compareToModel(newBoard)) {
                    
                }
                List<Boolean[][]> list = new ArrayList<>();
            } 
        }
    }

    
    public static boolean[][] getBoard() {
        boolean[][] board = new boolean[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ns().equals("*") ? true : false;
            }
        }
        return board;
    }
    
    static boolean[][] model = { { false, false, false }, { false, false, false }, { false, false, false } };
    public static boolean compareToModel(boolean[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] != model[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean[][] click(boolean[][] board, int position) {
        int row = position / 3;
        int col = position % 3;

        board[row][col] = !board[row][col];
        if (row == 0 || row == 2) {
            board[1][col] = !board[1][col];
        } else {
            board[0][col] = !board[0][col];
            board[2][col] = !board[2][col];
        }

        if (col == 0 || col == 2) {
            board[row][1] = !board[row][1];
        } else {
            board[row][0] = !board[row][0];
            board[row][2] = !board[row][2];
        }

        return board;
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
