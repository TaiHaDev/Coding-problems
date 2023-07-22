package leetcode.math;

public class MissingNumber268 {
    public int missingNumber(int[] nums) {
        int max = nums.length;
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        int realTotal = max * (max + 1) / 2;
        return realTotal - total;
    }
}
