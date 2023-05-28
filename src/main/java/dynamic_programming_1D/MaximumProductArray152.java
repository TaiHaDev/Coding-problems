package dynamic_programming_1D;

public class MaximumProductArray152 {
    /**
     * I got it halfway, the trick is to store the current min value
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {0, 2};
        System.out.println(new MaximumProductArray152().maxProduct(nums));
    }
    public int maxProduct(int[] nums) {
        int min = nums[0], max = min;
        int res = min;
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i] * max;
            max = Math.max(Math.max(nums[i], temp), nums[i] * min);
            min = Math.min(Math.min(nums[i], temp), nums[i] * min);
            res = Math.max(res, max);
        }
        return res;
    }
}
