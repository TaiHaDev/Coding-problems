package leetcode.array;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length ; i++){
            if(nums[i] <= nums.length && nums[i] > 0 && nums[nums[i] - 1] != nums[i]){
                swap(nums, i, nums[i] - 1);
            }
        }

        for (int i = 0; i < nums.length; i++){
            if(nums[i] != i + 1){
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    public void swap(int[] num, int i , int j){
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}
