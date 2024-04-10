package leetcode.array;

public class MergeSortedArray88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx = m + n - 1;
        int i = m - 1;
        int j = n - 1;
        while (i >= 0 && j >= 0) {
            int cur1 = nums1[i];
            int cur2 = nums2[j];
            if (cur1 >= cur2) {
                nums1[idx] = cur1;
                i--;
            } else {
                nums1[idx] = cur2;
                j--;
            }
            idx--;
        }
        while (j >= 0) {
            nums1[idx] = nums2[j];
            idx--;
            j--;
        }
    }
}
