package leetcode.array;

public class TemmoAttacking495 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int result = duration;
        for (int i = 1; i < timeSeries.length; i++) {
            if (timeSeries[i] <= (timeSeries[i - 1] + duration)) {
                result += (timeSeries[i] - timeSeries[i - 1]);
            } else {
                result += duration;
            }
        }
        return result;
    }
}
