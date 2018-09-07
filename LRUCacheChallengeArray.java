import java.util.ArrayDeque;

// TODO AFTER EXPRIMENT, VERY SLOW WHEN USED ARRAY DEQUE
// TODO have more time, can study more how to manage the null by constant update, and shrink
public class LRUCacheChallengeArray {
    private static class HashEntry {
        int key;
        int value;

        HashEntry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private HashEntry[] hashTable;
    private int[] keyUses;
    private int size;
    private int capacity;
    private int beginPointer;
    private int endPointer;

    public LRUCacheChallengeArray(int capacity) {
        this.capacity = capacity;
        // array size M must be greater than number of key-value pairs N.
        hashTable = new HashEntry[capacity * 2];
        this.size = 0;
        keyUses = new int[capacity * 2];
        beginPointer = endPointer = keyUses.length - 1;
    }

    public int get(int key) {
        int index = findKeyInHashTable(key);
        if (index == -1) return index;
        else {
            //TODO call update the just used
            updateUseKey(key);
            return hashTable[index].value;

        }
    }

    public void put(int key, int value) {
        int index = findKeyInHashTable(key);
        // update old value
        if (index != -1) {
            hashTable[index].value = value;
            updateUseKey(key);
//            updateUseKey(key); // solved by runner update
            return;
        }
        if (size == capacity) {
            int lastKey = keyUses[--endPointer];
//            int lastKey = keyUses.removeLast();
            int indexRemove = findKeyInHashTable(lastKey);
            hashTable[indexRemove] = null;
        }
        size++;
        int indexToInsert = findEmptySlotInHashTable(key);
        hashTable[indexToInsert] = new HashEntry(key, value);
        putNewKey(key);
//        updateUseKey(key); put new key solved it

    }

    private void updateUseKey(int key) {
        int indexKey = beginPointer;
        while (keyUses[indexKey] != key) indexKey++;
        int temp = keyUses[indexKey];
        int runner = indexKey;
        while (runner > 0 && runner > beginPointer) {
            keyUses[runner] = keyUses[--runner];
        }
        keyUses[beginPointer] = temp;
    }

    private void putNewKey(int key) {
        if (beginPointer <= 0) {
            // move the pointer back to middle
            int[] temp = new int[keyUses.length];
            for (int mid = keyUses.length / 2; mid < keyUses.length; mid++) {
                temp[mid] = keyUses[++beginPointer];
            }
            keyUses = temp;
        } else {
            keyUses[--beginPointer] = key;
        }
    }

//    private void updateUseKey(int key) {
//        keyUses.remove(key);
//        keyUses.addFirst(key);
//    }

    private int findKeyInHashTable(int key) {
        int index = key % hashTable.length;
        while (true) {
            if (hashTable[index] == null) return -1;
            else if (hashTable[index].key == key) return index;
            else {
                index++;
                if (index == hashTable.length) index = 0;
            }
        }
    }

    private int findEmptySlotInHashTable(int key) {
        int index = key % hashTable.length;
        while (true) {
            if (hashTable[index] == null) return index;
            else {
                index++;
                if (index == hashTable.length) index = 0;
            }
        }
    }
}
