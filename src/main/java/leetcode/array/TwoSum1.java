package leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum1 {
    /**
     * classic coding problem to demonstrate the power of hashmap
     */
    public static void main(String[] args) {
        int[] testing = {2,7,11,15};
        System.out.println(Arrays.toString(solution(testing, 9)));
    }
    public static int[] solution(int[] nums, int target) {
        Map<Integer, Integer> complementMap = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int complementNum = target - nums[i];
            if (complementMap.containsKey(complementNum)) {
                return new int[] {i, complementMap.get(complementNum)};
            }
            complementMap.put(nums[i], i);
        }
        return new int[] {};
    }
}
