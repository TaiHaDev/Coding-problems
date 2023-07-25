package leetcode.array;

public class FindTheDuplicateNumber {
    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
        System.out.println(new FindTheDuplicateNumber().findDuplicate(nums));
    }
    public int findDuplicate(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int dupIdx = nums[i] - 1;
            if (nums[i] != nums[dupIdx]) {
                int temp = nums[i];
                nums[i] = nums[dupIdx];
                nums[dupIdx] = temp;
            } else {
                i++;
            }
        }
        return nums[nums.length - 1];
    }
}
