package leetcode.binary_search;

import java.util.List;

public class LeftMostColumn1428 {
    public class BinaryMatrix {
        public List<Integer> dimensions() {
            return null;
        }
        public int get(int row, int col) {
            return -1;
        }
    }
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimensions = binaryMatrix.dimensions();
        int row = dimensions.get(0);
        int col = dimensions.get(1);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < row; i++) {
            int left = 0;
            int right = col - 1;
            while (left <= right) {
                int mid = (left + right) >> 1;
                int cur = binaryMatrix.get(i, mid);
                if (cur == 1) {
                    res = Math.min(res, mid);
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
