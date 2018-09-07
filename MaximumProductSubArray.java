public class MaximumProductSubArray {
    public int maxProduct(int[] nums) {
        // Keeping track of the maximum sub arrays.
        int currentMaxProductStart = 0;
        int currentMaxProductEnd = 0;
        int maxProductStart = 0;
        int maxProductEnd = 0;
        int minProductStart = 0;
        int minProductEnd = 0;
        for (int j = 1; j < nums.length; j++) {
            if (product(nums, currentMaxProductStart, j) < product(nums, minProductStart, minProductEnd)) {
                minProductStart = currentMaxProductStart;
                minProductEnd = currentMaxProductEnd;
            }
            if (product(nums, currentMaxProductStart, j) <= nums[j]) {
                currentMaxProductStart = currentMaxProductEnd = j;
            } else currentMaxProductEnd = j;
            // update the max product
            if (product(nums, currentMaxProductStart, currentMaxProductEnd) > product(nums, maxProductStart, maxProductEnd)) {
                maxProductStart = currentMaxProductStart;
                maxProductEnd = currentMaxProductEnd;
            }

        }
        return product(nums, maxProductStart, maxProductEnd);
    }

    public int product(int[] nums, int start, int end) {
        if (start == end) return nums[start];
        int product = nums[start];
        for (int i = start + 1; i <= end; i++) product *= nums[i];
        return product;
    }
}
