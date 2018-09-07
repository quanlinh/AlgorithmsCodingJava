import java.util.Comparator;
import java.util.concurrent.ThreadLocalRandom;

public class randomizedQuickSorted {
    /**
     * The comparator to compare the objects
     *
     * @param nums
     * @param comparator
     */
    public void quickSorted(Object[] nums, Comparator<? super Object> comparator) {
        if (nums.length < 2) return;
        threeWayQuickSorted(nums, 0, nums.length - 1, comparator);
    }


    /**
     * Sorted the object default with comparable
     *
     * @param nums
     */
    public void quickSorted(Object[] nums) {
        if (nums.length < 2) return;
        threeWayQuickSorted(nums, 0, nums.length - 1, null);
    }


    /**
     * @param nums
     * @param lo
     * @param hi
     * @param numberComparision
     * @param wayToPickPivot    default is first, 1 is pick last pivot
     * @return numbers of comparisons occurs while sorted the the input arrays
     */
    public long twoWayQuickSortedFirstPivot(Object[] nums, int lo, int hi, long numberComparision, int wayToPickPivot) {
        if (lo >= hi) return 0;
        if (wayToPickPivot == 1) swapByIndex(nums, lo, hi);
        else if (wayToPickPivot == 2) {
            int medianIndex = lo + (hi - lo) / 2;
            medianIndex = pickMedianOfTheThree(nums, lo, medianIndex, hi);
            if (medianIndex != lo) swapByIndex(nums, lo, medianIndex);

        }
        int pivot = twoWayQuickSortedPartitioningPickFirst(nums, lo, hi);
        long numberComparisionOnTheLeft = twoWayQuickSortedFirstPivot(nums, lo, pivot - 1, numberComparision, wayToPickPivot);
        long numberComparisionOnTheRight = twoWayQuickSortedFirstPivot(nums, pivot + 1, hi, numberComparision, wayToPickPivot);
        numberComparision += (hi - lo) + numberComparisionOnTheLeft + numberComparisionOnTheRight;
        return numberComparision;
    }

    private int pickMedianOfTheThree(Object[] nums, int lo, int mid, int hi) {
        Comparable<? super Object> loComparable = (Comparable<? super Object>) nums[lo];
        Comparable<? super Object> midComparable = (Comparable<? super Object>) nums[mid];
        boolean loLessThanHi = loComparable.compareTo(nums[hi]) < 0;
        boolean loGreaterThanHi = loComparable.compareTo(nums[hi]) > 0;
        boolean loGreaterThanMid = loComparable.compareTo(nums[mid]) > 0;
        boolean loLessThanMid = loComparable.compareTo(nums[mid]) < 0;
        boolean midLessThanHi = midComparable.compareTo(nums[hi]) < 0;
        boolean midGreaterThanHi = midComparable.compareTo(nums[hi]) > 0;
        if ((loGreaterThanHi && loLessThanMid) || (loGreaterThanMid && loLessThanHi))
            return lo;
        else if ((loLessThanMid && midLessThanHi) || (midGreaterThanHi && loGreaterThanMid))
            return mid;
        else return hi;
    }

    private void swapByIndex(Object[] nums, int firstIndex, int secondIndex) {
        Object temp = nums[firstIndex];
        nums[firstIndex] = nums[secondIndex];
        nums[secondIndex] = temp;
    }


    /**
     * The Invariant we need to maintain is to keep the lessThan < pivot < greaterThan
     *
     * @param nums
     * @param lo
     * @param hi
     * @return
     */
    // Assume the pivot is already swap on the left most array
    public int twoWayQuickSortedPartitioningPickFirst(Object[] nums, int lo, int hi) {
        Object pivotValue = nums[lo];
        Comparable<? super Object> pivotValueComparable = (Comparable<? super Object>) pivotValue;
        int lessThan = lo + 1;
        for (int greaterThan = lessThan; greaterThan <= hi; greaterThan++) {
            if (pivotValueComparable.compareTo(nums[greaterThan]) > 0) {
                Object temp = nums[greaterThan];
                nums[greaterThan] = nums[lessThan];
                nums[lessThan] = temp;
                lessThan++; // increase less than by one since one more less than element
            }
        }
        nums[lo] = nums[lessThan - 1];
        nums[lessThan - 1] = pivotValue;
        return lessThan - 1;
    }

    public void threeWayQuickSorted(Object[] nums, int lo, int hi, Comparator<? super Object> comparator) {
        if (lo >= hi) return;
        int pivot = ThreadLocalRandom.current().nextInt(lo, hi + 1);
        Object temp = nums[pivot];
        nums[pivot] = nums[lo];
        nums[lo] = temp;
        int[] twoIndex;
        if (comparator == null) {
            twoIndex = threeWayPartitioning(nums, lo, hi);
        } else {
            twoIndex = threeWayPartitioning(nums, lo, hi, comparator);
        }
        threeWayQuickSorted(nums, lo, twoIndex[0], comparator);
        threeWayQuickSorted(nums, twoIndex[1], hi, comparator);
    }

    // Assume the pivot is already swap on the left most array
    private int[] threeWayPartitioning(Object[] nums, int lo, int hi) {
        Object pivotValue = nums[lo];
        Comparable<? super Object> pivotValueComparable = (Comparable<? super Object>) pivotValue;
        int lessThanPivot = lo;
        int greaterThanPivot = hi;
        int equalToPivot = lo + 1;
        while (lessThanPivot <= equalToPivot && equalToPivot <= greaterThanPivot) {
            if (pivotValueComparable.compareTo(nums[equalToPivot]) > 0) {
                Object temp = nums[lessThanPivot];
                nums[lessThanPivot] = nums[equalToPivot];
                nums[equalToPivot] = temp;
                lessThanPivot++;
                equalToPivot++;
            } else if (pivotValueComparable.compareTo(nums[equalToPivot]) < 0) {
                Object temp = nums[greaterThanPivot];
                nums[greaterThanPivot] = nums[equalToPivot];
                nums[equalToPivot] = temp;
                greaterThanPivot--;
            } else equalToPivot++;
        }
        return new int[]{lessThanPivot, equalToPivot};
    }

    private int[] threeWayPartitioning(Object[] nums, int lo, int hi, Comparator<? super Object> comparator) {

        Object pivotValue = nums[lo];
        int lessThanPivot = lo;
        int greaterThanPivot = hi;
        int equalToPivot = lo + 1;
        while (lessThanPivot <= equalToPivot && equalToPivot <= greaterThanPivot) {
            if (comparator.compare(pivotValue, nums[equalToPivot]) > 0) {
                Object temp = nums[lessThanPivot];
                nums[lessThanPivot] = nums[equalToPivot];
                nums[equalToPivot] = temp;
                lessThanPivot++;
                equalToPivot++;
            } else if (comparator.compare(pivotValue, nums[equalToPivot]) < 0) {
                Object temp = nums[greaterThanPivot];
                nums[greaterThanPivot] = nums[equalToPivot];
                nums[equalToPivot] = temp;
                greaterThanPivot--;
            } else equalToPivot++;
        }
        return new int[]{lessThanPivot, equalToPivot};
    }
}
