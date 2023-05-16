package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutation46 {
    /**
     * classical permutation problem, got it in my first try using backtracking. However, to optimise this,
     * I need to use an array to memorise which number I have used in the previous function call.
     * Instead of using cur.contains(number) as I did as first, I used a new boolean argument array.
     * It works similar to the cur arrayList.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(permute(new int[] {1,2,3}));
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        combination(result,nums, new ArrayList<>(), new boolean[nums.length]);
        return result;
    }
    public static void combination (List<List<Integer>> result,int[] nums, List<Integer> cur, boolean[] mem) {
        if (cur.size() == nums.length) {
            result.add((new ArrayList<>(cur)));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!mem[i]){
                cur.add(nums[i]);
                mem[i] = true;
                combination(result, nums, cur, mem);
                cur.remove(cur.size() - 1);
                mem[i] = false;
            }
        }
    }
}
