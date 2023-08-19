package big_o.bit_manipulation;

import java.util.Scanner;

public class PowerOfTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int total = sc.nextInt();
            int[] nums = new int[total];
            for (int i = 0; i < total; i++) {
                nums[i] = sc.nextInt();
            }
            int[] count = new int[30];
            boolean found = false;
            for (int i = 0; i <= 30; i++) {
                int cur = 1 << i;
                for (int num : nums) {
                    if ((cur & num) == cur) {
                        count[i] = count[i] == 0 ? num : count[i] & num;
                        if (count[i] == cur) {
                            found = true;
                            break;
                        }
                    }
                }
            }
            if (found) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
