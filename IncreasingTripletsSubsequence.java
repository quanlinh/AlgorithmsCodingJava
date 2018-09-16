public class IncreasingTripletsSubsequence {
    public boolean increasingTriplet(int[] nums) {
        int least = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n <= least) least = n;
            else if (n <= mid) mid = n;
            else return true;
        }
        return false;
    }
}
