package big_o.array;

import java.util.HashMap;
import java.util.Map;

public class DegreeOfAnArray697 {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> count = new HashMap();
        Map<Integer, Integer> index = new HashMap();
        int max = 0;
        int maxLength = 1;
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (!count.containsKey(cur)) {
                count.put(cur, 1);
                index.put(cur, i);
            } else {
                int curCount = count.get(cur) + 1;
                count.put(cur, curCount);
                if (curCount > max) {
                    max = curCount;
                    maxLength = Math.max(maxLength, i - index.get(cur) + 1);
                } else if (curCount == max) {
                    maxLength = Math.min(maxLength, i - index.get(cur) + 1);
                }
            }
        }
        return maxLength;
    }
}
