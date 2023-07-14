package leetcode.array;

public class NumArray {
    int[] sumArray;
    public NumArray(int[] nums) {
        sumArray = new int[nums.length];
        sumArray[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sumArray[i] = nums[i] + sumArray[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        if (left == 0) {
            return sumArray[right];
        }
        return sumArray[right] - sumArray[left - 1];
    }
}

