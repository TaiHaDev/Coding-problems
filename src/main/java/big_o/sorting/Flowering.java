package big_o.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class Flowering {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int[] nums = new int[12];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(count(nums, k));

    }

    public static int count(int[] nums, int k) {
        if (k == 0) return 0;
        Arrays.sort(nums);
        int length = 0;
        int count = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            length += nums[i];
            count++;
            if (length >= k)  {
                return count;
            }
        }
        return -1;
    }
}
