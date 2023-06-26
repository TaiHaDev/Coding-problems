package big_o.sorting;

import java.util.Scanner;

public class RevertSubarray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        int[] nums = new int[total];
        for (int i = 0; i < total; i++) {
            nums[i] = sc.nextInt();
        }
        int start = 0;
        for (int i = 0; i < total - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                start = i;
                break;
            }
        }
        int end = start;
        for (int i = end; i < total - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                end = i + 1;
            } else {
                break;
            }
        }
        // reversing
        int left = start, right = end;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }

        boolean isSorted = true;
        for (int i = 0; i < total - 1; i++) {
            if (nums[i] > nums[i + 1]) isSorted = false;
        }
        if (isSorted) {
            System.out.println("YES");
            System.out.println(start + 1 + " " + (end + 1));
        } else {
            System.out.println("NO");
        }

    }
}
