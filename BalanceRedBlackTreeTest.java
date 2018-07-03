import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BalanceRedBlackTreeTest {
    @Test
    public void insertIntoASingle2Node() {
        // Test based on reasoning of logic in Algorithms Java page 435
        System.out.println("Insert single 2-node on left hand sight");
        BalanceRedBlackTree<String, Integer> insertLessThan = new BalanceRedBlackTree<>();
        insertLessThan.put("b", 2);
        insertLessThan.put("a", 2);
        insertLessThan.put("a", 2);
        assertEquals(insertLessThan.size(), 2);// Test for duplicate key a
        System.out.println("Insert single 2-node on right hand sight");
        BalanceRedBlackTree<String, Integer> insertGreaterThan = new BalanceRedBlackTree<>();
        insertGreaterThan.put("a", 2);
        insertGreaterThan.put("b", 2);
        insertGreaterThan.put("b", 2);
        assertEquals(insertGreaterThan.size(), 2);// Test for duplicate key a

    }

    @Test
    public void insertIntoA2NodeAtBottom() {
        // If the parent is a 2-Node, then the problems go back to insertIntoASingle2Node
        // If the child Node is insert wrong in the right hand sides, rotate left would fixed it
        System.out.println("Insert into a 2-node at the bottom.");
        BalanceRedBlackTree<String, Integer> insertIntoA2NodeAtBottom = new BalanceRedBlackTree<>();
        insertIntoA2NodeAtBottom.put("E", 1);
        insertIntoA2NodeAtBottom.put("A", 1);
        insertIntoA2NodeAtBottom.put("S", 1); // this incident of two red link children flip colors
        insertIntoA2NodeAtBottom.put("R", 1);
        insertIntoA2NodeAtBottom.put("C", 1); // C is below A, need to be rotate left
    }

    @Test
    public void insertIntoATreeWithTwoKeysInThreeNodes() {
        // There are 3 sub cases:
        // The simplest of three cases is when the new key is larger than the two in the tree
        // and is therefore attached on the right most link of the 3-node.
        System.out.println(" Insert two children one bigger and one smaller, wrong two red links -> flip colors");
        BalanceRedBlackTree<String, Integer> case1 = new BalanceRedBlackTree<>();
        case1.put("b", 1);
        case1.put("a", 1);
        case1.put("c", 1);
        System.out.println("Insert two red links on  the left size, wrong height, -> fixed: rotate right ->flip color");
        BalanceRedBlackTree<String, Integer> case2 = new BalanceRedBlackTree<>();
        case2.put("c", 0);
        case2.put("b", 0);
        case2.put("a", 0);
        System.out.println("Insert new node on the &RHS with -> rotateLeft make it becomes cases 2->" +
                " rotate right -> case 1");
        BalanceRedBlackTree<String, Integer> case3 = new BalanceRedBlackTree<>();
        case3.put("c", 0);
        case3.put("a", 0);
        case3.put("b", 0);
    }

    @Test
    public void insertIntoA3NodeAtTheBottom() {
        BalanceRedBlackTree<String, Integer> case1 = new BalanceRedBlackTree<>();
        System.out.println(case1.findMinimum()); // edge cases, null root
        System.out.println(case1.findMaximum()); // edge cases, null root
        case1.put("E", 1);
        case1.put("A", 1);
        case1.put("C", 1);
        case1.put("R", 1);
        case1.put("S", 1);
        System.out.println(" InOrder ");
        case1.put("H", 1);

        List<?> res = case1.inorderTraversalTree();
        for (Object o : res) {
            System.out.println(o);
        }
        System.out.println(case1.toRightString());
        System.out.println(case1.toLeftString());
        System.out.println(case1.findMinimum() + " minimum ");
        System.out.println(case1.findMaximum() + " maximum ");

        System.out.println(" Pre order");

        List<?> preOrder = case1.preOrderTraversalTree();
        for (Object o : preOrder) {
            System.out.println(o);
        }
    }

    @Test
    void testPreOrderTraversal() {
        BalanceRedBlackTree<String, Integer> tree = new BalanceRedBlackTree<>();
        tree.put("Les", 0);
        tree.put("Cathy", 0);
        tree.put("Alex", 0);
        tree.put("Frank", 0);
        tree.put("Sam", 0);
        tree.put("Nancy", 0);
        tree.put("Violet", 0);
        tree.put("Tony", 0);
        tree.put("Wendy", 0);
        List<?> preOrder = tree.preOrderTraversalTree();
        List<?> inOrder = tree.inorderTraversalTree();
        printListKey(preOrder, tree);
        System.out.println();
        printListKey(inOrder, tree);
        List<?> levelOrder = tree.levelOrderTraversalTree();
        System.out.println();
        printListKey(levelOrder,tree);
    }

    public void printListKey(List<?> list, BalanceRedBlackTree<?, ?> tree) {
        for (Object o : list) {
            System.out.println(o);
        }
    }

    @Test
    public void insertSameOrder() {
        BalanceRedBlackTree<String, Integer> stringIntegerBalanceRedBlackTree = new BalanceRedBlackTree<>();
        stringIntegerBalanceRedBlackTree.put("S", 1);
        assertEquals(stringIntegerBalanceRedBlackTree.size(), 1);
        stringIntegerBalanceRedBlackTree.put("E", 1);
        assertEquals(stringIntegerBalanceRedBlackTree.size(), 2);

        stringIntegerBalanceRedBlackTree.put("A", 1);
        assertEquals(stringIntegerBalanceRedBlackTree.size(), 3);

        stringIntegerBalanceRedBlackTree.put("R", 1);
        assertEquals(stringIntegerBalanceRedBlackTree.size(), 4);

        stringIntegerBalanceRedBlackTree.put("C", 1);
        assertEquals(stringIntegerBalanceRedBlackTree.size(), 5);

        stringIntegerBalanceRedBlackTree.put("H", 1);
        assertEquals(stringIntegerBalanceRedBlackTree.size(), 6);

        stringIntegerBalanceRedBlackTree.put("X", 1);
        assertEquals(stringIntegerBalanceRedBlackTree.size(), 7);

        stringIntegerBalanceRedBlackTree.put("M", 1);
        assertEquals(stringIntegerBalanceRedBlackTree.size(), 8);

        stringIntegerBalanceRedBlackTree.put("P", 1);
        assertEquals(stringIntegerBalanceRedBlackTree.size(), 9);

        stringIntegerBalanceRedBlackTree.put("L", 1);
        assertEquals(stringIntegerBalanceRedBlackTree.size(), 10);

        BalanceRedBlackTree<String, Integer> stringIntegerBalanceRedBlackTree2 = new BalanceRedBlackTree<>();
        stringIntegerBalanceRedBlackTree.put("A", 1);
        stringIntegerBalanceRedBlackTree.put("C", 1);
        stringIntegerBalanceRedBlackTree.put("E", 1);
        stringIntegerBalanceRedBlackTree.put("H", 1);
        stringIntegerBalanceRedBlackTree.put("L", 1);
        stringIntegerBalanceRedBlackTree.put("M", 1);
        stringIntegerBalanceRedBlackTree.put("P", 1);
        stringIntegerBalanceRedBlackTree.put("R", 1);
        stringIntegerBalanceRedBlackTree.put("S", 1);
        stringIntegerBalanceRedBlackTree.put("X", 1);


    }

}