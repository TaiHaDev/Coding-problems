package not_leetcode;

import java.util.Scanner;

public class BearAndGame {
    class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            System.out.println(solution(n, nums));
        }
        public static int solution(int n, int[] nums) {
            int last = 0;
            for (int num : nums) {
                if (num <= last + 15) {
                    last = num;
                } else {
                    return last + 15;
                }
            }
            return Math.min(90, last + 15);
        }
    }
}
