package leetcode.heap;

import java.util.PriorityQueue;

public class KthLargestElementInArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            if (queue.size() < k) {
                queue.add(num);
                continue;
            }
            if (num > queue.peek()) {
                queue.remove();
                queue.add(num);
            }
        }
        return queue.peek();
    }
}
