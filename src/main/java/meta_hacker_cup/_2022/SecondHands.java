package meta_hacker_cup._2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SecondHands {
    public static FastScanner sc = new FastScanner();
    public static void main(String[] args) throws IOException {
        int n = sc.nextInt();
        while (n-- > 0) {
            int len = sc.nextInt();
            int k = sc.nextInt();
            int[] input = new int[len];
            for (int i = 0; i < len; i++) {
                input[i] = sc.nextInt();
            }
            if (solve(input, k)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
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
