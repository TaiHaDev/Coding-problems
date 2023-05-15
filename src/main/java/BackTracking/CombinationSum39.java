package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum39 {
    /**
     * go through all the possible combinations and choose the suitable one
     */

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[] {2,3,6,7}, 7));

    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combination(result, candidates, target,0, new ArrayList<>());
        return result;
    }

    public static void combination(List<List<Integer>> result, int[] nums, int target,int index,  List<Integer> current) {
        if (target == 0) {
            result.add(new ArrayList(current));
            return;
        }
        if (target < 0 || index >= nums.length) {
            return;
        }
        current.add(nums[index]);
        combination(result, nums, target - nums[index], index, current);
        current.remove(current.size() - 1);
        combination(result, nums, target, index + 1, current);}
//    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
//        List<List<Integer>> result = new ArrayList<>();
//        combination(result, candidates, target, 0, new ArrayList<>());
//        return result;
//    }
//
//    public static void combination(List<List<Integer>> result, int[] nums, int target, int start, List<Integer> current) {
//        if (target == 0) {
//            result.add(new ArrayList<>(current));
//            return;
//        }
//
//        if (target < 0) {
//            return;
//        }
//
//        for (int i = start; i < nums.length; i++) {
//            current.add(nums[i]);
//            combination(result, nums, target - nums[i], i, current);
//            current.remove(current.size() - 1);
//        }
//    }
}
