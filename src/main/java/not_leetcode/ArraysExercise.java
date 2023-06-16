package not_leetcode;

import java.util.Scanner;

public class ArraysExercise {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int aSize = sc.nextInt();
        int bSize = sc.nextInt();
        int k = sc.nextInt();
        int m = sc.nextInt();
        int[] A = new int[aSize];
        int[] B = new int[bSize];
        for (int i = 0; i < aSize; i++) {
            A[i] = sc.nextInt();
        }
        for (int i = 0; i < bSize; i++) {
            B[i] = sc.nextInt();
        }
        if (A[k - 1] < B[bSize - m]) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}
