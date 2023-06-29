package leetcode.math;

public class SumOfSquareNumbers633 {
    public boolean judgeSquareSum(int c) {
        int range = (int) Math.sqrt(c);
        for (int i = 1; i <= range; i++) {
            int needed = c - (int) Math.pow(i, 2);
            int sqrtNeeded = (int) Math.sqrt(needed);
            if (sqrtNeeded * sqrtNeeded == needed && sqrtNeeded <= range) {
                return true;
            }
        }
        return false;
    }
}
