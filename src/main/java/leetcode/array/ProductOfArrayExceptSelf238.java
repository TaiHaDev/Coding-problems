package leetcode.array;

import java.util.Arrays;

public class ProductOfArrayExceptSelf238 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));

    }

    /**
     * suffice product and prefix product array
     * @param nums
     * @return
     */
    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0, acc = 1; i < nums.length; i++) {
            result[i] = acc;
            acc *= nums[i];
        }
        for (int i = nums.length - 1, acc = 1; i >= 0; i--) {
            result[i] *= acc;
            acc *= nums[i];
        }
        return result;
    }
}
