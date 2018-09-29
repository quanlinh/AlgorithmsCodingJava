import java.util.ArrayList;
import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public int findLongestIncreasingSubsequence(int[] nums) {
        // degenerate case
        int size = nums.length;
        if (size < 2) return nums.length;
        int[] lisArray = new int[size];
        for (int i = 0; i < lisArray.length; i++)
            lisArray[i] = 1;
        int longestIncreasingSub = 1;
        for (int j = 1; j < size; j++) {
            int presentValue = nums[j];
            for (int i = 0; i < j; i++) {
                if (nums[i] < presentValue) {
                    int maxSofar = lisArray[i] + 1;
                    if (maxSofar > lisArray[j]) lisArray[j] = maxSofar;
                    if (lisArray[j] > longestIncreasingSub) longestIncreasingSub = lisArray[j];
                }
            }
        }
        return longestIncreasingSub;

    }

    public ArrayList<Integer> findLongestIncreasingSubSequencesByPatienceSorted(int[] nums) {
        int size = nums.length;
        if (size == 0) return new ArrayList<>();
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
        for (int i = 1; i < size; i++) {
            int stackIndex = binarySearch(arrayOfStack, nums[i]);
            if (stackIndex >= arrayOfStack.size()) {
                int[] oneElement = new int[1];
                arrayOfStack.add(oneElement);
            }
            int[] valueAtIndex = arrayOfStack.get(stackIndex);
            valueAtIndex[0] = nums[i];
            arrayOfStack.set(stackIndex, valueAtIndex);
            if (stackIndex == 0) {
                backTrackArray[i][0] = Integer.MIN_VALUE;
            } else {
                backTrackArray[i][0] = arrayOfStack.get(stackIndex - 1)[0];
            }
            backTrackArray[i][1] = nums[i];
        }

        ArrayList<Integer> res = new ArrayList<>();
        // insert the last element to back track
        int lastElement = arrayOfStack.get(arrayOfStack.size() - 1)[0];
        res.add(lastElement);
        while (size > 0) {
            size--;
            int previous = backTrackArray[size][0];
            int current = backTrackArray[size][1];
            if (current == lastElement && previous == Integer.MIN_VALUE) break;
            if (current == lastElement) {
                res.add(previous);
                lastElement = previous;
            }
        }
        return res;

    }

    public int lengthOfLIS(int[] nums) {
        int size = nums.length;

        if (size < 2) return size;
        ArrayList<int[]> arrayOfStack = new ArrayList<>();
        int[] fistElement = {nums[0]};
        arrayOfStack.add(fistElement);
        int[][] backTrackArray = new int[size][2];
        backTrackArray[0][0] = Integer.MIN_VALUE;
        backTrackArray[0][1] = nums[0];
        for (int i = 1; i < size; i++) {
            int stackIndex = binarySearch(arrayOfStack, nums[i]);
            if (stackIndex >= arrayOfStack.size()) {
                int[] oneElement = new int[1];
                arrayOfStack.add(oneElement);
            }
            int[] valueAtIndex = arrayOfStack.get(stackIndex);
            valueAtIndex[0] = nums[i];
            arrayOfStack.set(stackIndex, valueAtIndex);
            if (stackIndex == 0) {
                backTrackArray[i][0] = Integer.MIN_VALUE;
            } else {
                backTrackArray[i][0] = arrayOfStack.get(stackIndex - 1)[0];
            }
            backTrackArray[i][1] = nums[i];
        }

        ArrayList<Integer> res = new ArrayList<>();
        // insert the last element to back track
        int lastElement = arrayOfStack.get(arrayOfStack.size() - 1)[0];
        res.add(lastElement);
        while (size > 0) {
            size--;
            int previous = backTrackArray[size][0];
            int current = backTrackArray[size][1];
            if (current == lastElement && previous == Integer.MIN_VALUE) break;
            if (current == lastElement) {
                res.add(previous);
                lastElement = previous;
            }
        }
        return res.size();

    }

    private int binarySearch(ArrayList<int[]> nums, int key) {
        return binarySearchRangeLeft(nums, key, 0, nums.size() - 1);
    }

    private int binarySearchRangeLeft(ArrayList<int[]> nums, int key, int lo, int hi) {
        if (lo > hi) return hi + 1;
        int mid = (lo + hi) / 2;
        if (nums.get(mid)[0] >= key) {
            if (mid > 0 && nums.get(mid - 1)[0] >= key) return binarySearchRangeLeft(nums, key, 0, mid - 1);
            else return mid;
        } else return binarySearchRangeLeft(nums, key, mid + 1, hi);
    }

    /**
     * Arrays.binarySearch() method returns index of the search key, if it is contained in the array, else it returns
     * (-(insertion point) - 1). The insertion point is the point at which the key would be inserted into the array:
     * the index of the first element greater than the key,
     * or a.length if all elements in the array are less than the specified key.
     *
     * @param nums
     * @return
     *
     * WARNING : THIS IS NOT A CORRECT SOLUTIONS :(
     */

    public int lenthOFLongestIncreasingSubsequenceOptimalSpace(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) len++;
        }
        return len;
    }

    public int binarySearchArraysVersion(int[] nums, int fromIndex, int toIndex, int target) {
        int lo = fromIndex;
        int hi = toIndex - 1;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            int valMid = nums[mid];
            if (target < valMid)
                hi = mid - 1;
            else if (target > valMid)
                lo = mid + 1;
            else return mid; // key found
        }
        return -(lo + 1); // key not found
    }

    private void rangeCheck(int fromIndex, int toIndex) {
        if (fromIndex > toIndex)
            throw new IllegalArgumentException(" out of range from " + fromIndex + " to " + toIndex);
    }
}

