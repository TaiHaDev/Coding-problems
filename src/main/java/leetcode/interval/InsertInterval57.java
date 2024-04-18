package leetcode.interval;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList();
        int len = intervals.length;
        int left = 0;
        while (left < len && intervals[left][1] < newInterval[0]) {
            res.add(intervals[left++]);
        }
        while (left < len && intervals[left][0] <= newInterval[1] && intervals[left][1] >= newInterval[0]) {
            int[] curInterval = intervals[left];
            newInterval[0] = Math.min(curInterval[0], newInterval[0]);
            newInterval[1] = Math.max(curInterval[1], newInterval[1]);
            left++;
        }
        res.add(newInterval);
        while(left < len && intervals[left][0] > newInterval[0]) {
            res.add(intervals[left++]);
        }
        return res.toArray(new int[res.size()][2]);
    }
}
