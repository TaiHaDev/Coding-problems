package leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement169 {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap();
        int res = 0;
        int count = 0;
        for (int num : nums) {
            int curCount = map.getOrDefault(num, 0) + 1;
            map.put(num, curCount);
            if (curCount > count) {
                res = num;
                count = curCount;
            }
        }
        return res;
    }
    public int majorityElement2(int[] nums) {
        int curChosen = 0;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                curChosen = num;
                count = 1;
            }
            count += (curChosen == num) ? 1 : -1;
        }
        return curChosen;
    }
}
