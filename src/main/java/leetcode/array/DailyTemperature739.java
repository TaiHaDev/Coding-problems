package leetcode.array;

import java.util.Arrays;

public class DailyTemperature739 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new DailyTemperature739().dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] res = new int[len];
        for (int i = len - 2; i >= 0; i--) {
            int cur = temperatures[i];
            int next = temperatures[i + 1];
            int nextIdx = i + 1;
            while(cur > next && res[nextIdx] != 0) {
                nextIdx += res[nextIdx];
                next = temperatures[nextIdx];
            }
            if (cur < next) {
                res[i] = nextIdx - i;
            }
        }
        return res;
    }
}
