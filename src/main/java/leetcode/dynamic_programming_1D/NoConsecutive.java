package leetcode.dynamic_programming_1D;

public class NoConsecutive {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {1,2,8,-1,2,6,0}));
    }
    private static int solution(int[] input) {
        int n1 = 0, n2 = 0;
        int indexN1 = -1, indexN2 = -1;
        int[] trace = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            int cur = input[i];
            int temp = n1;
            n1 = Math.max(n2 + cur, n1);
            if (n2 + cur >= n1) {
                n1 = n2 + cur;
                trace[i] = indexN2;
                indexN2 = i;
            } else {
                trace[i] = indexN1;
                indexN2 = indexN1;
            }
            int tem = indexN1;
            indexN1 = indexN2;
            indexN2 = tem;
            n2 = temp;
        }
        String res = "";
        int i = trace[trace.length - 1];
        while(i >= 0) {
            res = input[i] + res;
            i = trace[i];
        }
        System.out.println(res);
        return n1;
    }
}
