package leetcode.array;

public class RemoveDuplicatesFromSortedArrayII80 {
    public int removeDuplicates(int[] nums) {
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            nums[idx++] = nums[i];
            if (count == 1 && i + 1 < nums.length && nums[i] == nums[i + 1]) {
                count++;
                nums[idx++] = nums[i++];
            }
            while(i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return idx;
    }
}
