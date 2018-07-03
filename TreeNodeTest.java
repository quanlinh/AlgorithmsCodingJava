import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeNodeTest {
    @Test
    void minDepth() {
        TreeNode treeNode = new TreeNode(3);
        TreeNode root9 = new TreeNode(9);
        treeNode.left = root9;
        TreeNode root20 = new TreeNode(20);
        TreeNode root15 = new TreeNode(15);
        TreeNode root7 = new TreeNode(7);
        root20.left = root15;
        root20.right = root7;
        treeNode.right = root20;
        System.out.println(treeNode.minDepth(treeNode));
    }

}