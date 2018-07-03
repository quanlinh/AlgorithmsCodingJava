import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * A Red Black Tree is a BST such that:
 * No node has two red links connect to it.
 * Every path from root to null link has the same number of black links.
 * Red links lean left.
 * Balance Red Black Tree is not allowed duplicate keys.
 */
public class BalanceRedBlackTree<Key extends Comparable<Key>, Value> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private Node root;

    private class Node implements Comparable {
        private Key key;
        private Value val;
        private Node left, right;
        boolean color;  // color of parent link
        int N; // node in this subtree

        public Node(Key key, Value val, int N, boolean color) {
            this.key = key;
            this.val = val;
            this.N = N;
            this.color = color;
        }

        /**
         * I have to implement comparable to to priority Queue able to compare two node
         * @param o
         * @return
         */
        @Override
        public int compareTo(Object o) {
           return this.key.compareTo(((Node)o).key);
        }
    }

    private boolean isLinkToParentRed(Node x) {
        if (x == null) return false; // null links are black( default null pointer)
        return x.color == RED;
    }
    // TODO figure out how to implement search return ???
//    public Value get(Key key)
//    {
//        Node x = root;
//        while (x != null)
//        {
//            int comp = key.compareTo(x.key);
//            if (comp < 0) x = x;
//        }
//    }

    /**
     * Invariants. Maintains symmetric order and perfect black balance.
     *
     * @param h The node need to be rotate
     * @return the Node that thad been rotate
     */
    private Node rotateLeft(Node h) {
        assert isLinkToParentRed(h.right);// make sure it needs to be rotate
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    /**
     * Right rotation. Orient a left-leaning red link to (temporarily) lean right.
     * Note: this is temporarily, and not PERMANENT.
     *
     * @param h
     * @return
     */
    private Node rotateRight(Node h) {
        assert isLinkToParentRed(h.left);// make sure it needs to be rotate
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    /**
     * Recolor to split a (temporary) 4-node.
     *
     * @param h
     */
    private void flipColors(Node h) {
        assert !isLinkToParentRed(h);
        assert isLinkToParentRed(h.left);
        assert isLinkToParentRed(h.right);
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;

    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        else return x.N;
    }


    public void put(Key key, Value val) {
        root = put(root, key, val);
        root.color = BLACK; // COLOR THE ROOT BLACK AFTER EACH INSERTION
    }

    private Node put(Node h, Key key, Value val) {
        // Eventually it will reach to the point that h is null and red node being inserted
        // If the new key is smaller than the key in the tree, we just make a new red node with the tree
        // and we are done. ( This apply for any element from 1 to N node).
        // But if the new key is larger than the key in the tree, then attached a new red nodes
        // give a right-leaning red link, this is violate the invariant
        // so we need to call rotateLeft(h)
        if (h == null) // Do standard insert, with red link to parent.
            return new Node(key, val, 1, RED);

        int cmp = key.compareTo(h.key);
//        System.out.println(cmp);
        if (cmp < 0) h.left = put(h.left, key, val);
        else if (cmp > 0) h.right = put(h.right, key, val);
        else h.val = val;
        // link to parent on the right is red and on the left is not red
        if (isLinkToParentRed(h.right) && !isLinkToParentRed(h.left)) { // lean left
            h = rotateLeft(h);
        }
        if (isLinkToParentRed(h.left) && isLinkToParentRed(h.left.left)) { // balance 4-node
            h = rotateRight(h);
        }
        if (isLinkToParentRed(h.left) && isLinkToParentRed(h.right)) {
            flipColors(h);
        }
        // This is necessary since we may connect another big sub trees
        h.N = size(h.left) + size(h.right) + 1;
        return h;
    }

    // TODO: FIXED THIS, NOT CORRECT
    public String toLeftString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node x = root;
        stringBuilder.append("[ ");
        System.out.println(root.val);
        System.out.println(root.key);
        while (x != null) {
            stringBuilder.append(" Key=" + x.key);
            stringBuilder.append(" Value=" + x.val);
            x = x.left;
        }
        stringBuilder.append(" ]");
        return stringBuilder.toString();
    }

    public String toRightString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node x = root;
        stringBuilder.append("[ ");
        while (x != null) {
            stringBuilder.append(" Key=" + x.key);
            stringBuilder.append(" Value=" + x.val);
            x = x.right;
        }
        stringBuilder.append(" ]");
        return stringBuilder.toString();
    }

    /**
     * Inorder traversal return the trees in order
     *
     * @return the ArrayList that have inorder keys
     */
    public List<?> inorderTraversalTree() {
        ArrayList<Key> listOfKeys = new ArrayList<>();
        inorderTraversalTree(this.root, listOfKeys);
        return listOfKeys;
    }

    private void inorderTraversalTree(Node root, ArrayList<Key> listOfKey) {
        if (root != null) {
            inorderTraversalTree(root.left, listOfKey);
            listOfKey.add(root.key);
            inorderTraversalTree(root.right, listOfKey);
        }
    }

    /**
     * Pre Order Traversal Tree is used Depth First Search For Keys
     */
    public List<?> preOrderTraversalTree() {
        ArrayList<Key> listOfKeys = new ArrayList<>();
        preOrderTraversalTree(this.root, listOfKeys);
        return listOfKeys;
    }

    private void preOrderTraversalTree(Node root, ArrayList<Key> listOfKey) {
        if (root != null) {
            listOfKey.add(root.key);
            preOrderTraversalTree(root.left, listOfKey);
            preOrderTraversalTree(root.right, listOfKey);
        }
    }

    /**
     * Level order traversal is travel each level of the trees before reaching the next level
     *
     * @return
     */
    public List<?> levelOrderTraversalTree() {
        ArrayList<Key> listOfKeys = new ArrayList<>();

//        PriorityQueueBinaryHeap<Node> queueBinaryHeap = new PriorityQueueBinaryHeap<>();
        // This is wrong, I should use Queue, instead priority Queue
        ArrayList<Node> queueArray = new ArrayList<>();

        queueArray.add(this.root);
        while (!queueArray.isEmpty()) {
            Node x = queueArray.remove(0); // remove at the begin of Array, LAST IN FIRST OUT
            listOfKeys.add(x.key);
            if (x.left != null) queueArray.add(x.left);
            if (x.right != null) queueArray.add(x.right);
        }
        return listOfKeys;
    }

    /**
     * Attempt to implement it by iterative
     *
     * @return
     */
    public List<?> inorderTraversalTreeIterative() {
        ArrayList<Key> listOfKeys = new ArrayList<>();
        PriorityQueueBinaryHeap<Key> minQueue = new PriorityQueueBinaryHeap<>();
        Node x = this.root;
        minQueue.insert(x.key); // put the key in to min Queue
        while (x != null) {
            // How to get all the value
        }
        return listOfKeys;// TODO IMPLEMENT THIS
    }

    public Key findMinimum() {
        return findMinimum(this.root);
    }

    private Key findMinimum(Node x) {
        if (x == null) return null;
        while (x.left != null) {
            x = x.left;
        }
        return x.key;
    }

    public Key findMaximum() {
        return findMaximum(this.root);
    }

    private Key findMaximum(Node x) {
        if (x == null) return null;
        while (x.right != null) {
            x = x.right;
        }
        return x.key;
    }

}
