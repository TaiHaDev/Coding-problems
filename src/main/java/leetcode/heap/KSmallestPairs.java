package leetcode.heap;

import org.testng.internal.collections.Pair;

import java.util.*;

public class KSmallestPairs {
    public static void main(String[] args) {
        System.out.println(new KSmallestPairs().kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3));
    }

    /**
     * starts at (0,0) the next minimum pair can be (0, 1) or (1,0), we add all of them to the heap and get the minimum
     * pair for each iteration, however, we may add the same number to the heap (1, 0 -> 1,1, 2,0 -> 2,1 2,1), so we need
     * to use a hashset datastructure to keep track of all visited pair.
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new LinkedList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        // [summation, i, j]
        pq.add(new int[]{nums1[0] + nums2[0], 0, 0});
        Set<Pair<Integer, Integer>> visited = new HashSet<>();
        visited.add(new Pair<>(0, 0));
        while (k > 0 && !pq.isEmpty()) {
            int[] cur = pq.poll();
            int i = cur[1];
            int j = cur[2];
            result.add(List.of(nums1[i], nums2[j]));
            k--;
            if (i + 1 < nums1.length && !visited.contains(new Pair(i + 1, j))) {
                pq.add(new int[]{nums1[i + 1] + nums2[j], i + 1, j});
                visited.add(new Pair(i + 1, j));
            }
            if (j + 1 < nums2.length && !visited.contains(new Pair(i, j + 1))) {
                pq.add(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
                visited.add(new Pair(i, j + 1));
            }
        }
        return result;
    }


}
