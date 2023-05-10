package nab_intern;

import java.util.HashSet;
import java.util.Set;

public class Task3 {
    // img_1.png
    public static void main(String[] args) {
        System.out.println(solution(4, new int[]{1,2,1,3}, new int[] {2,4,3,4}));
        System.out.println(solution(4, new int[]{1,2,4,4,3}, new int[] {2,3,1,3,1}));

    }
    public static boolean solution(int N, int[] A, int[] B) {
        int edgeCount = 0;
        Set<Integer> visitedNode = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            if (Math.abs(A[i] - B[i]) == 1) {
                visitedNode.add(A[i]);
                visitedNode.add(B[i]);
                edgeCount++;
            }
        }
        return visitedNode.size() == N && edgeCount == (N-1);
    }
}
