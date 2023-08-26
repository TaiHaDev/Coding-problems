package leetcode.array;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permutation46 {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        System.out.println(new Permutation46().permute(new int[] {1,2,3}));
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        backtracking(nums, result, new ArrayList());
        return result;
    }
    private void backtracking(int[] nums, List<List<Integer>> result, List<Integer> holder) {
        if (holder.size() == nums.length) {
            result.add(new ArrayList(holder));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != Integer.MIN_VALUE) {
                int cur = nums[i];
                nums[i] = Integer.MIN_VALUE;
                holder.add(cur);
                backtracking(nums, result, holder);
                holder.remove(holder.size() - 1);
                nums[i] = cur;
            }
        }
    }
}
