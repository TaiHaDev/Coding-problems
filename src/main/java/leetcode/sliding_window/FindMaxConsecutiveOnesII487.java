package leetcode.sliding_window;

public class FindMaxConsecutiveOnesII487 {
    public static void main(String[] args) {
        System.out.println(new FindMaxConsecutiveOnesII487().findMaxConsecutiveOnes(new int[] {1,0,1,1,0}));
    }
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int last0Index = -1;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            int curNum = nums[i];
            if (curNum == 0) {
                if (last0Index != -1) {
                    left = last0Index+1;
                }
                last0Index = i;
            }
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}
