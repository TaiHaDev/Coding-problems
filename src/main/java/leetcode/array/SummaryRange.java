package leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class SummaryRange {
    public static void main(String[] args) {
        System.out.println(new SummaryRange().summaryRanges(new int[] {0, 1 , 2, 4, 5, 7}));
    }
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            if (i + 1 < nums.length && nums[i + 1] - nums[i] == 1) {
                i++;
            }
            if (temp != nums[i]) {
                result.add(temp + "->" + nums[i]);
            } else {
                result.add("" + temp);
            }
        }
        return result;
    }
}
