package dynamic_programming_1D;

public class HouseRobber198 {
    public static void main(String[] args) {
        int[] nums = {2, 1, 1, 2};
        System.out.println(new HouseRobber198().rob(nums));
    }

    public int rob(int[] nums) {
        int rob1 = 0, rob2 = 0;
        for (int num : nums) {
            int temp = Math.max(rob1 + num , rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        return rob2;
    }



    // using backtracking algorithm
    public int rob2(int[] nums) {
        return backtrack(nums, 0, 0);
    }

    public int backtrack(int[] nums, int index, int cur) {
        if (index >= nums.length) return cur;
        return Math.max(backtrack(nums, index + 2, cur + nums[index]),
                backtrack(nums, index + 1, cur));
    }
}
