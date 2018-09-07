import java.util.ArrayList;
import java.util.List;

public class FindFirstMissingPositive {

    public int segaratePositive(int[] nums) {
        int negative = 0, positive = 1;
        while (negative < positive && positive < nums.length) {
            while (positive < nums.length && nums[positive] > 0) positive++;
            if (positive >= nums.length) break;
            if (nums[negative] > 0) negative--;
            int temp = nums[positive];
            nums[positive] = nums[negative + 1];
            nums[negative + 1] = temp;
            negative++;
        }
        if (nums[negative] > 0) return negative;
        else return negative + 1;
    }

    public int[] removeZeroAndNegative(int[] nums) {
        ArrayList<Integer> listOfPositive = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) listOfPositive.add(nums[i]);
        }
        int[] val = new int[listOfPositive.size()];
        for (int i = 0; i < listOfPositive.size(); i++) {
            val[i] = listOfPositive.get(i);
        }
        return val;
    }

    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0) return 1;
        int[] listOfPositive = removeZeroAndNegative(nums);
        for (int i = 0; i < listOfPositive.length; i++) {
            int index = Math.abs(listOfPositive[i]) - 1;
            if (index < listOfPositive.length && listOfPositive[index] > 0) {
                listOfPositive[index] = -listOfPositive[index];
            }
        }
        for (int i = 0; i < listOfPositive.length; i++) {
            if (listOfPositive[i] > 0) return i + 1;
        }
        return listOfPositive.length + 1;

    }

    public int firstMissingPositiveImprove(int[] nums) {
        if (nums.length == 0) return 1;
        int shiftIndex = segaratePositive(nums);
        System.out.println(shiftIndex + " hs");
//        int size = nums.length-shiftIndex;

        for (int i = shiftIndex; i < nums.length; i++) {
            int index = Math.abs(nums[i]);
            if (index < nums.length && nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }
        for (int i = shiftIndex; i < nums.length; i++) {
            if (nums[i] > 0) return i;
        }
        return nums.length + 1 - shiftIndex;

    }

    public int firstMissingPositiveSuperGenious(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                int swapIndex = nums[i] - 1;
                int temp = nums[i];
                nums[i] = nums[swapIndex];
                nums[swapIndex] = temp;

            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
