package leetcode.array;

public class FindPivotIndex724 {
    public static void main(String[] args) {
        System.out.println(new FindPivotIndex724().pivotIndex(new int[]{2,1,-1}));
    }
    public int pivotIndex(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            total -= num;
            if (total == left) {
                return i;
            }
            left += num;
        }
        return -1;
    }
}
