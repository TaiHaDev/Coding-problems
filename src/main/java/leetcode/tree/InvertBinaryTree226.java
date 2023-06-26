package leetcode.tree;

public class InvertBinaryTree226 {
    /**
     * Holyyyyy shit! the solution is quite easy but I took a while to figure it out. I overcomplicated thing D;
     * @param args
     */
    public static void main(String[] args) {
        TreeNode n = new TreeNode(1);
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(2, n, n1);
        System.out.println(new InvertBinaryTree226().invertTree(n2));
    }
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode newNode = new TreeNode(root.val);
        newNode.left = invertTree(root.right);
        newNode.right = invertTree(root.left);
        return newNode;
    }
}
