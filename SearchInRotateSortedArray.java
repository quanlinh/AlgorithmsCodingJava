public class SearchInRotateSortedArray {
    public int search(int[] nums, int target) {
        return binarySearchPivot(nums, 0, nums.length - 1, target);
    }

    private int binarySearchPivot(int[] nums, int lo, int hi, int target) {
        if (lo == hi) {
            if (nums[lo] == target) return lo;
            else return -1;
        }
        if (lo > hi) return -1;
        int mid = (lo + hi) / 2;
        if (nums[mid] == target) return mid;
        else if (nums[lo] < nums[mid]) { // array of lo to mid is sorted
            if (nums[lo] <= target && target < nums[mid]) return binarySearchPivot(nums, lo, mid - 1, target);
            else return binarySearchPivot(nums, mid + 1, hi, target);
        } else { // arr[mid+1 --- r] must be sorted
            if (mid < nums.length && nums[mid + 1] <= target && target <= nums[hi])
                return binarySearchPivot(nums, mid + 1, hi, target);
            else return binarySearchPivot(nums, lo, mid - 1, target);
        }
    }



    private boolean binarySearchPivotAllowDuplicate(int[] nums, int lo, int hi, int target) {
        if (lo == hi) {
            return nums[lo] == target;
        }
        if (lo > hi) return false;
        int mid = (lo + hi) / 2;
        if (nums[mid] == target) return true;
        if(nums[lo] == nums[mid] && nums[mid] == nums[hi]) {
            return binarySearchPivotAllowDuplicate(nums, lo, mid - 1, target) || binarySearchPivotAllowDuplicate(nums, mid+1, hi, target);
        }
        else if (nums[lo] <= nums[mid]) { // array of lo to mid is sorted
            if (nums[lo] <= target && target <= nums[mid]) return binarySearchPivotAllowDuplicate(nums, lo, mid - 1, target);
            else return binarySearchPivotAllowDuplicate(nums, mid + 1, hi, target);
        } else { // arr[mid+1 --- r] must be sorted
            if (mid < nums.length && nums[mid+1] <= target && target <= nums[hi])
                return binarySearchPivotAllowDuplicate(nums, mid + 1, hi, target);
            else return binarySearchPivotAllowDuplicate(nums, lo, mid - 1, target);
        }
    }


}
