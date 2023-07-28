package leetcode.math;

public class PowerOfTwo231 {
    public boolean isPowerOfTwo(int n) {
        long temp = 1;
        while(temp < n) {
            temp = temp << 1;
        }
        return temp == n;
    }
}
