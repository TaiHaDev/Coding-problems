package coding_assessment;

import java.util.Scanner;

public class CVeliminateString {
    public static void main(String[] args) {
        System.out.println(getFinalString("AWAWSSG"));
    }
    public static String getFinalString(String s) {
        // note: my first intuitive solution was to use a while loop and for each loop, remove the
        // AWS string but the complexity of this would be O(N^2) so I tried dynamic programming to make it O(n)
        StringBuilder last = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            last.append(s.charAt(i));
            if (last.toString().endsWith("SWA")) {
                last.delete(last.length() - 3, last.length());
                s = s.substring(0, i) + s.substring(i + 3);
            }
        }
        return s.equals("") ? "-1" : s;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i< n; i++) {
            nums[i] = sc.nextInt();
        }
        boolean result = fashionInBerland(n, nums);
        if (result) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
    public static boolean fashionInBerland(int n, int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (num == 0) count++;
        }
        if (n == 1) return count == 0;
        return count == 1;
    }
}
