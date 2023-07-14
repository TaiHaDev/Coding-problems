package leetcode.array;

public class SignProductOfAnArray1822 {
    public int arraySign(int[] nums) {
        int result = 1;
        for (int num : nums) {
            if (num == 0) {
                return 0;
            }
            if (num < 0) {
                result *= -1;
            }
        }
        return result;
    }
}
