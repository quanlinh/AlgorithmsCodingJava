import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriorityQueueBinaryHeapTest {

    @Test
    void insert() {
        // TODO add more advanced testing
        PriorityQueueBinaryHeap integerQueue = new PriorityQueueBinaryHeap();
        integerQueue.insert(1);
        integerQueue.insert(2);
        PriorityQueueBinaryHeap stringQueue = new PriorityQueueBinaryHeap();
        stringQueue.insert("P");
        stringQueue.insert("Q");
        stringQueue.insert("E");
        stringQueue.removeMax();
        stringQueue.insert("X");
        stringQueue.insert("A");
        stringQueue.insert("M");
        stringQueue.removeMax();
//        System.out.println(integerQueue.toString());
        System.out.println(stringQueue.toString());
    }
}