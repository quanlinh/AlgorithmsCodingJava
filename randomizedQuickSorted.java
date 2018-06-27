import java.util.concurrent.ThreadLocalRandom;

public class randomizedQuickSorted {
    public void quickSorted(int[] nums)
    {
        if (nums.length < 2) return;
        threeWayQuickSorted(nums, 0, nums.length-1);

    }
    public void threeWayQuickSorted(int [] nums,int lo, int hi)
    {
        if(lo >= hi) return;
        int pivot = ThreadLocalRandom.current().nextInt(lo, hi  + 1);
        int temp = nums[pivot];
        nums[pivot] = nums[lo];
        nums[lo] = temp;
        int[] twoIndex = threeWayPartitioning(nums,lo,hi);
        threeWayQuickSorted(nums,lo, twoIndex[0]);
        threeWayQuickSorted(nums,twoIndex[1],hi);

    }
    // Assume the pivot is alreay swap on the left most array
    private int[] threeWayPartitioning(int[] nums,int lo, int hi)
    {
        int pivotValue = nums[lo];
        int lessThan  = lo;
        int greaterThan = hi;
        int i = lo + 1;
        while(lessThan <= i && i <= greaterThan)
        {
            if(nums[i] < pivotValue)
            {
                int temp = nums[lessThan];
                nums[lessThan] = nums[i];
                nums[i] = temp;
                lessThan++;
                i++;
            }
            else if(nums[i] > pivotValue)
            {
                int temp = nums[greaterThan];
                nums[greaterThan] = nums[i];
                nums[i] = temp;
                greaterThan--;
            } else i++;
        }
        int[] twoIndex = {lessThan,i};
        return  twoIndex;
    }
}
