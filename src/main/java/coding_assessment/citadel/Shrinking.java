package coding_assessment.citadel;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Shrinking {
    public static void main(String[] args) {
        List<Integer> point = new ArrayList<>(List.of(-10, 9, 10));
        System.out.println(minimize(point, 3));
    }

    public static int minimize(List<Integer> point, int k) {
        if (point == null || point.size() == 0) {
            return 0;
        }
        Collections.sort(point);
        int n = point.size();
        int diff = point.get(n - 1) - point.get(0);
        for (int i = 0; i < n - 1; i++) {
            int a = point.get(i) + k;
            int b = point.get(i + 1) - k;
            int high = Math.max(a, point.get(n - 1) - k);
            int low = Math.min(b, point.get(0) + k);
            diff = Math.min(diff, high - low);
        }
        return diff;
    }

}
