package dynamic_programming_2D;

import java.util.Arrays;

public class UniquePathsII63 {
    public static void main(String[] args) {
        int[][] obstacleGrid = {{0,0}, {0,0}
        };


        System.out.println(new UniquePathsII63().uniquePathsWithObstacles(obstacleGrid));
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length, col = obstacleGrid[0].length;
        int[] prev = new int[col];
        Arrays.fill(prev, 0);
        for (int r = row - 1; r >= 0; r--) {
            int[] cur = new int[col + 1];
            cur[col - 1] = 0;
            for (int c = col - 1; c >= 0; c--) {
                if (obstacleGrid[r][c] == 1) cur[c] = 0;
                else {
                    if (r == row -1 && c == col - 1) cur[c] = 1;
                    else cur[c] =cur[c+1] + prev[c];
                }
            }
            prev = cur;
        }
        return prev[0];
    }
    public int uniquePathsWithObstaclesChatgpt(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                } else if (j > 0) {
                    dp[j] += dp[j - 1];
                }
            }
        }

        return dp[n - 1];
    }
}
