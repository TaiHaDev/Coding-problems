package leetcode.dynamic_programming_1D;

public class Fibonacci {
    public static void main(String[] args) {
        Fibonacci fib = new Fibonacci();
        System.out.println(fib.recursion(5));
        System.out.println(fib.dynamicProgramming(5));
        System.out.println(fib.memoization(5, new int[6]));
    }
    /**
     * this is the code example that I used to explain the concept of dynamic programming
     */
    public int recursion(int n) {
        if (n <= 1) return n;
        return recursion(n - 1) + recursion(n - 2);
    }
    public int memoization(int n, int[] mem) {
        if (n <= 1) return n;
        if (mem[n] != 0) return mem[n];
        mem[n] = memoization(n - 1, mem) + memoization(n - 2, mem);
        return mem[n];
    }

    public int dynamicProgramming(int n) {
        if (n <= 1) return n;
        int[] dp = {1, 0};
        int count = 2;
        while (count <= n) {
            int temp = dp[0];
            dp[0] = dp[0] + dp[1];
            dp[1] = temp;
            count++;
        }
        return dp[0];
    }
}
