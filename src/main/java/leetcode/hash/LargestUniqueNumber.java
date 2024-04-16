package leetcode.hash;

import java.util.HashMap;
import java.util.Map;

public class LargestUniqueNumber {
    public int largestUniqueNumber(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        int res = -1;
        for (int key : countMap.keySet()) {
            if (countMap.get(key) == 1) {
                res = Math.max(res, key);
            }
        }
        return res;

    }
}
