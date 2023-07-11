package coding_assessment.tiktok;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MinResistance {
    /**
     * m*n matrix, start at any position in the first column, find the minimum path to the last column
     * @param args
     */
    public static void main(String[] args) {
        int[][] input = {{2, 6, 7}, {1, 5, 8}, {3, 4, 9}};
        System.out.println(minimumResistence(List.of(List.of(2,6,7), List.of(1,5,8), List.of(3,4,9))));
    }
    public static int minimumResistence(List<List<Integer>> matrix) {
        // I would use dijkstra here as it requires to find the minimum path
        int[][] neighbors = {{-1, 1}, {0, 1}, {1, 1}};
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e[2]));
        int[][] dist = new int[matrix.size()][matrix.get(0).size()];
        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist[0].length; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < matrix.get(0).size(); i++) {
            pq.add(new int[] {i, 0,matrix.get(i).get(0)});
            dist[i][0] = matrix.get(i).get(0);
        }

        while(!pq.isEmpty()) {
            int[] cur = pq.remove();
            System.out.println(Arrays.toString(cur));
            if (dist[cur[0]][cur[1]] != cur[2]) continue;
            for (int[] neighbor : neighbors) {
                int newRow = cur[0] + neighbor[0];
                int newCol = cur[1] + neighbor[1];
                if (newRow >= 0 && newCol >= 0 && newRow < matrix.size() && newCol < matrix.get(0).size()) {
                    int updatedResistence = cur[2] + matrix.get(newRow).get(newCol);
                    if (updatedResistence < dist[newRow][newCol]) {
                        dist[newRow][newCol] = updatedResistence;
                        pq.add(new int[] {newRow, newCol, updatedResistence});
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < dist.length; i++) {
            min = Math.min(min, dist[i][dist[0].length - 1]);
        }
        return min;

    }
}
