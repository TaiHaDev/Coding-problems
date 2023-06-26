package big_o.array;

import java.util.Scanner;

public class PickCard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        int[] cards = new int[total];
        for (int i = 0; i < total; i++) {
            cards[i] = sc.nextInt();
        }
        int[] result = {0, 0};
        int turn = 0;
        // two pointers
        int left = 0, right = total - 1;
        while (left <= right) {
            if (cards[left] > cards[right]) {
                result[turn] += cards[left];
                left++;
            } else {
                result[turn] += cards[right];
                right--;
            }
            turn ^= 1;
        }
        System.out.println(result[0] + " " + result[1]);
    }
}
