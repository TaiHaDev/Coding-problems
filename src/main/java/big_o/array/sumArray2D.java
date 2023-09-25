package big_o.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sumArray2D {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int len = sc.nextInt();
        int k = sc.nextInt();
        long[][] sum = new long[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                sum[i][j] = sc.nextLong();
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                long up = 0;
                long prev = 0;
                long dup = 0;
                if (i - 1 >= 0) {
                    up = sum[i-1][j];
                }
                if (j - 1 >= 0) {
                    prev = sum[i][j - 1];
                }
                if (i - 1 >= 0 && j - 1 >= 0) {
                    dup = sum[i - 1][j - 1];
                }
                sum[i][j] = sum[i][j] - dup + prev + up;
            }
        }

        long res = 0;
        for (int i = k - 1; i < len; i++) {
            for (int j = k - 1; j < len; j++) {
                int u = i - (k - 1);
                int v = j - (k - 1);

                long prev = 0;
                long up = 0;
                long dup = 0;

                if (u - 1 >= 0) {
                    up = sum[u - 1][j];
                }
                if (v - 1 >= 0) {
                    prev = sum[i][v-1];
                }
                if (u - 1 >= 0 && v - 1 >= 0) {
                    dup = sum[u-1][v-1];
                }
                long area = sum[i][j] - prev - up + dup;
                res = Math.max(area, res);
            }
        }
        System.out.println(res);
    }
    static class FastScanner {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer("");
        String next() {
            while (!st.hasMoreTokens())
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {}
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
