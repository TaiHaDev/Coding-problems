package graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges994 {
    public static void main(String[] args) {
        int[][] grid = {
                {0,2}
        };
        System.out.println(new RottingOranges994().orangesRotting(grid));
    }
    public int orangesRotting(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (grid[r][c] == 2) {
                    queue.add(new int[]{r, c});
                }
                if (grid[r][c] == 1) fresh++;
            }
        }
        int[][] neighbors = {{1,0}, {-1,0}, {0, 1}, {0, -1}};
        int count = 0;
        while (!queue.isEmpty() && fresh > 0) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                int[] cur = queue.poll();
                for (int[] neighbor : neighbors) {
                    int newRow = cur[0] + neighbor[0];
                    int newCol = cur[1] + neighbor[1];
                    if (newRow < 0 || newRow == row || newCol < 0 || newCol == col || grid[newRow][newCol] != 1) continue;
                    grid[newRow][newCol] = 2;
                    queue.add(new int[] {newRow, newCol});
                    fresh--;
                }
            }
            count++;
        }
        return fresh == 0 ? count : -1;
    }



}
