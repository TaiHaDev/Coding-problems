package graph;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix1091 {
    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0},
                {1, 1, 0},
                {1, 1, 0}
        };
        System.out.println(new ShortestPathInBinaryMatrix1091().shortestPathBinaryMatrix(grid));
    }
    /**
     * try inplace and not inplace grid modify
     */
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) return -1;
        int row = grid.length, col = grid[0].length;
        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(new Coordinate(0, 0));
        int count = 1;

        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                Coordinate cur = queue.poll();
                if (cur.col == col - 1 && cur.row == row - 1) return count;
                for (int dr = -1; dr <= 1; dr++) {
                    for (int dc = -1; dc <= 1; dc++) {
                        if (dr == 0 && dc == 0) continue;
                        int newRow = cur.row + dr;
                        int newCol = cur.col + dc;
                        if (newRow >= 0 && newCol >= 0 && newRow < row && newCol < col && grid[newRow][newCol] == 0) {
                            queue.add(new Coordinate(newRow, newCol));
                            grid[newRow][newCol] = 1;
                        }
                    }
                }
            }
            count++;
        }
        return -1;
    }


    static class Coordinate {
        int row;
        int col;
        public Coordinate(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}


