package leetcode.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    public static void main(String[] args) {
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        System.out.println(Arrays.deepToString(new FloodFill().floodFill(image, 1, 1, 2)));
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] neighbors = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {sr, sc});
        int startCol = image[sr][sc];
        while(!queue.isEmpty()) {
            int[] cur = queue.remove();
            image[cur[0]][cur[1]] = color;
            for (int[] neighbor : neighbors) {
                int nextR = cur[0] + neighbor[0];
                int nextC = cur[1] + neighbor[1];
                if (nextR >= 0 && nextR < image.length && nextC >= 0 && nextC < image[0].length && image[nextR][nextC] == startCol && image[nextR][nextC] != color) {
                    queue.add(new int[]{nextR, nextC});
                }
            }
        }
        return image;
    }

}
