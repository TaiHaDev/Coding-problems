package meta_hacker_cup._2022;

import java.io.*;
import java.util.StringTokenizer;

public class SecondHands {
    public static FastScanner sc = new FastScanner();
    public static void main(String[] args) throws IOException {
        int n = sc.nextInt();
        int ca = 1;
        while (n-- > 0) {
            int len = sc.nextInt();
            int k = sc.nextInt();
            int[] input = new int[len];
            for (int i = 0; i < len; i++) {
                input[i] = sc.nextInt();
            }
            String castr = "Case " + "#" + ca++ +": ";
            if (solve(input, k)) {
                System.out.println(castr + "YES");
            } else {
                System.out.println(castr + "NO");
            }
        }
    }

    private static boolean solve(int[] input, int k) {
        if (input.length > k * 2) return false;
        int[] count = new int[101];
        for (int num : input) {
            count[num]++;
            if (count[num] > 2) {
                return false;
            }
        }
        return true;
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
