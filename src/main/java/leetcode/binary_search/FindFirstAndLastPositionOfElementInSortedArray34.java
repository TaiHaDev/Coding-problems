package leetcode.binary_search;

public class FindFirstAndLastPositionOfElementInSortedArray34 {
    public int[] searchRange(int[] nums, int target) {
        return new int[] {searchLower(nums,target), searchUpper(nums, target)};
    }
    public int searchUpper(int[] nums, int target) {
        int l = 0, h = nums.length - 1;
        int res = -1;
        while(l <= h) {
            int mid = (l + h) >> 1;
            if (nums[mid] > target) {
                h = mid - 1;
            } else {
                l = mid + 1;
                if (nums[mid] == target) {
                    res = mid;
                }
            }
        }
        return res;
    }

    public int searchLower(int[] nums, int target) {
        int l = 0, h = nums.length - 1;
        int res = -1;
        while (l <= h) {
            int mid = (l + h) >> 1;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                h = mid - 1;
                if (nums[mid] == target) {
                    res = mid;
                }
            }
        }
        return res;
    }
}
