import java.util.ArrayList;

public class LongestIncreasingSubsequence {

    public int findLongestIncreasingSubsequence(int[] nums) {
        // degenerate case
        int size = nums.length;
        if(size == 0) return 0;
        if(size == 1) return 1;
        int[] lisArray = new int[size];
        for(int i = 0; i < lisArray.length; i++)
            lisArray[i] = 1;
        int longestIncreasingSub = 1;
        for(int j = 1; j < size; j++)
        {
            int presentValue = nums[j];
            for(int i = 0; i < j; i++)
            {
                if(nums[i] < presentValue)
                {
                    int maxSofar = lisArray[i]+1;
                    if(maxSofar > lisArray[j]) lisArray[j] = maxSofar;
                    if(lisArray[j] > longestIncreasingSub) longestIncreasingSub = lisArray[j];
                }
            }
        }
        return longestIncreasingSub;

    }
    public ArrayList<Integer> findLongestIncreasingSubSequencesByPatienceSorted(int[] nums)
    {
        int size = nums.length;
        if (size == 0) return  new ArrayList<>();
        if (size == 1) {
            ArrayList<Integer> a = new ArrayList<>();
            a.add(nums[0]);
            return a;
        }
        ArrayList<int[]> arrayOfStack = new ArrayList<>();
        int[] fistElement = {nums[0]};
        arrayOfStack.add(fistElement);
        int[][] backTrackArray = new int[size][2];
        backTrackArray[0][0] = Integer.MIN_VALUE;
        backTrackArray[0][1] = nums[0];
        for (int i = 1; i < size; i++)
        {
            int stackIndex = binarySearch(arrayOfStack,nums[i]);
            if(stackIndex >= arrayOfStack.size()) {
                int[] oneElement = new int[1];
                arrayOfStack.add(oneElement);
            }
            int[] valueAtIndex  = arrayOfStack.get(stackIndex);
            valueAtIndex[0] = nums[i];
            arrayOfStack.set(stackIndex,valueAtIndex);
            if(stackIndex == 0)
            {
                backTrackArray[i][0] = Integer.MIN_VALUE;
            } else {
                backTrackArray[i][0] = arrayOfStack.get(stackIndex-1)[0];
            }
            backTrackArray[i][1] =  nums[i];
        }

        ArrayList<Integer> res = new ArrayList<>();
        // insert the last element to back track
        int lastElement = arrayOfStack.get(arrayOfStack.size()-1)[0];
        res.add(lastElement);
        while(size > 0)
        {
            size--;
            int previous = backTrackArray[size][0];
            int current = backTrackArray[size][1];
            if (current == lastElement && previous == Integer.MIN_VALUE) break;
            if(current == lastElement)
            {
                res.add(previous);
                lastElement = previous;
            }
        }
        return res;

    }

    private int binarySearch(ArrayList<int[]> nums, int key)
    {
        return binarySearchRangeLeft(nums, key, 0, nums.size()-1);
    }

    private int binarySearchRangeLeft(ArrayList<int[]> nums, int key, int lo, int hi)
    {
        if (lo > hi) return hi + 1;
        int mid = (lo + hi) / 2;
        if (nums.get(mid)[0] >= key)
        {
            if(mid > 0 &&  nums.get(mid-1)[0] >= key) return binarySearchRangeLeft(nums,key,0,mid-1);
            else return mid;
        }
        else return binarySearchRangeLeft(nums,key,mid+1,hi);
    }

}

