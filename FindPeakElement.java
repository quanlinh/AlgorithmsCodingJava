public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        if(nums.length == 0) return Integer.MIN_VALUE;
        return findPeak(nums,0,nums.length-1);

    }

    private int findPeak(int[] nums, int lo, int hi) {
        int mid = (lo + hi) /2 ;
        if(mid-1 >= 0  && nums[mid] < nums[mid-1]) return findPeak(nums,lo,mid-1);
        else if(mid+1   < nums.length &&  nums[mid] < nums[mid+1]) return findPeak(nums, mid+1,hi);
        else return mid;
    }
}
