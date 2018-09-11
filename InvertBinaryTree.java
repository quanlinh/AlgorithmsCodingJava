/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        invertHelper(root);
        return root;

    }
    private void invertHelper(TreeNode root) {
        if(root == null) return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertHelper(root.left);
        invertHelper(root.right);
    }
}

