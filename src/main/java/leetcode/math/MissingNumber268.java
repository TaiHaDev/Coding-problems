package leetcode.math;

import java.util.LinkedList;
import java.util.List;

public class MissingNumber268 {
    public List<Integer> addToArrayForm(int[] num, int k) {
        LinkedList<Integer> result = new LinkedList();
        for (int i = num.length - 1; i >= 0; i--) {
            result.add(0, (num[i] + k) % 10);
            k = (num[i] + k) / 10;
        }
        while(k > 0) {
            result.add(0, k%10);
            k /= 10;
        }
        return result;
    }
}
