package Coding_assessment.canva;

import java.util.Arrays;

public class EffcientWorkers {
    public static void main(String[] args) {
        int[] efficiency = {4, 2, 8, 1, 9};
        System.out.println(minimumCost(efficiency));
    }

    public static int minimumCost(int[] efficiency) {
        Arrays.sort(efficiency);
        int res = Integer.MAX_VALUE;
        int[] oddArray = new int[efficiency.length / 2 + 1];
        int[] evenArray = new int[efficiency.length / 2 + 1];
        for (int i = 0; i < efficiency.length / 2; i++) {
            oddArray[i + 1] = oddArray[i] + efficiency[2 * i +2] - efficiency[2 * i + 1];
        }
        for (int i = 0; i < efficiency.length / 2 ; i++) {
            evenArray[i + 1] = evenArray[i] + efficiency[2*i + 1] - efficiency[2*i];
        }
        for (int i = 0; i < efficiency.length; i++) {
            int curRes = 0;
            if (i % 2 == 0) {
                curRes += oddArray[oddArray.length - 1] - oddArray[i / 2];
                curRes += evenArray[i/2] - evenArray[0];
            } else {
                curRes += evenArray[oddArray.length - 1] - evenArray[i / 2];
                curRes += oddArray[i/2] - oddArray[0];
            }
            res = Math.min(curRes, res);
        }
        return res;
    }
}
