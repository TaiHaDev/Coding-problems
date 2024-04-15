package leetcode.kadane;

public class LongestTurbulanceSubarray978 {
    public int maxTurbulenceSize(int[] arr) {
        int maxLen = 1;
        int anchor = 0;
        for (int i = 1; i < arr.length; i++) {
            int c = Integer.compare(arr[i-1], arr[i]);
            if (c == 0) {
                anchor = i;
            } else if (i == arr.length - 1 || c * Integer.compare(arr[i], arr[i+1]) != -1) {
                maxLen = Math.max(maxLen, i - anchor + 1);
                anchor = i;
            }
        }
        return maxLen;
    }
}
