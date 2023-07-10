package big_o.binary_search;

import java.util.Scanner;

public class ChimpProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] heights = new int[N];
        for(int i=0; i<N; i++) {
            heights[i] = sc.nextInt();
        }
        int Q = sc.nextInt();
        int[] luchuHeights = new int[Q];
        for(int i=0; i<Q; i++) {
            luchuHeights[i] = sc.nextInt();
        }
        sc.close();

        for(int i=0; i<Q; i++) {
            solveProblem(heights, luchuHeights[i]);
        }
    }

    public static void solveProblem(int[] heights, int luchuHeight) {
        int lowerChimpIndex = lowerChimp(heights, luchuHeight);
        int upperChimpIndex = upperChimp(heights, luchuHeight);

        if (lowerChimpIndex < 0)
            System.out.print("X ");
        else
            System.out.print(heights[lowerChimpIndex] + " ");

        if (upperChimpIndex >= heights.length)
            System.out.println("X");
        else
            System.out.println(heights[upperChimpIndex]);
    }

    public static int lowerChimp(int[] heights, int luchuHeight) {
        int left = 0;
        int right = heights.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (heights[mid] < luchuHeight)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return right;
    }

    public static int upperChimp(int[] heights, int luchuHeight) {
        int left = 0;
        int right = heights.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (heights[mid] <= luchuHeight)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return left;
    }
}