package leetcode.array;

public class GasStation134 {
    public static void main(String[] args) {
        System.out.println(new GasStation134().canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2}));
    }
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum = 0;
        for (int g : gas) {
            gasSum += g;
        }
        int costSum = 0;
        for (int c : cost) {
            costSum += c;
        }
        if (gasSum < costSum) return -1;
        int res = 0;
        int sum = 0;

        for (int i = 0; i < gas.length; i++) {
            int cur = gas[i] - cost[i];
            if (sum < 0) {
                res = i;
                sum = cur;
            } else {
                sum += cur;
            }
        }
        return res;
    }
}
