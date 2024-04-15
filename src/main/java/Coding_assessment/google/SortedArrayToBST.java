package Coding_assessment.google;

import java.util.Arrays;

public class SortedArrayToBST {
    public static void main(String[] args) {
        System.out.println(new SortedArrayToBST().sortedArrayToBST(new int[] {-10,-2,-3,0,5,9, 10}));
    }
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
          int middleIndex = nums.length / 2;
          TreeNode curNode = new TreeNode(nums[middleIndex]);
          curNode.left =sortedArrayToBST(Arrays.copyOfRange(nums, 0, middleIndex));
          curNode.right =sortedArrayToBST(Arrays.copyOfRange(nums, middleIndex + 1, nums.length));
          return curNode;
    }





}
