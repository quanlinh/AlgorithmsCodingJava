import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class ThreeSumSetProblems {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> resThreeSum = new ArrayList<>();
        for(int i = 0; i <= nums.length - 3 && nums[i] <= 0; i++) {

            int target = - nums[i];
            int left = i + 1, right = nums.length-1;
            if(i == 0 || (i > 0 && nums[i] != nums[i-1])) {

                while(left < right) {
                    int sum = nums[left] + nums[right];
                    if(sum == target) {
                        resThreeSum.add(Arrays.asList(nums[i],nums[left],nums[right]));
                        while(left < right && nums[left] == nums[left+1]) left++;
                        while(right > left && nums[right] == nums[left-1]) right--;
                        left++;
                        right--;

                    } else if(sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }

            }
        }

        return resThreeSum;
    }
}

