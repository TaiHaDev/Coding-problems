package leetcode.array;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSubsequence128 {
    public static void main(String[] args) {
        System.out.println(new LongestConsecutiveSubsequence128().longestConsecutive(new int[] {100,4,200,1,3,2}));
    }
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        int count = 0;
        for (int num : nums) {
            if (set.contains(num - 1)) continue;
            int cur = 1;
            while (set.contains(num + cur)) {
                cur++;
            }
            count = Math.max(count, cur);
        }
        return count;
    }
}
