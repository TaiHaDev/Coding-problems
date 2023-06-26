package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView199 {
    /**
     * can be done using the standard algorithm to capture element in binary tree level by level (binary tree level 102 leetcode)
     * the intuition: get the current level of the binary tree then get the right most element.
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList();
            int levelLen = queue.size();
            for (int i = 0; i < levelLen; i++) {
                TreeNode curr = queue.poll();
                if (curr != null) {
                    queue.add(curr.right);
                    queue.add(curr.left);
                    level.add(curr.val);
                };
            }
            if (level.size() > 0) {
                result.add(level.get(0));
            }
        }
        return result;
    }

    /**
     * version 2 a little cleaner
     */
    public List<Integer> rightSideViewV2(TreeNode root) {
        List<Integer> result = new ArrayList();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelLen = queue.size();
            for (int i = 0; i < levelLen; i++) {
                TreeNode curr = queue.poll();
                if (i == 0) result.add(curr.val);
                if (curr.right != null) queue.add(curr.right);
                if (curr.left != null) queue.add(curr.left);
            }
        }
        return result;
    }
}
