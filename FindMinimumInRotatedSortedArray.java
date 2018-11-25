public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {

        // two way to stop, number on the right less than number on the left
        // or out of bound
        // left search
        // right search
        if (nums.length < 2) return nums[0];
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[lo] > nums[mid]) {
                if (lo + 1 == mid) return nums[mid];
                hi = mid;
            } else if (nums[hi] < nums[mid]) {
                if (hi - 1 == mid) return nums[hi];
                lo = mid;
            } else break;
        }

        return Math.min(nums[hi], nums[lo]);
    }
}
