package randos;

public class AlternativeSum {

    public static void main(String[] args) {
        System.out.println(solution(new int[] {}));
    }

    public static int solution(int[] nums) {
        int sum = 0;
        boolean isAdd = true;
        for (int i = 0; i < nums.length - 1; i++) {
            int cur = nums[i];
            if (isAdd) {
                if (cur > nums[i+1]) {
                    sum += cur;
                    isAdd = false;
                }
            } else {
                if (cur < nums[i+1]) {
                    sum -= cur;
                    isAdd = true;
                }
            }

        }
        if (isAdd) {
            sum += nums[nums.length -1];
        }
        return sum;
    }
}
