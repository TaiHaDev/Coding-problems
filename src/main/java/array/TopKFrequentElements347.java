package array;

import java.util.*;

public class TopKFrequentElements347 {
    /**
     * finding top K frequent number in an array in O(n). First, find the frequency of each number and store it in a map
     * then, the trick is that store each key pair value in an array in reverse order (index: frequency and content: number)
     * then we can use a for loop to go from the top frequency to the kth frequency. We can actually do this because
     * the bucket array is bounded to the length of the input array the maximum frequency is less than or equal to length of input array.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TopKFrequentElements347().topKFrequent(new int[]{-1,-1}, 1)));
    }
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        for (int i = 0; i < bucket.length; i++ ) {
            bucket[i] = new ArrayList();
        }
        for (Integer key : map.keySet()) {
            bucket[map.get(key)].add(key);
        }
        List<Integer> result = new ArrayList();
        for (int i = bucket.length - 1; i >= 0 ; i--) {
            for (int j = bucket[i].size() - 1; j >= 0 ; j--) {
                result.add(bucket[i].get(j));
                if (result.size() == k) {
                    return result.stream().mapToInt(e -> e).toArray();
                }
            }
        }
        return null;
    }
}
