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
        for (int[] point : points) {
            pq.add(point);
            if (pq.size() > k) {
                pq.remove(); // the improvement here is keeping the heap size at K so that the complexity can be reduced from NLogN to N log k
            }
        }
        for (int i = 0; i < k; i++) {
            result[i] = pq.remove();
        }
        return result;
    }
}
