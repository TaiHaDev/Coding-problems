package leetcode.tree;

import java.util.ArrayList;
import java.util.Stack;

public class KthSmallestElementInBST230 {
    /**
     * using Depth First Search (DFS) to traverse to the smallest number and substract k to 1 gradually
     * until reach 0;
     * @param args
     */
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2, treeNode, null);
        TreeNode treeNode2 = new TreeNode(3, treeNode1, null);
        System.out.println(kthSmallest(treeNode2, 3));
        new ArrayList<>().clear();

    }
    public static int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = root;
        stack.push(root);
        while(!stack.isEmpty() || currentNode != null) {
            while(currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            currentNode = stack.pop();
            if (--k == 0) {
                return currentNode.val;
            }
            currentNode = currentNode.right;
        }
        return -1;
    }

}
class TreeNode {
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
