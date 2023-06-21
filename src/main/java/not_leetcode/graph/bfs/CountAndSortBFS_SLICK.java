package not_leetcode.graph.bfs;

import java.util.*;

public class CountAndSortBFS_SLICK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int row = sc.nextInt();
            int col = sc.nextInt();
            if (row == 0 && col == 0) break;
            int[][] grid = new int[row][col];
            boolean[][] visited = new boolean[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            TreeMap<Integer, Integer> result = new TreeMap<>();
            int count = 0;
            for (int r = 0; r < row; r++) {
                for (int c = 0; c < col; c++) {
                    if (!visited[r][c] && grid[r][c] == 1) {
                        int res = bfs(grid, new int[] {r, c}, visited);
                        result.put(res, result.getOrDefault(res, 0) + 1);
                        count++;
                    }
                }
            }
            System.out.println(count);
            for (var entry : result.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }
    }

    private static int bfs(int[][] grid, int[] start, boolean[][] visited) {
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        int[][] neighbors = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        queue.add(start);
        visited[start[0]][start[1]] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            count++;
            for (int[] neighbor : neighbors) {
                int nextR = cur[0] + neighbor[0];
                int nextC = cur[1] + neighbor[1];
                if (nextR >= 0 && nextC >= 0 && nextR < grid.length && nextC < grid[0].length && !visited[nextR][nextC] && grid[nextR][nextC] == 1) {
                    queue.add(new int[]{nextR, nextC});
                    visited[nextR][nextC] = true;
                }
            }
        }
        return count;
    }
}
