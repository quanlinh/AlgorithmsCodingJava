import java.util.ArrayList;
import java.util.List;

public class GenerateSubsets {
    public List<List<Integer>> subsets(int[] nums) {
        int numSubset  = (int)Math.pow(2,nums.length);
        List<List<Integer>> subSets = new ArrayList<>(numSubset);
        for(int i = 0; i < numSubset; i++)            subSets.add(new ArrayList<>());
        System.out.println(subSets.size());
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < numSubset; j++) {
                if( ((j >> i) & 1 ) == 1)
                    subSets.get(j).add(nums[i]);
            }
        }
        return subSets;
    }
}
