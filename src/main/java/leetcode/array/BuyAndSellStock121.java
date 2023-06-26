package leetcode.array;

public class BuyAndSellStock121 {
    public static void main(String[] args) {
        int[] prices = {7,6,4,3,1};
        System.out.println(maxProfit(prices));
    }


    public static int maxProfit(int[] prices) {
        int max = 0;
        int curr = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < curr) {
                curr = price;
            } else {
                int currMax = price - curr;
                if (currMax > max) max = currMax;
            }
        }
        return max;
    }
}
