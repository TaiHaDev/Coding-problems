package leetcode.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestToOrigin {
    public static void main(String[] args) {
        int[][] array = {
                {1, 3},
                {-2, 2}
        };
        System.out.println(Arrays.deepToString(new KClosestToOrigin().kClosest(array, 1)));
    }
    public int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][2];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingDouble(point -> Math.sqrt(Math.pow(point[0], 2) + Math.pow(point[1], 2))));
        pq.addAll(Arrays.asList(points));
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }
        return result;
    }
}
