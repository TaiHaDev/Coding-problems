package leetcode.sliding_window;

public class BestTimeToBuyAndSellStock121 {
    public int maxProfit(int[] prices) {

        int curMin = prices[0];
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            int curNum = prices[i];
            if (curNum > curMin) {
                res = Math.max(res, curNum - curMin);
            } else {
                curMin = curNum;
            }
        }
        return res;
    }
}
