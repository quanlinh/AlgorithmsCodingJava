import java.util.ArrayList;
import java.util.List;

public class BinaryTreeTraversalsDataStructure {
    // TODO build a trees from scratch

    /**
     * In this problems we have a binary tree had been build from a binary Heap
     * layout. And we will traversal each level from left to right
     *
     * @param root A root of binary Tree
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<ArrayList<TreeNode>> tree = new ArrayList<>(); // A list for each level
        if (root == null) return res;
        ArrayList<TreeNode> levelOne = new ArrayList<>();
        levelOne.add(root);
        tree.add(levelOne); // add rootNode
        ArrayList<Integer> rootValue = new ArrayList<>();
        rootValue.add(root.val);
        res.add(rootValue);
        //  While tree is not empty, travel all its level before continue to next level
        while (!tree.isEmpty()) {
            ArrayList<TreeNode> nodeAtLevel = tree.remove(0);             // extract a list of level node
            ArrayList<TreeNode> childrenLevel = new ArrayList<>();
            ArrayList<Integer> valueAtEachLevel = new ArrayList<>();
            while (!nodeAtLevel.isEmpty()) {
                TreeNode x = nodeAtLevel.remove(0);
                if (x.left != null) {
                    childrenLevel.add(x.left);
                    valueAtEachLevel.add(x.left.val);
                }
                if (x.right != null) {
                    childrenLevel.add(x.right);
                    valueAtEachLevel.add(x.right.val);
                }
            }
            if (!valueAtEachLevel.isEmpty()) {
                res.add(0, valueAtEachLevel);
            }
            if (!childrenLevel.isEmpty()) tree.add(0, childrenLevel);
        }
        return res;

    }

    public static void main(String args[]) {

    }
}
