package leetcode.array;

import java.util.Arrays;

public class LargestNumber179 {
    public String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        if (arr[0].equals("0")) return "0";
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : arr) {
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }
}
