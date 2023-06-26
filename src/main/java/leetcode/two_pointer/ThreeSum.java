package leetcode.two_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-2,0,0,2,2};
        System.out.println(new ThreeSum().threeSum(nums));
    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int threeSum = nums[i] + nums[l] + nums[r];
                if (threeSum > 0) r--;
                if (threeSum < 0) l++;
                if (threeSum == 0) {
                    result.add(List.of(nums[i], nums[l], nums[r]));
                    r--;
                    l++;
                    while (l < r && nums[l] == nums[l-1]) l++;
                }
            }
        }
        return result;
    }
}
