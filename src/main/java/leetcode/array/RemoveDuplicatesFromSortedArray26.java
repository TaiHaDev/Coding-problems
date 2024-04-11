package leetcode.array;

public class RemoveDuplicatesFromSortedArray26 {
    public int removeDuplicates(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[count] = nums[i];
            count++;
            while(i+1 < nums.length && nums[i+1] == nums[i]) {
                i++;
            }
        }
        return count;
    }
}
