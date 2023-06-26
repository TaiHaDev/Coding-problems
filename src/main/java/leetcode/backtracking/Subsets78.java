package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets78 {
    /**
     * Backtracking algorithm, go through all possible path (there's no terminating condition for this problem)
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(subsets(new int[] {1,2,3}));
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        combination(nums, result, new ArrayList(), 0);
        return result;

    }
    public static void combination(int[] nums,List<List<Integer>> result, List<Integer> subset, int index) {
        if (index >= nums.length) {
            result.add(new ArrayList(subset));
            return;
        }
        subset.add(nums[index]);
        combination(nums, result, subset, index + 1);
        subset.remove(subset.size() - 1);
        combination(nums,result, subset, index + 1);
    }
}
