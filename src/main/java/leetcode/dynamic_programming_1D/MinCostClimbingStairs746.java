package leetcode.dynamic_programming_1D;

public class MinCostClimbingStairs746 {
    public static void main(String[] args) {
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(new MinCostClimbingStairs746().minCostClimbingStairs(cost));
    }

    public int minCostClimbingStairs(int[] cost) {
//        Map<Integer, Integer> costMap = new HashMap<>();
//        costMap.put(cost.length, 0);
//        costMap.put(cost.length + 1, 0);
        for (int i = cost.length - 3; i >= 0; i--) {
            cost[i] += Math.min(cost[i + 1], cost[i + 2]);
        }
        return Math.min(cost[0], cost[1]);
    }
}
