package meta_hacker_cup._2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Consistency {

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int c = 1;
        while (n-- > 0) {
            String input = scanner.next();
            int[] count = new int[26];
            int vowelCount = 0;
            int consonantCount = 0;
            for (char ch : input.toCharArray()) {
                count[ch-'A']++;
                if ("UEOAI".indexOf(ch) != -1) {
                    vowelCount++;
                } else {
                    consonantCount++;
                }
            }
            int res = Integer.MAX_VALUE;
            for (int i = 'A'; i <= 'Z'; i++) {
                char cur = (char) i;
                if ("UEOAI".indexOf(cur) != -1) {
                    int vowel = vowelCount - count[cur - 'A'];
                    res = Math.min(res, vowel * 2 + consonantCount);
                } else {
                    int consonant = consonantCount - count[cur - 'A'];
                    res = Math.min(res, consonant * 2 + vowelCount);
                }
            }
            System.out.println("Case #" + c +": " + res);
        }
    }
}
