package leetcode.math;

public class PerfectNumber {
    public boolean checkPerfectNumber(int num) {
        if (num % 2 != 0) return false;
        int total = 1;
        for (int i = 2; i <= num / 2; i++) {
            if (total > num) return false;
            if (num % i == 0) {
                total += i;
            }
        }
        return total == num;
    }
    public boolean checkPerfectNumber1(int num) {
        if (num % 2 != 0) return false;
        int total = 1;
        for (int i = 2; i * i < num; i++) {
            if (num % i == 0) {
                total += i;
                total += num / i;
            }
        }
        return total == num;
    }
}
