package Coding_assessment.aws;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProcessAndProcessor {
    public static void main(String[] args) {
        System.out.println(new ProcessAndProcessor().processExecution(List.of(4,6,7,10), List.of(4,5,8), List.of(6,11,10)));

    }
    public static List<List<Long>> processExecution(List<Integer> power, List<Integer> minPower, List<Integer> maxPower) {
        // Write your code here
        // my initial idea is to solve it by using two for loop but I think it's definitely easy and and needed to be precompute
        // now I need to precompute and query the answer for each of the processor. I think I will sort it and precompute which will take O(nlogn) instead of O(n^2)
        // sort power array and using accumulative array.
        List<Long> accum = new ArrayList<Long>();
        accum.add((long) power.get(0));
        for (int i = 1; i < power.size(); i++) {
            accum.add((long) power.get(i) + accum.get(i - 1));
        }
        List<List<Long>> res = new ArrayList();
        for (int i = 0; i < minPower.size(); i++) {
            int curMin = minPower.get(i);
            int curMax = maxPower.get(i);
            int powerUpperIndex = Collections.binarySearch(power, curMax);
            int powerLowerIndex = Collections.binarySearch(power, curMin);
            if (powerUpperIndex < 0) {
                powerUpperIndex = -powerUpperIndex - 2;
            }
            if (powerLowerIndex < 0) {
                powerLowerIndex = -powerLowerIndex - 1;
            }
            if (powerUpperIndex < 0 || powerLowerIndex == accum.size()) {
                res.add(List.of(0l,0l));
                continue;
            }
            long processable = powerUpperIndex - powerLowerIndex + 1;
            long totalPower = accum.get(powerUpperIndex) - (curMin <= accum.get(0) ? 0 : accum.get(powerLowerIndex - 1));
            res.add(List.of(processable, totalPower));
        }
        return res;
    }
}
