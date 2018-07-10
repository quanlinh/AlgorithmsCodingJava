import java.util.concurrent.ThreadLocalRandom;

public class randomizedQuickSorted {
    public void quickSorted(int[] nums) {
        if (nums.length < 2) return;
        threeWayQuickSorted(nums, 0, nums.length - 1);

    }


    /**
     * @param nums
     * @param lo
     * @param hi
     * @param numberComparision
     * @param wayToPickPivot    default is first, 1 is pick last pivot
     * @return numbers of comparisons occurs while sorted the the input arrays
     */
    public long twoWayQuickSortedFirstPivot(int[] nums, int lo, int hi, long numberComparision, int wayToPickPivot) {
        if (lo >= hi) return 0;
        if (wayToPickPivot == 1) swapByIndex(nums, lo, hi);
        else if (wayToPickPivot == 2) {
            int medianIndex = lo + (hi -lo) / 2 ;
//            System.out.println(medianIndex + "\t median index");
            medianIndex = pickMedianOfTheThree(nums, lo, medianIndex, hi);
//            swapByIndex(nums, lo, medianIndex);
            if (medianIndex != lo) swapByIndex(nums, lo, medianIndex);

        }
        int pivot = twoWayQuickSortedPartitioningPickFirst(nums, lo, hi);
        long numberComparisionOnTheLeft = twoWayQuickSortedFirstPivot(nums, lo, pivot - 1, numberComparision, wayToPickPivot);
        long numberComparisionOnTheRight = twoWayQuickSortedFirstPivot(nums, pivot + 1, hi, numberComparision, wayToPickPivot);
        numberComparision += (hi - lo) + numberComparisionOnTheLeft + numberComparisionOnTheRight;
//        System.out.println(numberComparision + " number of comparison");
        return numberComparision;
    }

    private int pickMedianOfTheThree(int[] nums, int lo, int medianIndex, int hi) {
        if ((nums[hi] < nums[lo] && nums[lo] < nums[medianIndex]) || (nums[medianIndex] < nums[lo] && nums[lo] < nums[hi]))
            return lo;
        else if ((nums[lo] < nums[medianIndex] && nums[medianIndex] < nums[hi]) || (nums[hi] < nums[medianIndex] && nums[medianIndex] < nums[lo]))
            return medianIndex;
        else return hi;
    }

    private void swapByIndex(int[] nums, int firstIndex, int secondIndex) {
        int temp = nums[firstIndex];
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
    public int twoWayQuickSortedPartitioningPickFirst(int[] nums, int lo, int hi) {
        int pivotValue = nums[lo];
        int lessThan = lo + 1;
        for (int greaterThan = lessThan; greaterThan <= hi; greaterThan++) {
            if (nums[greaterThan] < pivotValue) {
                int temp = nums[greaterThan];
                nums[greaterThan] = nums[lessThan];
                nums[lessThan] = temp;
                lessThan++; // increase less than by one since one more less than element
            }
        }
        nums[lo] = nums[lessThan - 1];
        nums[lessThan - 1] = pivotValue;
        return lessThan - 1;
    }

    public void threeWayQuickSorted(int[] nums, int lo, int hi) {
        if (lo >= hi) return;
        int pivot = ThreadLocalRandom.current().nextInt(lo, hi + 1);
        int temp = nums[pivot];
        nums[pivot] = nums[lo];
        nums[lo] = temp;
        int[] twoIndex = threeWayPartitioning(nums, lo, hi);
        threeWayQuickSorted(nums, lo, twoIndex[0]);
        threeWayQuickSorted(nums, twoIndex[1], hi);
    }

    // Assume the pivot is already swap on the left most array
    private int[] threeWayPartitioning(int[] nums, int lo, int hi) {
        int pivotValue = nums[lo];
        int lessThanPivot = lo;
        int greaterThanPivot = hi;
        int equalToPivot = lo + 1;
        while (lessThanPivot <= equalToPivot && equalToPivot <= greaterThanPivot) {
            if (nums[equalToPivot] < pivotValue) {
                int temp = nums[lessThanPivot];
                nums[lessThanPivot] = nums[equalToPivot];
                nums[equalToPivot] = temp;
                lessThanPivot++;
                equalToPivot++;
            } else if (nums[equalToPivot] > pivotValue) {
                int temp = nums[greaterThanPivot];
                nums[greaterThanPivot] = nums[equalToPivot];
                nums[equalToPivot] = temp;
                greaterThanPivot--;
            } else equalToPivot++;
        }
        return new int[]{lessThanPivot, equalToPivot};
    }
}
