package big_o.bit_manipulation;

import java.util.Scanner;

public class SansaAndXor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int total = sc.nextInt();
            int[] nums = new int[total];
            for (int i = 0; i < total; i++) {
                nums[i] = sc.nextInt();
            }
            if (total % 2 == 0) {
                System.out.println(0);
            } else {
                int res = 0;
                for (int i = 0; i < nums.length; i++) {
                    int num = nums[i];
                    int occurences = (i + 1) * (total - i);
                    if ((occurences & 1) != 0) {
                        res ^= num;
                    }
                }
                System.out.println(res);
            }
        }
    }
}
