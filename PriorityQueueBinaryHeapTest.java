import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriorityQueueBinaryHeapTest {

    @Test
    void insert() {
        // TODO add more advanced testing
        PriorityQueueBinaryHeap integerQueue = new PriorityQueueBinaryHeap();
        integerQueue.insert(1);
        integerQueue.insert(2);
        integerQueue.insert(3);
        integerQueue.insert(4);
        integerQueue.insert(5);
        integerQueue.insert(6);
        integerQueue.insert(7);
        System.out.println(integerQueue.removeMin());
        PriorityQueueBinaryHeap stringQueue = new PriorityQueueBinaryHeap();
        stringQueue.insert("P");
        stringQueue.insert("Q");
        stringQueue.insert("E");
        stringQueue.removeMin();
        stringQueue.insert("X");
        stringQueue.insert("A");
        stringQueue.insert("M");
        stringQueue.removeMin();
        System.out.println(integerQueue.toString());
        System.out.println(stringQueue.toString());
    }

    @Test()
    void testHeapSorted() {
        int sizeArray = 10000;
        PriorityQueueBinaryHeap integerQueue = new PriorityQueueBinaryHeap();
        RandomArray randomArray = new RandomArray(sizeArray);
        int[] arrayUnsorted = randomArray.randomInteger();
        int[] arrayUnsortedCopy = new int[sizeArray];
        for (int i = 0; i < sizeArray; i++) arrayUnsortedCopy[i] = arrayUnsorted[i];
        randomizedQuickSorted qs = new randomizedQuickSorted();
        qs.quickSorted(arrayUnsortedCopy);
        for (int val : arrayUnsorted) {
            integerQueue.insert(val);
        }
        for (int i = 0; i < sizeArray; i++) {
            arrayUnsorted[i] = (int) integerQueue.removeMin();
        }
        for (int i = 0; i < sizeArray; i++)
        {
            assertEquals(arrayUnsorted[i],arrayUnsortedCopy[i]);
        }
    }
}