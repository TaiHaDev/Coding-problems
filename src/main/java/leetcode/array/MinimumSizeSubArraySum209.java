package leetcode.array;

public class MinimumSizeSubArraySum209 {
    public static void main(String[] args) {
        System.out.println(new MinimumSizeSubArraySum209().minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }
    public int minSubArrayLen(int target, int[] nums) {

        int start = 0;
        int end = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        // Base case
        if (nums.length == 0) {
            return 0;
        }

        while (end < nums.length) {
            int newEnd = end++;
            sum += nums[end];
            while (sum >= target) {
                minLen = Math.min(minLen, end - start);
                int newStart = start++;
                sum -= nums[newStart];
            }
        }

        if (minLen == Integer.MAX_VALUE) {
            return 0;
        } else {
            return minLen;
        }
    }
}
