package leetcode.array;

public class SetMismatch645 {
    public int[] findErrorNums(int[] nums) {
        int result = 0;
        boolean[] visited = new boolean[nums.length + 1];
        int duplicate = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (!visited[cur]) {
                visited[cur] = true;
                result += cur;
            } else {
                duplicate = cur;
            }
        }
        int expected = nums.length * (nums.length + 1) / 2;
        return new int[] {duplicate, expected - result};
    }
}
