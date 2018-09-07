import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {

    /**
     * initialize your data structure here.
     */
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue();
        maxHeap = new PriorityQueue(Collections.reverseOrder());
    }

    public void addNum(int num) {
        minHeap.add(num);
        if (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.add(minHeap.remove());
        }

    }

    public double findMedian() {
        if (minHeap.size() > maxHeap.size()) {
            return (double) minHeap.peek();
        } else {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        }

    }
}
