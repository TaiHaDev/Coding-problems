package leetcode.array;

public class RemoveElement27 {
    public static void main(String[] args) {
        System.out.println(new RemoveElement27().removeElement(new int[] {0,1,2,2,3,0,4,2}, 2));
    }
    public int removeElement(int[] nums, int val) {
        int idx = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val && idx == -1) {
                idx = i;
            } else if (nums[i] != val && idx != -1) {
                nums[idx] = nums[i];
                idx++;
                count++;
            } else if (nums[i] != val) {
                count++;
            }
        }
        return count;
    }
}
