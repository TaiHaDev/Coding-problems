package leetcode.dynamic_programming_1D;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        List<Integer> numbers = countMap.keySet().stream().sorted().toList();
        int lastDP = 0, lastTwoDP = 0;
        for (int i = 0; i < numbers.size(); i++) {
            int num = numbers.get(i);
            if (i > 0 && num == numbers.get(i - 1) + 1) {
                int temp = lastDP;
                lastDP = Math.max(countMap.get(num) * num + lastTwoDP, lastDP);
                lastTwoDP = temp;
            } else {
                int temp = lastDP;
                lastDP = lastDP + countMap.get(num) * num ;
                lastTwoDP = temp;
            }
        }
        return lastDP;
    }
}
