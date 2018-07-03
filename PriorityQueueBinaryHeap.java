import java.util.PriorityQueue;

public class PriorityQueueBinaryHeap<Item> {
    private Item[] priorityQueue;
    private int sizeOfQueue;
    private final int DEFAULT_CAPACITY = 10;

    /**
     * This priority
     */
    public PriorityQueueBinaryHeap()

    {
        PriorityQueue a = new PriorityQueue();
        this.sizeOfQueue = 0;
        priorityQueue = (Item[]) new Object[DEFAULT_CAPACITY];
    }

    /**
     * Compare Interface Implementing
     * -> Defined a nested class that implements the Comparator interface.
     * -> Implement the compare() method.
     */
    /**
     * Insert take logN time for swip up the value half each
     * @param value
     */

    public void insert(Item value) {
        if (sizeOfQueue >= this.priorityQueue.length - 1) resizeQueue();
        this.priorityQueue[++this.sizeOfQueue] = value;
        swim(sizeOfQueue);
    }

    private void resizeQueue() {
        Item[] oldPriorityQueue = (Item[]) new Object[sizeOfQueue * 2];
        // need to copy up to size of queue, not less than
        for (int i = 0; i <= sizeOfQueue; i++) {
            oldPriorityQueue[i] = priorityQueue[i];
        }
        this.priorityQueue = oldPriorityQueue;
    }

    private void swim(int k) {
        while (k > 1 && aLessThanB(this.priorityQueue[k / 2], this.priorityQueue[k])) {
            exchange(k, k / 2);
            k = k / 2;
        }
    }

    /**
     * There is an edge cases that the most right child is null, so we want to prevent that
     * by making sure the left child is strictly less than the sizeofQueue
     *
     * @param k is an index that we store value is we need to sink down
     *
     */
    private void sink(int k) {
        while (2 * k <= sizeOfQueue) {
            int leftChild = 2 * k;
            int rightChild = leftChild + 1;
            int exchangeChild = leftChild;
            if (leftChild < sizeOfQueue && aLessThanB(this.priorityQueue[leftChild], this.priorityQueue[rightChild])) {
                exchangeChild = rightChild;
            }
            if (aLessThanB(this.priorityQueue[exchangeChild], this.priorityQueue[k])) break;
            exchange(k, exchangeChild);
            k = exchangeChild;
        }
    }

    public boolean aLessThanB(Item a, Item b) {
        if (a == null || b == null) throw new NullPointerException();
        // Using the comparable key for comparable instead of using implements Comparable
        //TODO I HAVE TO UNDERSTAND SUPER AND ?
        // wildcard with super type bounds let you write to a generic object
        // Source: Core Java Volume I, page 893
        Comparable<? super Item> keyA = (Comparable<? super Item>) a;
        int value = keyA.compareTo(b);
        // make the String alphabet order of A > Z
        if (value < 0) return false;
        else return true;
    }

    private void exchange(int parentNodeIndex, int childNodeIndex) {
        Item temp = this.priorityQueue[parentNodeIndex];
        this.priorityQueue[parentNodeIndex] = this.priorityQueue[childNodeIndex];
        this.priorityQueue[childNodeIndex] = temp;
    }

    /**
     *
     * @return the maximum value
     * remove take logN time for sink down the maximum element
     */
    public Item removeMin() {
        Item max = priorityQueue[1];
        exchange(1, sizeOfQueue--);
        sink(1);
        priorityQueue[sizeOfQueue + 1] = null; // prevent loitering
        return max;
    }

    public int size() {
        return this.sizeOfQueue;
    }

    public boolean isEmpty() {
        return this.sizeOfQueue == 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[ ");
        for (int i = sizeOfQueue; i > 0; i--) {
            stringBuilder.append(priorityQueue[i]);
            stringBuilder.append(" ");
        }
        stringBuilder.append(" ]");

        return stringBuilder.toString();
    }


}
