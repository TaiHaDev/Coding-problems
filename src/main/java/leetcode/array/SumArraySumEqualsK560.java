package leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class SumArraySumEqualsK560 {
    /**
     * nums[end] - nums[start] = k
     * nums[end] - k = nums[start]
     */
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> startMap = new HashMap<>();
        int count = 0;
        int sum = 0;
        startMap.put(0, 1);
        for (int num : nums) {
            sum += num;
            if (startMap.containsKey(sum - k)) {
                count = startMap.get(sum - k);
            }
            startMap.put(sum, startMap.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
