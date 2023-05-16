package anh_tin_dtrai;

import java.util.HashMap;
import java.util.Map;

public class Task2 {
    /**
     * ques1.png
     */
    public static void main(String[] args) {
        int[][] tests = {{1,2,2},{1,3,3}, {1,4,4}};
        System.out.println(solution(tests));
    }
    public static int solution(int[][] A) {
        int result = 0;
        Map<Integer, Integer> doctorSchedule = new HashMap<>();
        for (int col = 0; col < A.length; col++) {
            for (int row = 0; row < A[col].length; row++) {
                int currentKey = A[col][row];
                if (!doctorSchedule.containsKey(currentKey)) {
                    doctorSchedule.put(currentKey, col);
                } else {
                    if (doctorSchedule.get(currentKey) == -1) continue;
                    if (doctorSchedule.get(currentKey) != col) {
                        result++;
                        doctorSchedule.put(currentKey, -1);
                    }
                }
            }
        }
        return result;
    }
}
