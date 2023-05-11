package array;

public class MaximumSumArray {
    public static void main(String[] args) {

    }
    public static int maxSumArray(int[] nums) {
        int maxSub = nums[0];
        int currMax = 0;
        for (int i = 0; i < nums.length; i++) {
            if (currMax < 0) currMax = 0;
            currMax += nums[i];
            maxSub = Math.max(currMax, maxSub);
        }
        return maxSub;
    }
}
