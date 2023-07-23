package leetcode.dynamic_programming_1D;

public class MinCostClimbingStairs746 {
    public static void main(String[] args) {
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(new MinCostClimbingStairs746().minCostClimbingStairs(cost));
    }

    public int minCostClimbingStairs(int[] cost) {
        for (int i = 2; i < cost.length; i++) {
            cost[i] +=  Math.min(cost[i-2] , cost[i-1]);
        }
        return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
    }
}
