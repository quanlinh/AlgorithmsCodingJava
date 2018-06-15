public class insertIntoPosition
{
    // remember to deal with it in the middle of array such as [1,3], 2
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int lo = 0;
        int hi = n - 1;
        int mid = (lo + hi) / 2;
        while (mid >= lo && mid <= hi) {
            int valueAtMid = nums[mid];
            if (valueAtMid == target) return mid;
            else if (target < valueAtMid) {
                hi = --mid;
                if (hi < lo) {
                    // this is the case it had move to the left
                    // and lo is the last position
                    // Should it return lo?
                    // deal with the position insert
                    // assume it should go her
                    if (hi < 0 ) return 0;
                    else         return lo;
                }
                else mid = (lo + hi) / 2;
            } else {// if (target > valueAtMid)
                lo = ++mid;
                if (hi < lo)   return lo;
                else mid = (lo + hi) / 2;
            }
        }
        throw  new IllegalStateException("it should not reach here");
    }

}
