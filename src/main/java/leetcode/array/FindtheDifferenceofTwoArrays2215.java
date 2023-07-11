package leetcode.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindtheDifferenceofTwoArrays2215 {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        for (int n1 : nums1) {
            set1.add(n1);
        }
        for (int n2 : nums2) {
            set2.add(n2);
        }
        for (int n1 : nums1) {
            if (!set2.contains(n1)) {
                l1.add(n1);
            }
        }
        for (int n2 : nums2) {
            if (!set1.contains(n2)) {
                l2.add(n2);
            }
        }
        return List.of(l1, l2);
    }
}
