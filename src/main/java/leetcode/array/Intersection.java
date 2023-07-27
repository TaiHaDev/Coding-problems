package leetcode.array;

import java.util.HashSet;
import java.util.Set;

public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet();
        for (int n1 : nums1) {
            set1.add(n1);
        }
        Set<Integer> set2 = new HashSet();
        for (int n2: nums2) {
            set2.add(n2);
        }
        set1.retainAll(set2);
        int[] result = new int[set1.size()];
        int i = 0;
        for (int e : set1) {
            result[i++] = e;
        }
        return result;
    }
}
