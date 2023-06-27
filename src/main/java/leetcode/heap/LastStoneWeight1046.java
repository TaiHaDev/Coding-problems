package leetcode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight1046 {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int num : stones) pq.add(num);
        while (pq.size() > 1) {
            int fs = pq.poll();
            int sn = pq.poll();
            if (sn < fs) {
                pq.add(fs - sn);
            }
        }
        return pq.poll();
    }
}
