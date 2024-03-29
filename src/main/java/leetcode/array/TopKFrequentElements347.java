package leetcode.array;

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
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        List<Integer>[] buckets = new List[nums.length + 1];
        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(key);
        }
        int[] res = new int[k];

        for (int i = buckets.length - 1; i >= 0; i--) {
            if (k == 0) break;
            List<Integer> li = buckets[i];
            if (li == null) continue;
            for (Integer ans : li) {
                res[k - 1] = ans;
                k--;
            }
        }
        return res;
    }
    }
