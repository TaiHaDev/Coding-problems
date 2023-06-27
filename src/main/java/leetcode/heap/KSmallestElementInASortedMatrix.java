package leetcode.heap;

import org.testng.internal.collections.Pair;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class KSmallestElementInASortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };
        System.out.println(new KSmallestElementInASortedMatrix().kthSmallest(matrix, 8));
    }
    public int kthSmallest(int[][] matrix, int k) {
        int row = matrix.length;
        int col = matrix[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> matrix[a[0]][a[1]]));
        Set<Pair<Integer,Integer>> visited = new HashSet<>();
        pq.add(new int[]{0, 0});
        visited.add(new Pair<>(0, 0));
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            k--;
            if (k == 0) return matrix[cur[0]][cur[1]];
            if (cur[0] + 1 < row && !visited.contains(new Pair<>(cur[0] + 1, cur[1]))) {
                pq.add(new int[]{cur[0] + 1, cur[1]});
                visited.add(new Pair<>(cur[0] + 1, cur[1]));
            }
            if (cur[1] + 1 < col && !visited.contains(new Pair<>(cur[0], cur[1] + 1))) {
                pq.add(new int[]{cur[0], cur[1] + 1});
                visited.add(new Pair<>(cur[0], cur[1] + 1));
            }
        }
        return -1;
    }
}
