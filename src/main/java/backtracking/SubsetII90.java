package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SubsetII90 {
    public static void main(String[] args) {
        System.out.println(new SubsetII90().subsetsWithDup(new int[] {1,2,2}));
        System.out.println();
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, nums, 0, new ArrayList<>());
        return result;

    }
    public void backtrack(List<List<Integer>> result, int[] nums, int index, List<Integer> cur) {
        if (index >= nums.length) {
            result.add(new ArrayList<>(cur));
            return;
        }

        int currentNum = nums[index];
        cur.add(currentNum);
        backtrack(result, nums, index + 1, cur);
        cur.remove(cur.size() - 1);
        index += 1;
        while(index < nums.length && nums[index] == nums[index - 1]) index++;
        backtrack(result, nums, index, cur);
    }
}
