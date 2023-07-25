package leetcode.array;

public class NumberOfZeroFilledSubArray2348 {
    public static void main(String[] args) {
        int[] nums = {1,3,0,0,2,0,0,4};
        System.out.println(new NumberOfZeroFilledSubArray2348().zeroFilledSubarray(nums));
    }
    public long zeroFilledSubarray(int[] nums) {
        int count = 0;
        int acc = 0;
        for (int num : nums) {
            if (num == 0) {
                acc++;
                count+= acc;
            } else {
                acc = 0;
            }
        }
        return count;
    }
}
