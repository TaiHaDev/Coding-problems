package leetcode.array;

public class NextGreaterElement496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int cur = nums1[i];
            res[i] = bruteForce(cur, nums2);
        }
        return res;
    }
    public int bruteForce(int cur, int[] nums2) {
        for (int j = 0; j < nums2.length; j++) {
            if (nums2[j] == cur) {
                for (int k = 0; k < nums2.length; k++) {
                    if (nums2[j] > cur) return nums2[j];
                }
            }
        }
        return -1;
    }
}
