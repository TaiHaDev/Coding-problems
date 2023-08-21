package big_o.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lotto {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            int k = sc.nextInt();
            if (k == 0) break;
            int[] nums = new int[k];
            for (int i = 0; i < k; i++) {
                nums[i] = sc.nextInt();
            }
            List<List<Integer>> result = new ArrayList<>();
            backtrack(nums, result, new ArrayList<>(), 0);
            for (List<Integer> set : result) {
                for (int num : set) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
    private static void backtrack(int[] nums, List<List<Integer>> result, List<Integer> holder, int startingIndex) {
        if (holder.size() == 6) {
            result.add(new ArrayList<>(holder));
            return;
        }
        if (startingIndex >= nums.length) return;
        holder.add(nums[startingIndex]);
        backtrack(nums, result, holder, startingIndex + 1);
        holder.remove(holder.size() - 1);
        backtrack(nums, result, holder, startingIndex + 1);
    }
}
