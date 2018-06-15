import java.util.HashMap;

public class twoSumBruteForceAndOptimize {
    public int[] twoSum(int[] nums, int target) {
        int size = nums.length;
        if(size == 0 || size == 1) return new int[0];
        int[] sum = new int[2];
        HashMap<Integer,Integer> complementSumPair = new HashMap<>();
        complementSumPair.put(target - nums[0], 0); // should I put the value for fence post instead of complement
        for (int i = 1; i < size; i++)
        {
//            System.out.println(comp);
            int valueNeedToSum = nums[i];
            if(complementSumPair.containsKey(valueNeedToSum))
            {
                sum[0] = complementSumPair.get(valueNeedToSum);
                sum[1] = i;
                return sum;
            } else
            {
                int comp = target - valueNeedToSum;
                complementSumPair.put(comp,i);
            }

        }
        return new int[0];
    }
}
