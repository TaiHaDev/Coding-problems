package array;

public class BuyAndSellStock122 {
    public static void main(String[] args) {
        int[] prices = {7,6,4,3,2,1};
        System.out.println(solution(prices));
    }
    static int solution(int[] prices) {
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1]) {
                result += (prices[i] - prices[i-1]);
            }
        }
        return result;
    }
}
