import java.util.PriorityQueue;

public class BinaryTreeQueue {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public int findSecondMinimumValue(TreeNode root) {
            PriorityQueue<Integer> listValue = new PriorityQueue<>();
            preOrderTrarversal(root, listValue);
            int smallest = listValue.poll();
            int second = listValue.poll();
            if(second > smallest)
            return second;
            else return -1;
        }
        private void preOrderTrarversal(TreeNode root, PriorityQueue<Integer> listValue) {
            if(root == null) return;
            preOrderTrarversal(root.left,listValue);
            listValue.add(root.val);
            preOrderTrarversal(root.right,listValue);

        }

    }
}
