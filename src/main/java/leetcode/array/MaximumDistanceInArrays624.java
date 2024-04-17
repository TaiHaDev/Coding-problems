package leetcode.array;

import java.util.List;

public class MaximumDistanceInArrays624 {
    public static void main(String[] args) {
        var input = List.of(List.of(1,4), List.of(0,5));
        int[] nums = {2};
        System.out.println(new MaximumDistanceInArrays624().maxDistance(input));

    }
    public int maxDistance(List<List<Integer>> arrays) {
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size() - 1);
        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> curNums = arrays.get(i);

        }
        return max - min;
    }
}
