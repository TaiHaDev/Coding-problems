package leetcode.contest.weekly352;

public class LongestEvenOddSubarrayWithThreshold6909 {
    // sliding window
    public static void main(String[] args) {
        System.out.println(new LongestEvenOddSubarrayWithThreshold6909().longestAlternatingSubarray(new int[] {2,3,4,5}, 5));
    }
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int cur = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > threshold) {
                max = Math.max(max, cur);
                cur = 0;
                continue;
            }
            if (cur == 0 && nums[i] % 2 == 0) cur = 1;
            else if (cur > 0) {
                if (i < nums.length - 1 && nums[i] % 2 !=  nums[i + 1] % 2) {
                    cur++;
                    if (i == nums.length - 2) cur++;
                } else {
                    max = Math.max(max, cur);
                    cur = 0;
                }
            }
        }
        return max;
    }
}
