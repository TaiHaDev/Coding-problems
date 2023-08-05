package leetcode.math;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers728 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList();
        for (int i = left; i <= right; i++) {
            if (isSelfDividingNumber(i)) {
                result.add(i);
            }
        }
        return result;
    }
    private boolean isSelfDividingNumber(int number) {
        int cp = number;
        while (cp != 0) {
            int divisor = cp % 10;
            if (divisor == 0 || number % divisor != 0) return false;
            cp /= 10;
        }
        return true;
    }
}
