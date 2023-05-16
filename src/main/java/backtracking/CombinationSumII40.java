package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII40 {
    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[] {10,1,2,7,6,1,5}, 8));
    }

    /**
     * augmented backtracking algorithm, follow the convention to choose or not choose a number for each element in the array.
     * However, for this question, the normal method will cause duplicated combination. To fix this, I sort the array first
     * so that same number will be next to each other. Then whenever I skip a number, I will use a while loop to skip
     * all the same number next to the current number.
     * @param candidates
     * @param target
     * @return
     */
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(result, candidates, target, new ArrayList<>(), 0);
        return result;
    }
    public static void backtrack(List<List<Integer>> result,int[] nums, int target, List<Integer> current, int index) {
        if ( target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (index > nums.length - 1 || target < 0) return;
        current.add(nums[index]);
        backtrack(result, nums, target - nums[index], current, index + 1);
        current.remove(current.size() - 1);
        index++;
        while(index < nums.length && nums[index] == nums[index - 1]) index++;
        backtrack(result, nums, target, current, index);
    }
}

