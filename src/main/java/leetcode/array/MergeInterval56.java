package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeInterval56 {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};

        System.out.println(Arrays.deepToString(new MergeInterval56().merge(intervals)));
    }
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        List<int[]> res = new ArrayList<>();
        int curLow = intervals[0][0];
        int curHigh = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int[] curInterval = intervals[i];
            if (curInterval[0] <= curHigh) {
                curHigh = Math.max(curInterval[1], curHigh);
            } else {
                res.add(new int[] {curLow, curHigh});
                curLow = curInterval[0];
                curHigh = curInterval[1];
            }
        }
        res.add(new int[] {curLow, curHigh});
        return res.toArray(new int[res.size()][2]);
    }
}
