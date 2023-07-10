package leetcode.binary_search;

public class ArrangingCoins441 {
    public static void main(String[] args) {
        System.out.println(new ArrangingCoins441().arrangeCoins(5));
    }
    public int arrangeCoins(int n) {
        long l = 0, r = (int) n;
        while(l <= r) {
            long mid = (l + r) / 2;
            long coinUsed = mid * (mid + 1) / 2;
            if (coinUsed == n) return (int) mid;
            if (n < coinUsed) r = mid - 1;
            else {
                l = mid + 1;
            }
        }
        return (int) r;
    }
}
