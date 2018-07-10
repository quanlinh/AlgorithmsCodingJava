import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreePreOrderTraversalTest {
    @Test
    public void testPreorderTraversal()
    {
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);

        BinaryTreePreOrderTraversal binaryTreePreOrderTraversal = new BinaryTreePreOrderTraversal();
        List<Integer> results = binaryTreePreOrderTraversal.preorderTraversal(treeNode);
        for (Integer a: results) {
            System.out.println(a);
        }

    }

}