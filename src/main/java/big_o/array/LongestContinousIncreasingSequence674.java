package big_o.array;

public class LongestContinousIncreasingSequence674 {
    public int findLengthOfLCIS(int[] nums) {
        int result = 1;
        int start = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                result = Math.max(result, i - start + 1);
            } else {
                start = i;
            }
        }
        return result;
    }
}
