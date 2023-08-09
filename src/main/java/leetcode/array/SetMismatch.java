package leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMismatch {
    public static void main(String[] args) {
        int[] nums = {1,2,2,4};
        System.out.println(Arrays.toString(new SetMismatch().findErrorNums(nums)));
    }
    public int[] findErrorNums(int[] nums) {
        int result = 0;
        Set<Integer> set = new HashSet();
        int duplicate = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                result += nums[i];
            } else {
                duplicate = nums[i];
            }
        }
        int expected = nums.length * (nums.length + 1) / 2;
        return new int[] {duplicate, expected - result};
    }
}
