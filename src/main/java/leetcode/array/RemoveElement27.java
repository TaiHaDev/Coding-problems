package leetcode.array;

public class RemoveElement27 {
    public static void main(String[] args) {
        System.out.println(new RemoveElement27().removeElement(new int[] {0,1,2,2,3,0,4,2}, 2));
    }
    public int removeElement(int[] nums, int val) {
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[idx] = nums[i];
                idx++;
            }
        }
        return idx;
    }
    public int removeElement2(int[] nums, int val) {
        int l = 0;
        int h = nums.length - 1;
        while (l <= h) {
            if (nums[l] == val) {
                nums[l] = nums[h];
                h--;
            } else {
                l++;
            }
        }
        return l;
    }

}
