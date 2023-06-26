package leetcode.array;

public class MaximumSubarray53 {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[] {-2,1}));
    }
    public static int maxSubArray(int[] nums) {
        int end = nums.length -1, start = 0;
        for (int i = 0, sum = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum < 0) {
                start = i + 1;
                sum = 0;
            }
        }
        for (int i = nums.length - 1, sum = 0; i >= 0; i--) {
            sum += nums[i];
            if (sum < 0) {
                end = i;
                sum = 0;
            }
        }
        int result = 0;
        for (int i = start; i <= end; i++) {
            result += nums[i];
        }
        return result;
    }
}
