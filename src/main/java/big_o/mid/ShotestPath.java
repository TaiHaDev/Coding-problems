package big_o.mid;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ShotestPath {
    static int[][] neighbors = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int rows = sc.nextInt();
            int cols = sc.nextInt();
            if(rows == 0 && cols == 0) break;
            int[][] grid = new int[rows][cols];
            int total = sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < total; i++) {
                String next = sc.nextLine();
                String[] places = next.split(" ");
                int r = Integer.parseInt(places[0]);
                for (int j = 1; j < places.length; j++) {
                    grid[r][Integer.parseInt(places[j])] = 1;
                }
            }
            int[] start = {sc.nextInt(), sc.nextInt()};
            int[] end = {sc.nextInt(), sc.nextInt()};
            System.out.println(bfs(grid, start, end));
        }
    }

    private static int bfs(int[][] grid, int[] start, int[] end) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        queue.add(start);
        visited[start[0]][start[1]] = true;
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.remove();
                if (cur[0] == end[0] && cur[1] == end[1]) return count;
                for (int[] neighbor : neighbors) {
                    int nRow = cur[0] + neighbor[0];
                    int nCol = cur[1] + neighbor[1];
                    if (nRow >= 0 && nRow < grid.length && nCol >= 0 && nCol < grid[0].length && !visited[nRow][nCol] && grid[nRow][nCol] != 1) {
                        queue.add(new int[] {nRow, nCol});
                        visited[nRow][nCol] = true;
                    }
                }
            }
            count++;
        }
        return count;
    }
}
