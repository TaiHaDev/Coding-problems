package not_leetcode;

import java.util.*;

public class MinSegment1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int count = 0;
        int right = -1;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (set.add(nums[i])) {
                count++;
            }
            if (count == k) {
                right = i;
                break;
            }
        }
        set.clear();
        count = 0;
        int left = -1;
        for (int i = right; i >= 0; i--) {
            if (set.add(nums[i]))
                count++;
            if (count == k) {
                left = i;
                break;
            }
        }
        right = right == -1 ? -1 : right + 1;
        left = left == -1 ? - 1: left + 1;
        System.out.println(left + " " + right);
    }
}
