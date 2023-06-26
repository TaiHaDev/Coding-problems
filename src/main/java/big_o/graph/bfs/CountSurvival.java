package big_o.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CountSurvival {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        char[][] grid = new char[row][col];
        for (int i = 0; i < row; i++) {
            String str = sc.next();
            for (int j = 0; j < col; j++) {
                grid[i][j] = str.charAt(j);
            }
        }
        boolean[][] visited = new boolean[row][col];
        int sheep = 0;
        int wolves = 0;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (grid[r][c] != '#' && !visited[r][c]) {
                    int[] tmp = bfs(grid, visited, new int[] {r, c});
                    sheep += tmp[0];
                    wolves += tmp[1];
                }
            }
        }
        System.out.println(sheep + " " + wolves);
    }

    private static int[] bfs(char[][] grid, boolean[][] visited, int[] start) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        visited[start[0]][start[1]] = true;
        int sheepCount = 0;
        int wolfCount = 0;
        boolean isSurrounded = true;
        int[][] neighbors = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            char curType = grid[cur[0]][cur[1]];
            if (curType == 'k') sheepCount++;
            else if (curType == 'v') wolfCount++;
            else if (cur[0] == 0 || cur[0] == grid.length - 1 || cur[1] == 0 || cur[1] == grid[0].length - 1) {
                isSurrounded = false;
            }
            for (int[] neighbor : neighbors) {
                int nextRow = cur[0] + neighbor[0];
                int nextCol = cur[1] + neighbor[1];
                if (nextRow >= 0 && nextCol >= 0 && nextRow < grid.length && nextCol < grid[0].length && !visited[nextRow][nextCol] && grid[nextRow][nextCol] != '#') {
                    queue.add(new int[] {nextRow, nextCol});
                    visited[nextRow][nextCol] = true;
                }
            }
        }
        if (!isSurrounded) return new int[] {sheepCount, wolfCount};
        if (sheepCount > wolfCount) {
            wolfCount = 0;
        } else {
            sheepCount = 0;
        }
        return new int[] {sheepCount, wolfCount};
    }
}

