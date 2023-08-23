package Learning.sorting;

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countingSort(new int[]{3, 2, 1})));
    }
    public static int[] countingSort(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int[] count = new int[max + 1];
        for (int num : nums) {
            count[num]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] = count[i] + count[i-1];
        }
        int[] res = new int[nums.length];
        for (int num : nums) {
            res[count[num] - 1] = num;
            count[num]--;
        }
        return res;
    }

}
