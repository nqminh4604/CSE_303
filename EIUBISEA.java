import java.util.*;
import java.io.*;

class EIUBISEA {
    public static void main(String[] args) {
        InputReader rd = new InputReader(System.in);
        StringBuilder sb = new StringBuilder();
        int n = rd.nextInt();
        int m = rd.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt();
        }
        Arrays.sort(arr);
        for (int i = 0; i < m; i++) {
            int num = rd.nextInt();
            sb.append(biSea(arr, num)).append(" ");
        }

        System.out.println(sb);
    }

    public static int biSea(long[] arr, long num) {
        int from = 0;
        int to = arr.length;
        if (arr[0] == num) {
            return 0;
        }
        int i = Arrays.binarySearch(arr, from, to, num);
        if (i < 0) {
            return -1;
        }
        while (arr[i - 1] == num) {
            i = Arrays.binarySearch(arr, from, i, num);
        }
        
        return i;
    }

    static class InputReader {
        StringTokenizer tokenizer;
        BufferedReader reader;
        String token;
        String temp;

        public InputReader(InputStream stream) {
            tokenizer = null;
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public InputReader(FileInputStream stream) {
            tokenizer = null;
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public String nextLine() throws IOException {
            return reader.readLine();
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    if (temp != null) {
                        tokenizer = new StringTokenizer(temp);
                        temp = null;
                    } else {
                        tokenizer = new StringTokenizer(reader.readLine());
                    }
                } catch (IOException e) {
                }
            }
            return tokenizer.nextToken();
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
