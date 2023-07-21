package leetcode.math;

public class CountOdds {
    public int countOdds(int low, int high) {
        int count = 0;
        if (low % 2 == 1 || high % 2 == 1) {
            count++;
        }

        count += (high - low) >> 1;
        return count;
    }
}
