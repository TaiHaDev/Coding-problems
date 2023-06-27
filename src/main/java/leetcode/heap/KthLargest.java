package leetcode.heap;

import java.util.PriorityQueue;

public class KthLargest {
    /**
     * good question to understand heap and priority queue
     * @param args
     */
    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(2, new int[]{0});
        System.out.println(kthLargest.add(-1));   // return 4
        System.out.println(kthLargest.add(5));   // return 5
        System.out.println(kthLargest.add(10));  // return 5
        System.out.println(kthLargest.add(9));   // return 8

    }
    PriorityQueue<Integer> upperPQ = new PriorityQueue<>();
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int num : nums) add(num);
    }

    public int add(int val) {
        if (upperPQ.size() < k) {
            upperPQ.add(val);
        } else if (val >= upperPQ.peek()) {
            upperPQ.poll();
            upperPQ.add(val);
        }
        return upperPQ.peek();
    }
}
