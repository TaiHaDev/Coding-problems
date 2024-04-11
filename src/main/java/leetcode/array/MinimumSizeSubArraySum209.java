package leetcode.array;

public class MinimumSizeSubArraySum209 {
    public static void main(String[] args) {
        System.out.println(new MinimumSizeSubArraySum209().minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1}));
    }
    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int curSum = 0;
        int curStart = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            while (curSum >= target) {
                res = Math.min(i - curStart + 1, res);
                curSum -= nums[curStart];
                curStart++;
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
