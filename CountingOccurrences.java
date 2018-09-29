public class CountingOccurrences {
    /*
        The @nums array is need to be sorted, the
        behavior will be unexpected otherwise
        This function counting how many times an element occurs in
        an arrays.
     */
    public int numberOfOccurrences(int[] nums, int target) {
        int size = nums.length;
        int rightIndex = searchRightIndex(nums, target, 0, size - 1);
        int leftIndex = searchLeftIndex(nums, target, 0, size - 1);
        assert (rightIndex - leftIndex - 1 >= 0);
        return rightIndex - leftIndex - 1;
    }

    public int searchRightIndex(int[] nums, int target, int lo, int hi) {
        if (lo > hi) return lo;
        int mid = (lo + hi) / 2;
        if (target < nums[mid]) return searchRightIndex(nums, target, lo, mid - 1);
        else return searchRightIndex(nums, target, mid + 1, hi);
    }

    public int searchLeftIndex(int[] nums, int target, int lo, int hi) {
        if (lo > hi) return hi;
        int mid = (lo + hi) / 2;
        if (target <= nums[mid]) return searchLeftIndex(nums, target, lo, mid - 1);
        else return searchLeftIndex(nums, target, mid + 1, hi);
    }

    public int[] rangeSearch(int[] nums, int target) {
        int[] indexRange = {-1, -1};
        int size = nums.length;
        int leftIndex = searchLeftIndex(nums, target, 0, size - 1) + 1;
        int rightIndex = searchRightIndex(nums, target, 0, size - 1) - 1;
        if (leftIndex <= rightIndex) {
            indexRange[0] = leftIndex;
            indexRange[1] = rightIndex;
        }
        return indexRange;

    }
}
