package leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectII {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap();
        for (int n1 : nums1) {
            map.put(n1, map.getOrDefault(n1, 0) + 1);
        }
        List<Integer> result = new ArrayList();
        for (int n2: nums2) {
            int count = map.getOrDefault(n2, 0);
            if (count > 0) {
                result.add(n2);
            }
            map.put(n2, count - 1);
        }
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }
}
