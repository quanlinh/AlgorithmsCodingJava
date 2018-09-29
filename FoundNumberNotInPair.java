public class FoundNumberNotInPair {
    // TODO not sure how to split the array to odd and even each time
    public int foundNumberNotInPair(int[] nums) {
        return findOddBinarySearch(nums, 0, nums.length - 1);
    }

    /**
     * Set Even On Left and Odd on Right
     *
     * @param nums
     * @param lo
     * @param hi
     * @return
     */
    private int findOddBinarySearch(int[] nums, int lo, int hi) {
        if (lo >= hi) return nums[hi];
        int mid = (lo + hi) / 2;
        if (mid % 2 == 1) mid--;
        if (nums[mid] != nums[mid + 1]) return findOddBinarySearch(nums, lo, mid);
        else return findOddBinarySearch(nums, mid + 2, hi);
    }
}
