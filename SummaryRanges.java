import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        // O(N) space O(1)
        List<String> range = new ArrayList<>();
        for(int i = 1; i <= nums.length; i++) {
            StringBuilder sb  = new StringBuilder();
            sb.append(nums[i-1]);
            int k = i;
            while(i < nums.length && nums[i-1] + 1 == nums[i]) i++;
            if(k != i) {
                sb.append("->");
                sb.append(nums[i-1]);
            }
            range.add(sb.toString());
        }
        return range;
    }

}
