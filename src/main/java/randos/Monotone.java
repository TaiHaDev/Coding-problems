package randos;

public class Monotone {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {1,2,2,1}));
    }
    public static int solution(int[] nums) {
        int res = 1;
        int cur = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i -1]) {
                cur++;
            } else {
                res = Math.max(res, cur);
                cur = 1;
            }
        }
        return res;
    }
}
