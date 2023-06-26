package big_o.array;

import java.util.Scanner;

public class MostBookRead {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        int time = sc.nextInt();
        int[] bookTime = new int[total];
        for (int i = 0; i < total; i++) {
            bookTime[i] = sc.nextInt();
        }
        // compute sum array
        int[] sumArray = new int[total];
        sumArray[0] = bookTime[0];
        for (int i = 1; i < total; i++) {
            sumArray[i] = sumArray[i - 1] + bookTime[i];
        }
        // two pointers
        int max = 0;
        int left = 0;
        int right = 0;
        while(right < total) {
            int curSum = sumArray[right] - sumArray[left] + bookTime[left];
            if (curSum <= time) {
                max = Math.max(right - left + 1, max);
                right++;
            } else {
                left++;
                if (left > right) {
                    right = left;
                }
            }
        }
        System.out.println(max);
    }

}
