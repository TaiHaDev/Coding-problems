package randos;

public class MaxProfit {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{23171, 21011, 21123, 21366, 21013, 21367}));
    }
    public static int solution(int[] prices) {
        int len = prices.length;
        int[] max = new int[prices.length];
        max[len - 1] = prices[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            max[i] = Math.max(prices[i], max[i+1]);
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            res = Math.max(res, max[i] - prices[i]);
        }
        return res;
    }
}
