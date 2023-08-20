package leetcode.assessment.google;

import java.util.Arrays;

public class BuildArrayFromPermutation1920 {
    public static void main(String[] args) {
        int[] nums = {5,4,1,2,3,0};
        System.out.println(Arrays.toString(new BuildArrayFromPermutation1920().buildArray(nums)));
    }
    public int[] buildArray(int[] nums) {
        int last = 0;
        int i = 0;
        while (i < nums.length) {
            int temp = nums[last];
            nums[last] = nums[nums[last]];
            last = temp;
            i++;
        }
        return nums;
    }
}
