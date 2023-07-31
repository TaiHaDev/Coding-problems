package leetcode.math;

public class Base7504 {
    public String convertToBase7(int num) {
        if (num == 0) return "0";
        StringBuilder result = new StringBuilder();
        if (num < 0) {
            result.append('-');
            num = -num;
        }
        int maxDigit = 1;
        while (maxDigit <= num) {
            maxDigit *= 7;
        }
        maxDigit /= 7;
        while (maxDigit >= 1) {
            result.append(num / maxDigit);
            num %= maxDigit;
            maxDigit /= 7;
        }
        return result.toString();
    }
}
