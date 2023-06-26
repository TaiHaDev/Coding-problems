package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevel102 {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(15);
        TreeNode treeNode2 = new TreeNode(7);
        TreeNode treeNode3 = new TreeNode(20, treeNode1, treeNode2);
        TreeNode treeNode4 = new TreeNode(9);
        TreeNode treeNode5 = new TreeNode(3, treeNode4, treeNode3);
        System.out.println(levelOrder(treeNode5));
    }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while(!queue.isEmpty()) {
            List<Integer> level = new ArrayList();
            int currentLevelLength = queue.size();
            for (int i = 0; i < currentLevelLength; i++) {
                TreeNode curr = queue.poll();
                if (curr != null) {
                    queue.add(curr.left);
                    queue.add(curr.right);
                    level.add(curr.val);
                };
            }
            if (level.size() > 0) {
                result.add(level);
            }
        }
        return result;
    }
}

