import java.util.TreeMap;

/**
 *
 * In order to implement the Binary Search Tree
 * First we have to provide key and value in generics.
 * The good things about binary search tree is in can provide a dynamic data
 * structures that provide Logn search(if the trees is balanced)
 * The worst case, it is a a unbalanced and we can took up O(N) look up
 * where N is the number of key value pairs
 * So why not just implement balanced binary search but implement unbalanced ?
 * => Main goal: to study how to check a trees is not unbalanced
 * THE KEY DIFFERENT BETWEEN BINARY TREE AND BINARY SEARCH TREE IS:
 * ==> BINARY SEARCH TREE IS A SYMMETRIC ORDER WHILE BINARY TREE IS NOT.
 * @param <Key>
 * @param <Value>
 */
// TODO not sure I need to implement this,since the things Leetcode use is Binary Trees
//  TODO and not binary Search Tree :)(:
public class UnbalancedBinarySearchTree<Key extends Comparable<Key>, Value> {
    TreeNode root;
    private class TreeNode
    {
        Value val;
        Key key;
        TreeNode left, right;
        public TreeNode (Key key, Value val)
        {
            this.key = key;
            this.val = val;
        }
    }
//    {
//        TreeNode x = root;
//        while (x != root)
//        {
////            if(key < x.left.key) x = x.left;
////            else if(x.right.key )
//        }
//    }
}
