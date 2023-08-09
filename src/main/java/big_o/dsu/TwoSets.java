package big_o.dsu;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TwoSets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        Set<Integer> set = new HashSet<>();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            int cur = sc.nextInt();
            set.add(cur);
            nums[i] = cur;
        }
        boolean isTrue = true;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == Integer.MAX_VALUE || num == Integer.MIN_VALUE) continue;
            int o1 = a - num;
            int o2 = b - num;
            if (set.contains(num) && set.contains(o1)) {
                nums[i] = Integer.MIN_VALUE;
                set.remove(num);
                set.remove(o1);
            } else if (set.contains(num) && set.contains(o2)) {
                nums[i] = Integer.MAX_VALUE;
                set.remove(num);
                set.remove(o2);
            } else {
                isTrue = false;
                break;
            }
        }
        if (isTrue) {
            System.out.println("YES");
            for (int num : nums) {
                if (num == Integer.MIN_VALUE) {
                    System.out.print("0 ");
                } else {
                    System.out.print("1 ");
                }
            }
            System.out.println();
        } else {
            System.out.println("NO");
        }

    }
}
