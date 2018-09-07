
public class LRUCache {
    private static class HashEntry {
        int key;
        ListNode listNode;

        HashEntry(int key, ListNode listNode) {
            this.key = key;
            this.listNode = listNode;
        }
    }

    private static class ListNode {
        int key;
        int value;
        ListNode prev;
        ListNode next;

        ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private HashEntry[] hashTable;
    private ListNode head;
    private ListNode tail;
    private int size;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        // array size M must be greater than number of key-value pairs N.
        hashTable = new HashEntry[capacity * 2];
    }

    public int get(int key) {
        int index = findKeyInHashTable(key);
        if (index < 0) return -1;
        ListNode listNode = hashTable[index].listNode;
        moveToHead(listNode);
        return listNode.value;
    }

    public void put(int key, int value) {
        int index = findKeyInHashTable(key);
        if(index >= 0) {
            ListNode listNode = hashTable[index].listNode;
            listNode.value = value;
            moveToHead(listNode);
            return;
        }
        if(size == capacity) {
            removeTail();
            size--;
        }
        size++;
        ListNode listNode = new ListNode(key,value);
        moveToHead(listNode);
        index = findEmptySlotForKey(key);
        hashTable[index] = new HashEntry(key,listNode);
    }

    private void moveToHead(ListNode node) {
        if (node == head) return;
        if (node == tail) tail = tail.prev; // why is it?
        ListNode prev = node.prev, next = node.next;
        if (prev != null) prev.next = next;
        if (next != null) next.prev = prev;
        if (head == null) {
            head = tail = node;
            return;
        }
        head.prev = node;
        node.next = head;
        head = node;
        node.prev = null;
        tail.next = null;

    }

    private int findEmptySlotForKey(int key) {
        int index = key % hashTable.length;
        while (true) {
            if (hashTable[index] == null) return index;
            index++;
            if (index == hashTable.length) index = 0;
        }
    }

    private int findKeyInHashTable(int key) {
        int index = key % hashTable.length;
        while (true) {
            if (hashTable[index] == null) return -1;
            if (hashTable[index].key == key) return index;
            if (index == hashTable.length) {
                index = 0;
            }
        }
    }

    private void removeTail() {
        int index = findKeyInHashTable(tail.key);
        hashTable[index] = null;

        ListNode prevOfTail = tail.prev;
        if (prevOfTail == null) {
            head = tail = null;
            return;
        } else {
            prevOfTail.next = null;
            tail.prev = null;
            tail = prevOfTail;
        }

    }

}
