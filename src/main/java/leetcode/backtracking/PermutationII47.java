package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PermutationII47 {
    public static void main(String[] args) {
        System.out.println(new PermutationII47().permuteUnique(new int[] {1, 1, 2}));
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, nums, 0, new ArrayList<>(), new boolean[nums.length]);
        return result;
    }
    public void backtrack(List<List<Integer>> result, int[] nums, int index, List<Integer> cur, boolean[] mem) {
        if (cur.size() == nums.length) {
            result.add(new ArrayList<>(cur));
            return;
        }
        List<Integer> visited = new ArrayList<>();
        for (int i = index; i < nums.length; i++) {
            int curNum = nums[i];
            if (!mem[i] && !visited.contains(curNum)) {
                visited.add(curNum);
                mem[i] = true;
                cur.add(curNum);
                backtrack(result, nums, index, cur, mem);
                cur.remove(cur.size() - 1);
                mem[i] = false;
            }
        }
    }
}
