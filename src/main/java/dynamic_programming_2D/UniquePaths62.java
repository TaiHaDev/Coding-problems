package dynamic_programming_2D;

import java.util.Arrays;

public class UniquePaths62 {
    public static void main(String[] args) {
        System.out.println(new UniquePaths62().uniquePaths(3, 7));
    }
    public int uniquePaths(int m, int n) {
        int[] prev = new int[n];
        Arrays.fill(prev, 1);
        for (int i = m - 2; i >= 0; i--) {
            int[] cur = new int[n];
            cur[n - 1] = 1;
            for (int c = n - 2; c >= 0; c--) {
                cur[c] = cur[c + 1] + prev[c];
            }
            prev = cur;
        }
        return prev[0];
    }
}
